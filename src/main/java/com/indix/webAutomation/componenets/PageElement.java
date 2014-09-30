package com.indix.webAutomation.componenets;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;



/*
 * supports id, name, xpath locators only
 */
public class PageElement {
	
	private WebElement ele;
	private String locator;
	private By by;
	
	public WebElement getWebElement(){
		return ele;
	}
	
	public PageElement(String eleLocator){
		
		locator = eleLocator;
	//	initElement();
	}
	
	public void click(){
		initElement();
		Reporter.log("Clicking element with locator" + locator);
		ele.click();
	}

	public void type(String text){
		initElement();
		Reporter.log("Start typing text "+text+"@ " + locator);
		ele.sendKeys(text);
	}
	
	public String getText(){
		initElement();
		Reporter.log("reading text @ " + locator);
		return ele.getText();
	}
	
	protected void initElement(){
		
		if(locator.startsWith("//"))
			by = By.xpath(locator);
		else
			by = By.xpath("//*[@id ='"+locator+"' or @name ='"+locator+"']");
		try{
		ele = WebDriverManager.getWebDriver().findElement(by);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
	}

	public void setBy(By by) {
		this.by = by;
	}

	public By getBy() {
		return by;
	}
}
