package com.benchmark.testcases.autorization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.benchmark.common.Global;
import com.benchmark.managers.Pages;
import com.benchmark.testcases.BaseUITest;

public class VerifyLoginPageORR extends BaseUITest  {
	
	private final static String DESCRIPTION = "Validate Login Page";
	private final static String TESTSTEPS = "Login Page UI Validation";
	

	public VerifyLoginPageORR() {
		super(DESCRIPTION, TESTSTEPS);
	}

	/*
	 * Test Case Name	: 
	 * Author Name		:
	 * Date Created		:
	 * Date Modified	:
	 */
	 @Test(description = DESCRIPTION)
	  public void verifyLogin_TC1()  {
		 Global.TEST_CASE_ERROR_MESSAGES = new StringBuilder();
		 m_isTestPassed = Pages.LoginORR().operations.isLoginSuccess();
		 Assert.assertTrue(m_isTestPassed, "verifyLogin_TC1 : Fail");
	  }
}
