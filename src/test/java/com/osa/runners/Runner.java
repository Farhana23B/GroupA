package com.osa.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class Runner {
	@CucumberOptions(features="src\\test\\java\\com\\osa\\features\\AllRequests.feature",
			 glue="com.osa.steps",
					 plugin= {"pretty","json:target/cucumber-reports/report2.json",
							 }		 
	)//"html:target/cucumber-reports/report.html"

public class TestNGRunner extends AbstractTestNGCucumberTests{

}

}
