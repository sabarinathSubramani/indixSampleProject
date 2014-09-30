package com.indix.webPages.amazon;

import com.indix.webAutomation.componenets.PageElement;
import com.indix.webAutomation.componenets.WebPage;

public class AmazonSigninPage extends WebPage{

	public static final PageElement page_identifier = new PageElement("//input[@type='email']");
	public static final PageElement emailTextBox = new PageElement("//input[@type='email']");
	public static final PageElement passwordTextBox = new PageElement("//input[@type='password']");
	public static final PageElement loginButton = new PageElement("//span[@class='a-button-inner' or @id='signInSubmit']");
	
	public AmazonSigninPage() throws Exception {
		super(page_identifier);
	}
	
	public void login(String userName, String password){
		emailTextBox.type(userName);
		passwordTextBox.type(password);
		loginButton.click();
	}

}
