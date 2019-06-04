package com.benchmark.testcases.RLP;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.benchmark.common.Global;
import com.benchmark.managers.Pages;
import com.benchmark.testcases.BaseUITest;

public class VerifyFilterFunctionalities extends BaseUITest {
	public VerifyFilterFunctionalities() {
		super(DESCRIPTION);
	}

	private final static String DESCRIPTION = "Validate ORR";

	@Test(description = DESCRIPTION)
	public void verifyFilter_TC1() {
		Global.TEST_CASE_ERROR_MESSAGES = new StringBuilder();
		m_isTestPassed = Pages.ReportORR().oRRValidation.reachToORR();
		Assert.assertTrue(m_isTestPassed, "Reach to ORR Functionality : Fail");
		Reporter.log("1---->>>>Reach to ORR Functionality :" + m_isTestPassed);
		m_isTestPassed = Pages.ReportORR().oRRValidation.filterOperations();
		Assert.assertTrue(m_isTestPassed, "Filter Functionality : Fail");
		Reporter.log("1---->>>>Filter Functionality :" + m_isTestPassed);
	}

}
