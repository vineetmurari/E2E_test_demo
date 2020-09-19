package com.automate.withme.Runner;

import org.openqa.selenium.WebDriver;

import com.automate.withme.testNgUtils.testngUtils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="Features",
		glue="com.automate.withme.steps",
		strict=true,
		monochrome=true,
		plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"html:target/cucumber-html-reports", 
				"json:target/cucumber-html-reports/cucumber.json"},
		tags={"@E2e"}
		)
public class E2e_Runner extends testngUtils {
	
}
