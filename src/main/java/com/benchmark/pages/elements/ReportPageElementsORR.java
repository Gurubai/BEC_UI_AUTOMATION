package com.benchmark.pages.elements;

import com.benchmark.core.constants.FindByTypeConstants;
import com.benchmark.framework.ui.controls.MSGenericElement;
/**
 * ReportPageElementsORR - Class which contains all Report page related to elements
 */

public class ReportPageElementsORR {

	/**
	 * --ORR tab XPath
	 */
	public MSGenericElement getORRtab() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//li[contains(text(),'Oral Reading Records')]");
	}
	
	public String getORRtabXpath() {
		return "//li[contains(text(),'Oral Reading Records')]";
	}
	
	/**
	 * --Filter button XPath
	 */
	public MSGenericElement getFilterButton() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//span[text()='Filter']");
	}
	
	public String getFilterButtonXpath() {
		return "//span[text()='Filter']";
	}
	/**
	*--Default Ribbon Selected options--
	*/
	
	public MSGenericElement getAppliedFilterRibbon(String expected) {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='apply-filter-result']//*[text()='"+expected+"']");
	}
	
	public MSGenericElement getFilterOptions(String expected) {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[contains(@class,'collapse slide-shadow')]//button[text()='"+expected+"']");
	}
	
	public String getFilterOptionsXpath(String expected) {
		return "//div[contains(@class,'collapse slide-shadow')]//button[text()='"+expected+"']";
	}
	
	
	/**
	 * -Click on FLuency button in chart-
	 */
	public MSGenericElement getChartFluencyOptions() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//span[text()='Fluency']");
	}
	
	public String getChartFluencyOptionsXpath() {
		return "//span[text()='Fluency']";
	}
	
	
	/**
	 * Apply Button
	 */
	public MSGenericElement getApplyButton() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[a[contains(text(), 'Apply')]]");
	}
	public String getApplyButtonXpath() {
		return "//div[a[contains(text(), 'Apply')]]";
	}
	
	/**
	*--RHO or Reading History tab XPath--
	*/
	public MSGenericElement getRHOTab() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//li[contains(text(),'Reading History')]");
	}
	
	public String getRHOTabXpath() {
		return "//li[contains(text(),'Reading History')]";
	}
	/**
	*--RHO Header row elements--
	*/
	public MSGenericElement getHeadersOfRHO(String expected) {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-header rho-header']//span[contains(text(),'"+expected+"')]");
	}
	
	public String getHeadersOfRHOXpath(String expected) {
		return "//div[@class='student-list-header rho-header']//span[contains(text(),'"+expected+"')]";
	}
	/**
	*--Click on Student--
	*/
	public MSGenericElement getStudentButton() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='single-filter-text' and text()='Student']");
	}
	public String getStudentButtonXpath() {
		return "//div[@class='single-filter-text' and text()='Student']";
	}
	/**
	*--Click on Student--
	*/
	public MSGenericElement getSpinner() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='display-loading-main' and @style='display: none;']");
	}
	public String getSpinnerXpath() {
		return "//div[@class='display-loading-main' and @style='display: none;']";
	}
	/**
	*--Entire RHO chart--
	*/
	public MSGenericElement getEntireRHOChart() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']");
	}
	/**
	*--RHO:Date column elements--
	*/
	public MSGenericElement getDateColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[1]/span[1]");
	}
	public String getDateColumnXpath() {
		return "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[1]/span[1]";
	}
	public String getEntireRHOChartXpath() {
		return "//div[@class='student-list-body scroll-body']";
	}
	public MSGenericElement getSortOptionDateAscending() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//span[@class='rho-student' and text()='Date']//following-sibling::span/i[text()='expand_less']");
	}
	/**
	*--RHO:Proficiency column elements--
	*/
	public MSGenericElement getSortOptionProfAscending() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-column-list']/span[contains(text(),'Proficiency')]//following-sibling::span[@class='togglers']/i[contains(text(),'expand_less')]");
	}
	public MSGenericElement getProficiencyColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[3]/span[1]");
	}
	public String getProficiencyColumnXpath() {
		return "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[3]/span[1]";
	}
	/**
	*--RHO:Last Passage column elements--
	*/
	public MSGenericElement getLastPassageColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[4]/span[1]");
	}
	public String getLastPassageColumnXpath() {
		return "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[4]/span[1]";
	}
	public MSGenericElement getSortOptionLastPassageAscending() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-column-list']/span[@class='rho-student' and text()='Passage']//following-sibling::span/i[text()='expand_less']");
	}
	/**
	*--RHO:Category column elements--
	*/
	public MSGenericElement getCategoryColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[5]/span[1]");
	}
	public String getCategoryColumnXpath() {
		return "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[5]/span[1]";
	}
	public MSGenericElement getSortOptionCategoryAscending() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-column-list']/span[@class='rho-student' and text()='Category']//following-sibling::span/i[text()='expand_less']");
	}
	/**
	*--RHO:Accuracy column elements--
	*/
	public MSGenericElement getAccuracyColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[6]/span[1]");
	}
	public String getAccuracyColumnXpath() {
		return "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[6]/span[1]";
	}
	public MSGenericElement getSortOptionAccuracyAscending() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-column-list']/span[@class='rho-student' and text()='Accuracy']//following-sibling::span/i[text()='expand_less']");
	}
	/**
	*--RHO:Fluency column elements--
	*/
	public MSGenericElement getSortOptionFluencyAscending() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-column-list']/span[@class='rho-student' and text()='Fluency']//following-sibling::span/i[text()='expand_less']");
	}
	public MSGenericElement getFluencyColumn() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[8]/span[1]");
	}
	public String getFluencyColumnXpath() {
		return "//div[@class='student-list-body scroll-body']/div[@class='student-list-row']/div[8]/span[1]";
	}
}
