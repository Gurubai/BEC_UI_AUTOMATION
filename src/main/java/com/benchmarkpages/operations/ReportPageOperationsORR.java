package com.benchmarkpages.operations;



import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.benchmark.common.Helper;
import com.benchmark.framework.ui.SeleniumWrapper;
import com.benchmark.pages.elements.ReportPageElementsORR;
import com.google.common.collect.ObjectArrays;

public class ReportPageOperationsORR {
	
	ReportPageElementsORR reportPage;
	WebDriverWait wait;
	WebElement basewebelement;
	String[] expectedFilter= {"Instructional","English","Fiction","Nonfiction","Unseen"};
	String[] filterOptions= {"Independent","Frustrational","Spanish","Seen"};
	String[] allFilterOptions = ObjectArrays.concat(expectedFilter, filterOptions, String.class);
	String[] headerOfRHO= {"Date","Reading Level","Proficiency","Last Passage","Category","Accuracy",
			"Self-correction","Fluency","Re-telling","Comprehension"};
	
	private final static String ReportCLASSNAME = ReportPageOperationsORR.class.getSimpleName();

	public void commonInitialization() throws IOException {
			reportPage = new ReportPageElementsORR();	
			wait=new WebDriverWait(SeleniumWrapper.webDriver(), 60);
	}
	
	
	public boolean filterOperations() {
		try {
			commonInitialization();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(reportPage.getFilterButtonXpath())));
			Reporter.log("***********Defult value for filter validation***************");
			for(String filterVarify: expectedFilter) {
				boolean flag=reportPage.getAppliedFilterRibbon(filterVarify).isVisible();
				Reporter.log("By defult "+filterVarify +" is selected :"+ flag);
				
			}
			reportPage.getFilterButton().click();
			for (String filterOptionSelect : filterOptions) {
				SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getFilterOptionsXpath(filterOptionSelect));
			}
			reportPage.getApplyButton().click();
			Reporter.log("***********All values in filter Ribbon validation***************");
			for (String filterOption : allFilterOptions) {
				boolean flag=reportPage.getAppliedFilterRibbon(filterOption).isVisible();
				Reporter.log("After applying all fiter "+filterOption+ " is visible in Ribbon :"+flag);
			}
			return true;
		} catch (Exception e) {
			Helper.appendErrorMessage(ReportCLASSNAME, "Validate Filters", e);
			e.printStackTrace();
		}
		
		
		
		return false;
		
	}
	public boolean readingLevelProgressOperations() {
		try {
			commonInitialization();
			SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getChartFluencyOptionsXpath());
			return true;
			
		} catch (Exception e) {
			Helper.appendErrorMessage(ReportCLASSNAME, "Validate RLP", e);
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean readingHistoryOperations() {
		try {
			commonInitialization();
			SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getRHOTabXpath());
			//*----------All Filter Selection-----------*//
			reportPage.getFilterButton().click();
			for (String filterOptionSelect : filterOptions) {
				SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getFilterOptionsXpath(filterOptionSelect));
			}
			SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getApplyButtonXpath());
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(reportPage.getHeadersOfRHOXpath(headerOfRHO[0]))));
			Thread.sleep(5000);

			//*-------------Check sort for date column-------------*/ /
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(reportPage.getEntireRHOChartXpath())));
			List<WebElement> list = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getDateColumnXpath()));
			String strArray[] = new String[list.size()];
			for (int i=0; i< list.size(); i++) 
				strArray[i]=list.get(i).getText();
			ArrayList<Date> dates=new ArrayList<>();
			ArrayList<Date> datesDecending=new ArrayList<>();
			SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy");
			for(int i=0;i<strArray.length;i++) 
				dates.add(format.parse(strArray[i]));
			Collections.sort(dates);
			datesDecending=dates;
			Collections.sort(dates,Collections.reverseOrder());
			int flag=-1;
				 for(int i=0;i<datesDecending.size();i++){
					 flag=dates.get(i).compareTo(datesDecending.get(i));
				 } 
				 if (flag==0) 
					Reporter.log("----->>Default order of Date column validated");
				 else
					 Reporter.log("----->>Default order of Date column validation failed");
			
			reportPage.getSortOptionDateAscending().click();
			List<WebElement> listAS = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getDateColumnXpath()));
			String strArrayAS[] = new String[listAS.size()];
			for (int i = 0; i < listAS.size(); i++) 
				strArrayAS[i]=listAS.get(i).getText();
			ArrayList<Date> datesAS=new ArrayList<>();
			for(int i=0;i<strArrayAS.length;i++) 
				datesAS.add(format.parse(strArrayAS[i]));
			if(dates.size()==datesAS.size())
			{
				 flag=-1;
				 for(int i=0;i<strArrayAS.length;i++){
					 flag=dates.get(i).compareTo(datesAS.get(i));
					 System.out.println(flag);
				 } 
				 if (flag==0) 
					Reporter.log("----->>Sorting of Date column validated");
				 else
					 Reporter.log("----->>Sorting of Date column validation failed");
			}
			
			//*-------------Check sort for Reading Level column-------------*//
		       //Will be done after data modification
			
			//*-------------Check sort for Proficiency column-------------*// 
			List<WebElement> listproficiency = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getProficiencyColumnXpath()));
			String[] prof = new String[listproficiency.size()];
			for (int i=0; i<listproficiency.size(); i++) 
				prof[i]=listproficiency.get(i).getText();
			Arrays.sort(prof);
			reportPage.getSortOptionProfAscending().click();
			List<WebElement> listproficiencyAS = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getProficiencyColumnXpath()));
			String[] profAS = new String[listproficiencyAS.size()];
			for(int i=0; i<listproficiencyAS.size(); i++) 
			
				profAS[i]=listproficiencyAS.get(i).getText();
			if (Arrays.equals(prof, profAS)) 
				Reporter.log("----->>Sorting of Proficiency column validated");
			else 
				Reporter.log("----->>Sorting of Proficiency validation failed");
			//*-------------Check sort for Last Passage column-------------*//
			
			List<WebElement> listLastPassage = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getLastPassageColumnXpath()));
			String[] lastpassage = new String[listLastPassage.size()];
			for (int i=0; i<listLastPassage.size(); i++) 
				lastpassage[i]=listLastPassage.get(i).getText();
			Arrays.sort(lastpassage);
			for(String s:lastpassage) System.out.println("hame tumse pyar kitna ------ "+s);
			reportPage.getSortOptionLastPassageAscending().click();
			List<WebElement> listLastPassageAS = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getLastPassageColumnXpath()));
			String[] lastpassageAS = new String[listLastPassageAS.size()];
			for (int i=0; i<listLastPassageAS.size(); i++) 
				lastpassageAS[i]=listLastPassageAS.get(i).getText();
			if (Arrays.equals(lastpassage, lastpassageAS)) 
				Reporter.log("----->>Sorting last passage column validated");
			else 
				Reporter.log("----->>Sorting last passage column validation failed");
			//*-------------Check sort for Category column-------------*//
			List<WebElement> listcategory = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getCategoryColumnXpath()));
			String[] category = new String[listcategory.size()];
			for (int i=0; i<listcategory.size(); i++) category[i]=listcategory.get(i).getText();
			Arrays.sort(category);
			reportPage.getSortOptionCategoryAscending().click();
			List<WebElement> listcategoryAS = SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getCategoryColumnXpath()));
			String[] categoryAS = new String[listcategoryAS.size()];
			for (int i=0; i<listcategoryAS.size(); i++) categoryAS[i]=listcategoryAS.get(i).getText();
			if (Arrays.equals(category, categoryAS)) Reporter.log("----->>Sorting Category column validated");
			else {
				Reporter.log("----->>Sorting Category column validation failed");
				return false;
			}
			//*-------------Check sort for Accuracy column-------------*//
			List<WebElement> listAccuracy =SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getAccuracyColumnXpath()));
			String[] accuracy =new String[listAccuracy.size()];
			for (int i=0; i<listAccuracy.size(); i++) accuracy[i]=(listAccuracy.get(i).getText());
			Arrays.sort(accuracy);
			reportPage.getSortOptionAccuracyAscending().click();
			List<WebElement> listAccuracyAS =SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getAccuracyColumnXpath()));
			String[] accuracyAS = new String[listAccuracyAS.size()];
			for (int i=0; i<listAccuracyAS.size(); i++) accuracyAS[i]=(listAccuracyAS.get(i).getText());
			if (Arrays.equals(accuracy, accuracyAS)) Reporter.log("----->>Sorting Accuracy column validated");
			else Reporter.log("----->>Sorting Accuracy column validation failed");
			//*-------------Check sort for Self Correction column-------------*//
			   //Data not there in column
			
			//*-------------Check sort for Fluency column-------------*//
			List<WebElement> listFluency=SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getFluencyColumnXpath()));
			String[] fluency=new String[listFluency.size()];
			for (int i=0; i<listFluency.size(); i++) {
				fluency[i]=listFluency.get(i).getText().replaceAll("[a-zA-Z]", "");
			}
			Arrays.sort(fluency);
			reportPage.getSortOptionFluencyAscending().click();
			List<WebElement> listFluencyAS=SeleniumWrapper.webDriver().findElements(By.xpath(reportPage.getFluencyColumnXpath()));
			String[] fluencyAS=new String[listFluencyAS.size()];
			for (int i=0; i<listFluencyAS.size(); i++) {
				fluencyAS[i]=listFluencyAS.get(i).getText().replaceAll("[a-zA-Z]", "");
			}
			if (Arrays.equals(fluency, fluencyAS)) {
				System.out.println("sorted");
				Reporter.log("----->>Sorting Fluency column Validated");
			}
			else {
				System.out.println("not sorted");
				Reporter.log("----->>Sorting Fluency column Validation failed");
			}
			//*-------------Check sort for Re-telling column-------------*//
		      //Data not there in column
			
			//*-------------Check sort for Comprehension column-------------*//
		      //Data not there in column
			return true;
			 
		} catch (Exception e) {
			Helper.appendErrorMessage(ReportCLASSNAME, "Validate RHO", e);
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean reachToORR() {
		try {
			commonInitialization();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(reportPage.getSpinnerXpath())));
			SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getStudentButtonXpath());
			SeleniumWrapper.waitTillElementToBeClickableAndClick("XPATH", reportPage.getORRtabXpath());
			return true;
		} catch (Exception e) {
			Helper.appendErrorMessage(ReportCLASSNAME, "Reach to ORR", e);
			e.printStackTrace();
		}
		return false;
	}

}







































































































