package com.indix.test.amazon;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.indix.amazon.BusinessObjects.ItemDetails;
import com.indix.webAutomation.componenets.WebBrowser;
import com.indix.webAutomation.componenets.WebDriverManager;
import com.indix.webPages.amazon.AmazonItemDetailsPage;
import com.indix.webPages.amazon.AmazonLandingPage;
import com.indix.webPages.amazon.AmazonSearchResultsPage;
import com.indix.webPages.amazon.AmazonSigninPage;
import com.indix.webPages.gmail.GmailInboxPage;
import com.indix.webPages.gmail.GmailLoginPage;
import com.indix.webPages.gmail.MailDetailsPage;

public class AmazonTest {
	
	@Test
	public void testAmazonItemSharingMail() throws Exception{
		
		AmazonLandingPage landingPage = new AmazonLandingPage(WebBrowser.FireFox);
		landingPage.open("http://www.amazon.com");
		AmazonSigninPage clickOnSignIn = landingPage.clickOnSignIn();
		clickOnSignIn.login("amazon login id", "amazon password");
		landingPage.waitforElementtoLoad(AmazonLandingPage.IDENTIFIER);
		AmazonSearchResultsPage searchResultsPage = landingPage.searchForProducts("bose");
		AmazonItemDetailsPage itemDetailsPage = searchResultsPage.clickonSearchResultbyIndex(1);
		ItemDetails details = new ItemDetails();
		itemDetailsPage.retrieveItemDetails(details);
		itemDetailsPage.shareItemByEmail("mail id to share");
		
		GmailLoginPage loginPage = new GmailLoginPage();
		loginPage.open("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail");
		loginPage.login("mail id", "password");
		GmailInboxPage inbox = new GmailInboxPage();
		MailDetailsPage mailDetailsPage = inbox.checkMailByIndex(1);
		Assert.assertEquals(mailDetailsPage.isTextPresent(details.getItemTitle()), true, "item title not present in the mail");
		mailDetailsPage.close();
	}
	
	@AfterSuite(alwaysRun = true)
	public void afterSuite(){
		WebDriverManager.getWebDriver().quit();
	}

}
