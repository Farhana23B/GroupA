
Feature: Call all requests with API RestAssured
  #Background:Given I have sent baseURI and authentication

	Scenario: send GET request extracting all students info
	Given I have sent baseURI and authentication
    When I send get request using "/students"
    Then i delete a "/students/6563634ca10a1e0fc60968c0" id 
    #Then I validated with status code
   

 
  Scenario: send POST request for adding student info
    Given I have sent baseURI and authentication
    When I send post request
    And I verified the student ID with get request
    And I send a patch request updating student info
 

    