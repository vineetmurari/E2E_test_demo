package com.automate.withme.steps;


import com.automate.withme.testNgUtils.testngUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Cucumber_Hooks {
	
	@Before()
	public void before_hook(Scenario sc){
		testngUtils.sc=sc;
	}
	
	@After()
	public void After_hook(Scenario sc){
		if(sc.isFailed()){
			System.out.println(sc.getName()+" FAILED");
		}
	}
	
}
