package com.benchmarkpages.operations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.benchmark.common.Helper;
import com.benchmark.core.constants.FindByTypeConstants;
import com.benchmark.core.util.FileOperations;
import com.benchmark.framework.ui.SeleniumWrapper;
import com.benchmark.framework.ui.controls.BaseControl;
import com.benchmark.framework.ui.controls.MSDropDownList;
import com.benchmark.pages.elements.LoginPageElementsORR;

public class LoginPageOperationORR extends BaseControl {

	/*----Usable Class, and variable declaration----*/
	LoginPageElementsORR loginPage;
	Properties appProperties;
	MSDropDownList dropdown;
	WebElement basewebelement;
	Select select;

	private final static String CLASSNAME = LoginPageOperationORR.class.getSimpleName();

	public void commonInitialization() {
		try {
			loginPage = new LoginPageElementsORR();
			appProperties = FileOperations.getProperties("app.properties");
		} catch (IOException e) {
			Helper.appendErrorMessage(CLASSNAME, "LoginPageValidationORR -" + "commonInitialization : fail", e);
		}
	}

	public boolean performLoging(String username, String password) {
		commonInitialization();
		try {
			basewebelement = SeleniumWrapper.webDriver()
					.findElement(createBy(FindByTypeConstants.XPATH, loginPage.getSelectRealmDropdownLocator()));
			loginPage.getUserNameField().setText(username);
			loginPage.getPasswordField().setText(password);
			select = new Select(basewebelement);
			// dropdown.select(appProperties.getProperty(CommonConstants.SELECT_REALM_OPTION));
			select.selectByVisibleText("techsupport");

			loginPage.getSignInButton().click();

			return true;
		} catch (Exception e) {
			Helper.appendErrorMessage(CLASSNAME, "Validate Login Page", e);
		}
		return false;
	}

	public boolean isLoginSuccess() {

		try {
			loginPage.signOutText().isVisible();
			return true;
		} catch (Exception e) {
			Helper.appendErrorMessage(CLASSNAME, "Validate Login Page", e);
		}
		return false;
	}

}
