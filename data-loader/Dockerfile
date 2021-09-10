FROM java:8-jdk-alpine
COPY ./target/dataloader-1.0.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch  dataloader-1.0.jar'
ENTRYPOINT ["java","-jar","dataloader-1.0.jar"]