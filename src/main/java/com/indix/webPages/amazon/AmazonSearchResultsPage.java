package com.indix.webPages.amazon;

import com.indix.webAutomation.componenets.PageElement;
import com.indix.webAutomation.componenets.WebPage;

public class AmazonSearchResultsPage extends WebPage {
	
	public static final PageElement PAGEIDENTIFIER = new PageElement("//div[@class='shoppingEngineSectionHeaders']");

	public AmazonSearchResultsPage() throws Exception {
		super(PAGEIDENTIFIER);
	}
	
	public PageElement searchItemByIndex(int i){
		
		return new PageElement("//div[@id='result_"+i+"']/*//a");
	}
	
	public AmazonItemDetailsPage clickonSearchResultbyIndex(int i) throws Exception{
		Thread.sleep(5000);
		searchItemByIndex(i).click();
		return new AmazonItemDetailsPage();
	}

}
