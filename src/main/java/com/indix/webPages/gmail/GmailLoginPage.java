package com.indix.webPages.gmail;

import com.indix.webAutomation.componenets.PageElement;
import com.indix.webAutomation.componenets.WebPage;

public class GmailLoginPage extends WebPage{

	public static final PageElement IDENTIFIER = new PageElement("Passwd");
	
	public GmailLoginPage() throws Exception {
		
	}
	
	private static PageElement eleUserid = new PageElement("Email");
	private static PageElement elePassword = new PageElement("Passwd");
	private static PageElement loginButton = new PageElement("signIn");
	
	public void login(String userName, String password){
		eleUserid.type(userName);
		elePassword.type(password);
		loginButton.click();
	}
	

}
