# Install Tomcat & openjdk 8 (openjdk has java and javac)
FROM tomcat:jdk8-openjdk
# Copy source files to tomcat folder structure
RUN ["mkdir","/usr/local/tomcat/webapps/FirstApp"]
COPY . /usr/local/tomcat/webapps/FirstApp
# -cp, Adding compile time classpath as Tomcat's /lib/servlet-api.jar file.
# - d, destination output location.
RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/FirstApp/WEB-INF/classes/", "/usr/local/tomcat/webapps/FirstApp/src/TestingServlet.java"]

RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/FirstApp/WEB-INF/classes/", "/usr/local/tomcat/webapps/FirstApp/src/FirstApplicationServlet.java"]

# Serve Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
