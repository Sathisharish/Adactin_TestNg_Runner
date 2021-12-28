package com.AdactinPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
	
	public static WebDriver driver;
	
	@FindBy (id="location")
	private WebElement loc;
	
	@FindBy (xpath="//option[text()='Los Angeles']")
	private WebElement select;
	
	@FindBy (xpath = "//option[text()='Sydney']")
	private WebElement sydney;
	
	public WebElement getSydney() {
		return sydney;
	}

	@FindBy (id ="hotels")
	private WebElement hotel;
	
	@FindBy (xpath="//option[text()='Hotel Sunshine']")
	private WebElement hotelSelect;
	
	@FindBy (id="room_type")
	private WebElement room;
	
	@FindBy (xpath="//option[text()='Deluxe']")
	private WebElement type;
	
	@FindBy (id="room_nos")
	private WebElement roomNo;
	
	@FindBy (xpath="(//option[text()='3 - Three'])[1]")
	private WebElement option;
	
	@FindBy (id="datepick_in")
	private WebElement dateIn;
	
	@FindBy (id="datepick_out")
	private WebElement dateOut;
	
	@FindBy (id="adult_room")
	private WebElement aRoom;
	
	@FindBy(xpath="(//option[text()='2 - Two'])[2]")
	private WebElement roomOption;
	
	@FindBy (id="child_room")
	private WebElement cRoom;
	
	@FindBy(xpath="(//option[text()='1 - One'])[3]")
	private WebElement cRoomopt;
	
	@FindBy (id="Submit")
	private WebElement submit;

	public SearchHotel(WebDriver driver2) {

		this.driver= driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLoc() {
		return loc;
	}

	public WebElement getSelect() {
		return select;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getHotelSelect() {
		return hotelSelect;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getRoomNo() {
		return roomNo;
	}

	public WebElement getOption() {
		return option;
	}

	public WebElement getDateIn() {
		return dateIn;
	}

	public WebElement getDateOut() {
		return dateOut;
	}

	public WebElement getaRoom() {
		return aRoom;
	}

	public WebElement getRoomOption() {
		return roomOption;
	}

	public WebElement getcRoom() {
		return cRoom;
	}

	public WebElement getcRoomopt() {
		return cRoomopt;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	

}
