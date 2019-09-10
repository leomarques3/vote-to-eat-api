# vote-to-eat-api

### Requirements:
- JDK 11.0.4
- Maven 3

### Starting the application
* Clone the project
* In the project folder run the commands:
    * mvn clean install
    * java -jar target/vote-to-eat-api-0.0.1-SNAPSHOT.jar

_The api documentation is available at: http://localhost:8080/swagger-ui.html_

### Diagram
![Alt text](./src/main/resources/assets/vote-to-eat.png?raw=true)

### Descriptions
1. The user will log in the client application and there will appear all
    * _The client will automatically call the /restaurant/available api which will return all available restaurants_
    * _The available restaurants have the flag isAvailable is true in the Restaurant table_
2. The user will choose the restaurant
    * _The client will call the /vote/save api sending the user id and the chosen restaurant_
    * _The api will save the vote in a temporary table called VotingEvent_
3. At 11:30 AM BRT the VotingEventScheduler will run to count the votes and make it available in the WinnerHistory table
    * _The scheduler will search for the restaurant with the highest vote count_
    * _It will make the result available at the WinnerHistory table, the table keeps the restaurant and the chosen date_
    * _Then it will set the available flag in the Restaurant table to false for the winner restaurant_
    * _After that the scheduler will delete all records of the VotingEvent table to be filled again the next day_
4. The Restaurant scheduler will reset the unavailable restaurants in the weekend
    * _The scheduler will get all unavailable restaurants and set their available flag to true again_
    
### Highlights
The use of a scheduler to control the winner is a good way to avoid the client call an api only to count the votes every time.
I used H2 database to have all the data stored in memory (it will reset every time you restart the application). You can add more data updating the data.sql file or in the /h2-console.

### What could I have done better?
1. Created the application client
2. Automation tests with RestAssured
3. Used jUnit5
4. Used MockMvc to test the controllers
