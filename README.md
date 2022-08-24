# AssignmentTest
AssignmentTest

Automation Tool Used : Rest Assured
Build Tool Used : Maven
Testing Framework : TestNG

The assignment has two test files which are placed under folder src/test/java. The reason for two test files is one of the files uses static JSON file and for the other I am using JSON server to completely create rest assured test file with POJO classes and rest assured features to get result from endpoint.
1. AssignmentTestsWithJson
2. AssignmentTestWithJsonServer

Running the tests:

1. AssignmentTestsWithJson :- In the test file static Json file is used for the tests. Using JsonPath extraction of the Json is done and TestNG is the testing framework used.
  
  Running the tests : 
  1. Navigate to the folder src/test/java.
  2. Right Click on the 'AssignmentTestsWithJson' test class.
  3. Click/Hover on Run as.
  4. Click TestNG test.
  5. All the tests in the class will run.
  
  
2. AssignmentTestWithJsonServer : For this test file I have used a JSON server to mock the response from an end point. The JSON server used for this can be installed using node, here is the link to the github https://github.com/typicode/json-server.
   
   Installation of Json Server :
   1. Install node js on machine.
   2. Navigate to github link for Json server https://github.com/typicode/json-server.
   3. On command prompt install JSON server using command npm install -g json-server.
   4. Start Json Server with command json-server --watch teamRCB.json (Json file at the end of the document). 
   5. Now Json can be accessed using URL http://localhost:3000/teamRCB.
   6. Keep the server running to execute tests.
   
   Running the tests:
   1. Navigate to the folder src/test/java.
   2. Right Click on the 'AssignmentTestWithJsonServer' test class.
   3. Click/Hover on Run as.
   4. Click TestNG test.
   5. All the tests in the class will run.
  
  
  --------------------------------------------------------JSON file for JSON Server ---------------------------------------------------------------------------------
  [
  {
    "name": "Royal Challengers Bangalore",
    "location": "Bangalore",
    "player": [
      {
        "name": "Faf Du Plessis",
        "country": "South Africa",
        "role": "Batsman",
        "price": "7"
      },
      {
        "name": "Virat Kohli",
        "country": "India",
        "role": "Batsman",
        "price": "15"
      },
      {
        "name": "Glenn Maxwell",
        "country": "Australia",
        "role": "Batsman",
        "price": "11"
      },
      {
        "name": "Mohammad Siraj",
        "country": "India",
        "role": "Bowler",
        "price": "7"
      },
      {
        "name": "Harshal Patel",
        "country": "India",
        "role": "Bowler",
        "price": "10.75"
      },
      {
        "name": "Wanindu Hasaranga",
        "country": "Srilanka",
        "role": "Bowler",
        "price": "10.75"
      },
      {
        "name": "Dinesh Karthik",
        "country": "India",
        "role": "Wicket-keeper",
        "price": "5.5"
      },
      {
        "name": "Shahbaz Ahmed",
        "country": "India",
        "role": "All-Rounder",
        "price": "2.4"
      },
      {
        "name": "Rajat Patidar",
        "country": "India",
        "role": "Batsman",
        "price": "0.20"
      },
      {
        "name": "Josh Hazlewood",
        "country": "Australia",
        "role": "Bowler",
        "price": "7.75"
      },
      {
        "name": "Mahipal Lomror",
        "country": "India",
        "role": "Bowler",
        "price": "7.75"
      }
    ]
  }
]
  
  
----------------------------------------------------------------- END OF FILE -----------------------------------------------------------------------------------------  
