import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondApplicationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Extract the number parameter from the request
        String numberParam = request.getParameter("number");
        int waitTime = Integer.parseInt(numberParam);

        // Wait for waitTime milliseconds
        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return the response
        response.getWriter().println("Hello from App2. I have waited for " + waitTime + " milliseconds.");
    }
}

