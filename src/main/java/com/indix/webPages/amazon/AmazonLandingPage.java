package com.indix.webPages.amazon;

import com.indix.webAutomation.componenets.PageElement;
import com.indix.webAutomation.componenets.WebBrowser;
import com.indix.webAutomation.componenets.WebPage;

public class AmazonLandingPage extends WebPage{
	
	public static final PageElement IDENTIFIER = new PageElement("//span[@class='nav-logo-base nav-sprite']");

	public AmazonLandingPage(WebBrowser webBroser)
			throws Exception {
		super(webBroser, null);
	}
	
	
	public PageElement stayonAmazonButton = new PageElement("//div[@id='redir-footer']/a[@id='redir-stay-at-www']");
	public PageElement loginButton = new PageElement("nav-your-account");
	public PageElement searchTextBox = new PageElement("twotabsearchtextbox");
	public PageElement searchButton = new PageElement("//*[@value='Go']");
	
	public AmazonSearchResultsPage searchForProducts(String productName) throws Exception{
		searchTextBox.type(productName);
		searchButton.click();
		return new AmazonSearchResultsPage();	
	}
	
	@Override
	public void open(String url) throws Exception{
		super.open(url);
		waitforElementtoLoad(stayonAmazonButton);
		stayonAmazonButton.click();
		waitforElementtoLoad(IDENTIFIER);
	}
	
	public AmazonSigninPage clickOnSignIn() throws Exception{
		loginButton.click();
		return new AmazonSigninPage();
	}
}
