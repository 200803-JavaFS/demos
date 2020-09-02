FROM tomcat:8-jre8-alpine
#You can put a comment here
RUN rm -rf /usr/local/tomcat/webapps/*
#Cleans the webapps folder
COPY HelloServlets.war /usr/local/tomcat/webapps/HelloServlets.war
#Copy takes the artifact from the file directory where the dockerfile is and places in the tomcat webapps folder. 
CMD ["catalina.sh", "run"]
#Will "run catalina.sh" on the command line when the container is spun up. This will start tomcat with whatever applications are in the webapps fodler. 