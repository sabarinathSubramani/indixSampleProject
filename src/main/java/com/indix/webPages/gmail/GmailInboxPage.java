package com.indix.webPages.gmail;

import com.indix.webAutomation.componenets.PageElement;
import com.indix.webAutomation.componenets.WebPage;

public class GmailInboxPage extends WebPage{

	public static final PageElement PAGE_IDENTIFIER = new PageElement("//div[@class='z0']");
	
	public GmailInboxPage() throws Exception {
		super(PAGE_IDENTIFIER);
	}
	
	public PageElement mailByIndex(int idx){
		return new PageElement("//div[@class='Cp']//tr["+idx+"]");
	}
	
	public MailDetailsPage checkMailByIndex(int idx) throws Exception{
		mailByIndex(idx).click();
		return new MailDetailsPage();
	}

}
