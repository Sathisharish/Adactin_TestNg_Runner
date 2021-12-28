package com.AdactinPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel {
	
	public static WebDriver driver;
	
	@FindBy (id="radiobutton_0")
	WebElement radioButton;
	
	@FindBy (id="continue")
	WebElement cont;

	public SelectHotel(WebDriver driver2) {

		this.driver=driver2;
		PageFactory.initElements(driver, this);
	
	
	}

	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getCont() {
		return cont;
	}

	
}
