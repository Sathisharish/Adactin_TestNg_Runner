package com.PropertyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AdactinConfigurationReader {

	public static Properties p;

	public AdactinConfigurationReader() throws IOException {
		File f = new File("C:\\Users\\heman\\eclipse-workspace\\AdactinProject\\AdactinCredentials.properties");
		FileInputStream fis = new FileInputStream(f);

		p = new Properties();
		p.load(fis);

	}

	public String getUrl() throws Exception {

		String url = p.getProperty("url");
		return url;

	}

	public String getUserName() {
		String userName = p.getProperty("userName");
		return userName;
	}

	public String getPass() {
		String pass = p.getProperty("password");
		return pass;
	}

	public String getCheckInDate() {
		String checkIn = p.getProperty("checkInDate");
		return checkIn;

	}

	public String getCheckOutDate() {
		String checkOut = p.getProperty("checkOutDate");
		return checkOut;
	}

	public String getFirstName() {

		String firstName = p.getProperty("firstName");
		return firstName;

	}

	public String getLastName() {

		String lastName = p.getProperty("lastName");
		return lastName;

	}

	public String getAddress() {

		String address = p.getProperty("address");
		return address;

	}

	public String getCardNumber() {
		String cardNumber = p.getProperty("cardNumber");
		return cardNumber;
	}

	public String getCvv() {
		String cvv = p.getProperty("cvv");
		return cvv;
	}
}
