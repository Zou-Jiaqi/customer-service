FROM public.ecr.aws/docker/library/eclipse-temurin:22-jre-alpine

WORKDIR /usr/share/app

COPY target/*.jar app.jar

EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]