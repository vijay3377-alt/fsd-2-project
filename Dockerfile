FROM tomcat:10.1-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/RegistrationProject.war /usr/local/tomcat/webapps/ROOT.war

RUN sed -i 's/port="8080"/port="10000"/' /usr/local/tomcat/conf/server.xml

EXPOSE 10000

<<<<<<< HEAD
CMD ["catalina.sh", "run"]
=======
CMD ["catalina.sh", "run"]
>>>>>>> 26b91d69661ce22dee6a0651b7a82454a8e45c0f
