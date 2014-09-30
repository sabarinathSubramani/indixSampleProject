package com.indix.webPages.amazon;

import com.indix.amazon.BusinessObjects.ItemDetails;
import com.indix.webAutomation.componenets.PageElement;
import com.indix.webAutomation.componenets.WebPage;

public class AmazonItemDetailsPage extends WebPage {

	public static final PageElement PAGE_IDENTIFIER = new PageElement("imgTagWrapperId");
	
	public AmazonItemDetailsPage() throws Exception {
		super(PAGE_IDENTIFIER);
	}
	
	public PageElement itemTitle = new PageElement("productTitle");
	public PageElement itemPrice = new PageElement("priceblock_ourprice");
	public PageElement stockInfo = new PageElement("//div[@id='availability']/span");
	public PageElement shareEmailButton = new PageElement("//a[@id='swfImage']");
	public PageElement emailIdTextBox = new PageElement("//input[@id='ac_input']");
	public PageElement sendEmailButton = new PageElement("//div[@class='a-popover-wrapper']/*//button[@id='swfSubmitButton-announce']");
	public PageElement shareEmailPopup = new PageElement("//div[@class='a-popover-wrapper']");
	
	public void retrieveItemDetails(ItemDetails item){
		item.setItemPrice(itemPrice.getText());
		item.setItemTitle(itemTitle.getText());
		item.setStockDetails(stockInfo.getText());
	}
	
	public void shareItemByEmail(String emailAddress) throws Exception{
		shareEmailButton.click();
		waitforElementtobeVisible(shareEmailPopup);
		Thread.sleep(5000);
		waitforElementtobeVisible(emailIdTextBox);
		emailIdTextBox.type(emailAddress);
		sendEmailButton.click();
		waitForElementtoDisappear(shareEmailPopup);
	}
	
}
