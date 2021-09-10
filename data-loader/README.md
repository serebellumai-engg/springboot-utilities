"# data-loader" 
API Postman Collection : https://www.getpostman.com/collections/28943747770f43281974

# Individually starting the services
  1. Start Database
    a. docker pull mysql
    b. docker run -p 33060:3306 --name dl-mysql mysql

  2. Build and start the app container
    a. mvn clean install
    b. docker build -t dataloader-app .
    c. docker run -p 8000:8000 --name dataloader-app --link dl-mysql:mysql -d dataloader-app

# Starting all services together
1. mvn clean install
2. docker build -t dataloader-app .
3. docker-compose up
  
