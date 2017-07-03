package com.test;



import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" },
	features = { "src/test/resources/feature/" },
	glue = {"com.steps" },
	tags = { "@Reg" })


public class TestRunner {

}
