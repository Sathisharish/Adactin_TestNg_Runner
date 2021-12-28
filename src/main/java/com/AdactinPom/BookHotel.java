package com.AdactinPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotel {
	
	public static WebDriver driver;
	
	@FindBy (id="first_name")
	private WebElement firstName;
	
	@FindBy (id ="last_name")
	private WebElement lastName;
	
	@FindBy (id="address")
	private WebElement add;
	
	@FindBy (id="cc_num")
	private WebElement ccNum;
	
	@FindBy (id="cc_type")
	private WebElement ccType;
	
	@FindBy (xpath="//option[text()='Master Card']")
	private WebElement ccOptions;
	
	@FindBy (id="cc_exp_month")
	private WebElement expMonth;
	
	@FindBy (xpath="//option[text()='November']")
	private WebElement expOptions;
	
	@FindBy (id="cc_exp_year")
	private WebElement expYear;
	
	@FindBy (xpath="//option[text()='2022']")
	private WebElement yearOptions;
	
	@FindBy (id="cc_cvv")
	private WebElement cvv;
	
	@FindBy (id="book_now")
	private WebElement book;

	public BookHotel(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAdd() {
		return add;
	}

	public WebElement getCcNum() {
		return ccNum;
	}

	public WebElement getCcType() {
		return ccType;
	}

	public WebElement getCcOptions() {
		return ccOptions;
	}

	public WebElement getExpMonth() {
		return expMonth;
	}

	public WebElement getExpOptions() {
		return expOptions;
	}

	public WebElement getExpYear() {
		return expYear;
	}

	public WebElement getYearOptions() {
		return yearOptions;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBook() {
		return book;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
