package com.benchmark.pages;

import com.benchmarkpages.operations.ReportPageOperationsORR;

public class ReportPageORR {
	
	public ReportPageOperationsORR oRRValidation=null;
	public ReportPageOperationsORR filterValidation=null;
	public ReportPageOperationsORR rLPValidation=null;
	public ReportPageOperationsORR rHOValidation=null;
	
	
	public ReportPageORR() {
		oRRValidation=new ReportPageOperationsORR();
		filterValidation=new ReportPageOperationsORR();
		rLPValidation=new ReportPageOperationsORR();
		rHOValidation=new ReportPageOperationsORR();
	}

}
