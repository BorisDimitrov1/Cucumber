package com.vereign.automationExample.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
	    plugin = {"pretty","html:target/reports"},
	    monochrome = true,
	    features = "src/test/resources/EndToEndTest.feature"
	)

public class RunnTest { }
