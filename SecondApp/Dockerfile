# Install Tomcat & openjdk 8 (openjdk has java and javac)
FROM tomcat:jdk8-openjdk
# Copy source files to tomcat folder structure
RUN ["mkdir","/usr/local/tomcat/webapps/SecondApp"]
COPY . /usr/local/tomcat/webapps/SecondApp
# -cp, Adding compile time classpath as Tomcat's /lib/servlet-api.jar file.
# - d, destination output location.
RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/SecondApp/WEB-INF/classes/", "/usr/local/tomcat/webapps/SecondApp/src/TestingServlet.java"]

RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/SecondApp/WEB-INF/classes/", "/usr/local/tomcat/webapps/SecondApp/src/SecondApplicationServlet.java"]

# Serve Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
