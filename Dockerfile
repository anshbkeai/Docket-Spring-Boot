# So this about that image about the from Creating about the
FROM eclipse-temurin:24-jdk-slim 

WORKDIR /app

COPY target/*.war app.war


CMD ["java" , "-jar" ,"app.war"]
