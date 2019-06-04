package com.benchmark.pages.elements;

import com.benchmark.core.constants.FindByTypeConstants;
import com.benchmark.framework.ui.controls.MSGenericElement;

public class RLPPageElementsORR {
	/**
	 * -Click on FLuency button in chart-
	 */
	public MSGenericElement getChartFluencyOptions() {
		return new MSGenericElement(FindByTypeConstants.XPATH, "//span[text()='Fluency']");
	}

}
