package Adactin.AdactinProject;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.BaseClass.Base_Class;
import com.POMsdp.AdactinPOM;
import com.PropertyFile.AdactinFileReaderManager;

public class Adactin_RunnerClass extends Base_Class {

	public static WebDriver driver = launchDriver("chrome");
	public static AdactinPOM apom = new AdactinPOM(driver);
	static Logger log = Logger.getLogger(Adactin_RunnerClass.class);

	public static void main(String[] args) throws Exception {

		PropertyConfigurator.configure("log4j.properties");

		String url = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getUrl();

		url(url);

		log.info("URL launced sucessfully");

		impWait(10);

		action("lc", apom.getInstanceAlp().getUname());

		String userName = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getUserName();
		
		System.out.println(userName.length());

		input(apom.getInstanceAlp().getUname(), userName);

		action("lc", apom.getInstanceAlp().getPsw());

		String pass = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getPass();
		System.out.println(pass.length());
		input(apom.getInstanceAlp().getPsw(), pass);

		action("lc", apom.getInstanceAlp().getLog());

		log.info("login sucessfully");

		impWait(10);
		sleep(5000);

		action("lc", apom.getInstanceSh().getLoc());

		click(apom.getInstanceSh().getSelect());

		action("lc", apom.getInstanceSh().getHotel());

		click(apom.getInstanceSh().getHotelSelect());

		action("lc", apom.getInstanceSh().getRoom());

		click(apom.getInstanceSh().getType());

		action("lc", apom.getInstanceSh().getRoomNo());

		click(apom.getInstanceSh().getOption());

		click(apom.getInstanceSh().getDateIn());
		clear(apom.getInstanceSh().getDateIn());
		String checkInDate = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getCheckInDate();
		System.out.println(checkInDate.length());
		input(apom.getInstanceSh().getDateIn(), checkInDate);

		click(apom.getInstanceSh().getDateOut());
		clear(apom.getInstanceSh().getDateOut());
		String checkOutDate = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getCheckOutDate();
		System.out.println(checkOutDate.length());
		input(apom.getInstanceSh().getDateOut(), checkOutDate);
		
		click(apom.getInstanceSh().getaRoom());

		click(apom.getInstanceSh().getRoomOption());

		action("lc", apom.getInstanceSh().getcRoom());

		click(apom.getInstanceSh().getcRoomopt());

		action("lc", apom.getInstanceSh().getSubmit());

		impWait(10);

		log.info("Hotel search sucessfull");

		action("lc", apom.getInstanceSeh().getRadioButton());

		action("lc", apom.getInstanceSeh().getCont());

		impWait(10);

		log.info("Hotel selected sucessfully");

		action("lc", apom.getInstanceBh().getFirstName());

		String firstName = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getFirstName();
		input(apom.getInstanceBh().getFirstName(), firstName);

		action("lc", apom.getInstanceBh().getLastName());

		String lastName = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getLastName();
		input(apom.getInstanceBh().getLastName(), lastName);

		action("movceto", apom.getInstanceBh().getAdd());

		String address = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getAddress();
		input(apom.getInstanceBh().getAdd(), address);

		action("lc", apom.getInstanceBh().getCcNum());

		String cardNumber = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getCardNumber();
		System.out.println(cardNumber.length());
		input(apom.getInstanceBh().getCcNum(), cardNumber);

		action("lc", apom.getInstanceBh().getCcType());

		click(apom.getInstanceBh().getCcOptions());

		action("lc", apom.getInstanceBh().getExpMonth());

		click(apom.getInstanceBh().getExpOptions());

		action("lc", apom.getInstanceBh().getExpYear());

		click(apom.getInstanceBh().getYearOptions());

		action("lc", apom.getInstanceBh().getCvv());
		String cvv = AdactinFileReaderManager.getAdactinFRM().getAdactinCR().getCvv();
		System.out.println(cvv.length());
		input(apom.getInstanceBh().getCvv(), cvv);

		action("lc", apom.getInstanceBh().getBook());

		impWait(10);

		log.info("hotel booked sucessfully ");

		action("lc", apom.getInstanceMi().getItinerary());

		screenShot("Adactin booking runner");

		impWait(10);

		click(apom.getInstanceLo().getLogout());

		screenShot("Adactin logout pom");

		log.info("logout sucessfully");
		quit("quit");

	}

}
