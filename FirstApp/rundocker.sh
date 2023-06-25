docker build -t firstapp .
docker run -d -p 8081:8080 firstapp
sleep 2
curl http://localhost:8081/FirstApp/FirstApplication
