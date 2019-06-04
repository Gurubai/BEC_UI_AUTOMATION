package com.benchmark.testcases.RLP;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.benchmark.common.Global;
import com.benchmark.managers.Pages;
import com.benchmark.testcases.BaseUITest;

public class VerifyRLPChartValidation extends BaseUITest {

	private final static String DESCRIPTION = "Validate ORR";
	private final static String TESTSTEPS = "Reading Level Progress Chart VAlidation";

	private final static String DESCRIPTION_TC2 = "Validate Reading Level Progress ";

	public VerifyRLPChartValidation() {
		super(DESCRIPTION, TESTSTEPS);
	}

	@Test(description = DESCRIPTION_TC2)
	public void verifyRLP_TC2() {
		Global.TEST_CASE_ERROR_MESSAGES = new StringBuilder();
		m_isTestPassed = Pages.ReportORR().oRRValidation.reachToORR();
		Assert.assertTrue(m_isTestPassed, "Reach to ORR Functionality : Fail");
		Reporter.log("2---->>>>Reach to ORR Functionality :" + m_isTestPassed);
		m_isTestPassed = Pages.ReportORR().oRRValidation.readingLevelProgressOperations();
		Assert.assertTrue(m_isTestPassed, "Reading Level Progress Functionality : Fail");
		Reporter.log("3---->>>>Reading Level Progress Functionality :" + m_isTestPassed);
	}

}
