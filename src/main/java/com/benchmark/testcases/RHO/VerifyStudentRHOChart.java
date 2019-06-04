package com.benchmark.testcases.RHO;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.benchmark.common.Global;
import com.benchmark.managers.Pages;
import com.benchmark.testcases.BaseUITest;

public class VerifyStudentRHOChart extends BaseUITest {
	

	public VerifyStudentRHOChart() {
		super(DESCRIPTION);
	}

	@Test(description = DESCRIPTION)
	public void verifyRHO() {
		Global.TEST_CASE_ERROR_MESSAGES = new StringBuilder();

		
		m_isTestPassed = Pages.ReportORR().oRRValidation.reachToORR();
		Assert.assertTrue(m_isTestPassed, "Reach to ORR Functionality : Fail");
		Reporter.log("2---->>>>Reach to ORR Functionality :" + m_isTestPassed);
		m_isTestPassed = Pages.ReportORR().oRRValidation.readingHistoryOperations();
		Assert.assertTrue(m_isTestPassed, "Reading History Functionality : Fail");
		Reporter.log("3---->>>>Reading History Functionality :" + m_isTestPassed);

	}

	private final static String DESCRIPTION = "Validate ORR For Student Lavel chart";

}
