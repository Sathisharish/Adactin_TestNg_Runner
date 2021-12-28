package com.AdactinPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLp{
	
	public static WebDriver driver;

	@FindBy (id="username")
	private WebElement uname;
	
	@FindBy (id="password")
	private WebElement psw;
	
	@FindBy (id ="login")
	private WebElement log;
	

	public AdactinLp(WebDriver driver2) {

		this.driver=driver2;
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getUname() {
		return uname;
	}

	public WebElement getPsw() {
		return psw;
	}

	public WebElement getLog() {
		return log;
	}
	
	
	
	
	
	
	
	
	
	

}
