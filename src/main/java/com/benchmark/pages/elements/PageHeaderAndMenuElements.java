

package com.benchmark.pages.elements;

import com.benchmark.common.Helper;
import com.benchmark.core.constants.FindByTypeConstants;
import com.benchmark.framework.ui.controls.MSDropDownList;
import com.benchmark.framework.ui.controls.MSGenericElement;

/**
 * Class which holds the elements of Page Header and Menu control
 */
public class PageHeaderAndMenuElements {

	
	
	/**
	 * Gets UserName WebElement from header
	 */
	public MSGenericElement userName() {
		return new MSGenericElement(FindByTypeConstants.CSS_SELECTOR, ".profile.dropdown.open h5.ng-binding");
	}

	/**
	 * Gets UserEmail WebElement from header
	 */
	public MSGenericElement userEmailId() {
		return new MSGenericElement(FindByTypeConstants.CSS_SELECTOR, ".dropdown-menu>h6");
	}

	
	/**
	 

	/**
	 * Gets Profile List
	 */
	public MSDropDownList profiles() {
		if (Helper.isElementAvailable(FindByTypeConstants.CSS_SELECTOR, ".fa.fa-caret-down")) {
			return new MSDropDownList(FindByTypeConstants.CSS_SELECTOR, "div[class ^= 'option dropdown']",
					FindByTypeConstants.CSS_SELECTOR, "ul[class ='profile-list']", FindByTypeConstants.TAG_NAME, "li",
					"innerText");
		}
		return null;
	}

	

	public MSGenericElement citrixLogo() {
		return new  MSGenericElement(FindByTypeConstants.XPATH,"//img[contains(@alt,'Citrix Ready logo')]");
	}

	// ---------------------------------------------------------------------------------------------------------------
	
	
}
