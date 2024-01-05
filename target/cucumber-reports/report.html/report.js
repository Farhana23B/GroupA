$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/osa/features/AllRequests.feature");
formatter.feature({
  "name": "Call all requests with API RestAssured",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "send GET request extracting all students info",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I have sent baseURI and authentication",
  "keyword": "Given "
});
formatter.match({
  "location": "com.osa.steps.AllRequestsApi.i_have_sent_baseURI_and_authentication()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I send GET request using \"/students\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.osa.steps.AllRequestsApi.i_send_GET_request_using(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I validated with status code",
  "keyword": "And "
});
formatter.match({
  "location": "com.osa.steps.AllRequestsApi.i_validated_with_status_code()"
});
formatter.result({
  "status": "passed"
});
});