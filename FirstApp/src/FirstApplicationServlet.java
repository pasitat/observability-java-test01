import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstApplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Generate a random number from 1 to 100
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

        response.getWriter().println("Hello from app1");
        response.getWriter().println("Random number is " + randomNumber);
        response.getWriter().println("Calling App2 at");
        response.getWriter().println("http://172.26.48.58/:8082/SecondApp/SecondApplication?number=" + randomNumber);

        // Call the second application's endpoint with the random number
        String secondAppEndpoint = "http://172.26.48.58:8082/SecondApp/SecondApplication?number=" + randomNumber;
        String secondAppResponse = callEndpoint(secondAppEndpoint);

        // Set the response content type
        response.setContentType("text/plain");

        // Write the response from the second application to the client
        response.getWriter().println(secondAppResponse);
    }

    private String callEndpoint(String endpointURL) {
        StringBuilder responseBuilder = new StringBuilder();
        try {
            URL url = new URL(endpointURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }
            reader.close();

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseBuilder.toString();
    }
}

