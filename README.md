# AlphaSenseAPIAutomation
This is an example project for doing API automation testing using Rest Assured, maven,TestNG and BDD framework. This project tests 3 APIs - Search keyword, Login functionality and manifest endpoints with positive and negative scenarios.

# Prerequisites
This example requires the following softwares to run.

Eclipse
Java 1.7 or above

# Build With
Rest Assured - API Automation Framework Maven - Dependency management

# How to Use
This project can be placed anywhere in the system and can be imported in eclipse.Rightclick on project -> RunAs -> TestNG

# Scenario: 

**Search Keyword API test(GET REQUEST):** Generic method that specify baseURI and basepath along with query param is added. This is initialized before class for API testing with positive and negative scenario present in src/test/java >> APITest >> SearchKeywordTest.java .This method will create GET call and verifies status code, status line and contents in the response.

**Login API test(POST REQUEST):** Payload for post call has been given in json file under src/test/resources >> AuthPayoad.json.User defined post method(src/test/java >> APITest >>LoginTest.java) reads the json file and pass payload to PoST request and verifies the status code, status line and response content for both postive and negative scenario.

**Manifest json (GET Request):** User defined method that specify baseURI in src/test/java >> APITest >> ManifestTest.java will create GET call and verifies status code, status line and contents in the response.

Reports are created under the project folder 'target'

