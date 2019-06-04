package com.benchmark.pages.elements;

import com.benchmark.core.constants.FindByTypeConstants;
import com.benchmark.framework.ui.controls.MSGenericElement;

public class RHOPageElementsORR {
	/**
	*--RHO Header row elements--
	*/
	public MSGenericElement getHeadersOfRHO(String expected) {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-header rho-header']//span[contains(text(),'"+expected+"')]");
	}
	/**
	*--Date column elements--
	*/
	public MSGenericElement getDateColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-row'][*]/div[1]/span[1]");
	}
	public String getDateColumnXpath() {
		return "//div[@class='student-list-row'][*]/div[1]/span[1]";
	}
	public MSGenericElement getRowData() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']");
	}
	public MSGenericElement getSortDateColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']");
	}
	
}
