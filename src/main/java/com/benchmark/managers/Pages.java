

package com.benchmark.managers;


import com.benchmark.pages.LoginPageORR;
import com.benchmark.pages.ReportPageORR;

/**
 * Factory Manager class for 360 D UI automation pages.
 */

public final class Pages {

	/*
	 * Variable to hold instance of Pages class object.
	 */
	
	private static volatile LoginPageORR m_loginPage = null;
	private static volatile ReportPageORR m_reportPage = null;

	
	
	//--LoginPageORR --//
	public static LoginPageORR LoginORR() {
		if (m_loginPage == null) {
			synchronized (LoginPageORR.class) {
				if (m_loginPage == null) {
					m_loginPage = new LoginPageORR();
				}
			}
		}
		return m_loginPage;
	}
	//--ReportPageORR--//
	public static ReportPageORR ReportORR() {
		if (m_reportPage == null) {
			synchronized (ReportPageORR.class) {
				if (m_reportPage == null) {
					m_reportPage = new ReportPageORR();
				}
			}
		}
		return m_reportPage;
	}

}
