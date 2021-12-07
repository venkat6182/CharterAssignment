# CustomerRewardsAPI 
    This tool is to automaticaly calculate reward points based on customert transcation.It's Springboot project developed in Java
    It has two Rest end point one is get health check of CustomerRewardsAPI and second is a Post service where you will be passing
    all the customer transaction can passed in JSON format with all the mandatory fields as input and API calculate the reward points
    earned for each customer per month and total. 
    
# Pre-requisites 
   1) Java - 1.8.x
   2) Maven - 3.x.x
   
# Steps to Setup on localmachine
    1. Clone the application
         git clone https://github.com/venkat6182/CharterAssignment.git    
    2. Build and run the app using maven
       mvn package
    3. java -jar target/rewards-1.0.0.jar 0r
        Alternatively, you can run the app without packaging it you can use : mvn spring-boot:run
    4. open any of the brower your choice and verify CustomerRewardsAPI up and running by using below link
        http://localhost:8080//api/v1/reward-calculator
        
       
        
