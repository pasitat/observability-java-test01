# Install Tomcat & openjdk 8 (openjdk has java and javac)
FROM tomcat:jdk8-openjdk
# Copy source files to tomcat folder structure
RUN ["mkdir","/usr/local/tomcat/webapps/tomcathello"]
COPY . /usr/local/tomcat/webapps/tomcathello
#RUN ["ls","-l","/usr/local/tomcat/webapps/"]
#RUN ["ls","-l","/usr/local/tomcat/webapps/tomcathello"]
#RUN ["ls","-l","/usr/local/tomcat/lib/servlet-api.jar"]
# -cp, Adding compile time classpath as Tomcat's /lib/servlet-api.jar file.
# - d, destination output location.
RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/tomcathello/WEB-INF/classes/", "/usr/local/tomcat/webapps/tomcathello/src/TestingServlet.java"]

#RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/tomcathello/WEB-INF/classes/", "/usr/local/tomcat/webapps/tomcathello/src/ContactFormServlet.java"]

RUN ["javac", "-cp", ".:/usr/local/tomcat/lib/servlet-api.jar", "-d", "/usr/local/tomcat/webapps/tomcathello/WEB-INF/classes/", "/usr/local/tomcat/webapps/tomcathello/src/SecondApplicationServlet.java"]

# Serve Tomcat
EXPOSE 8080
CMD ["catalina.sh", "run"]
