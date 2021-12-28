package com.POMsdp;

import org.openqa.selenium.WebDriver;

import com.AdactinPom.AdactinLp;
import com.AdactinPom.BookHotel;
import com.AdactinPom.LogOut;
import com.AdactinPom.MyItinerray;
import com.AdactinPom.SearchHotel;
import com.AdactinPom.SelectHotel;

public class AdactinPOM {

	public static WebDriver driver;

	private static AdactinLp alp;
	private static SearchHotel sh;
	private static SelectHotel seh;
	private static BookHotel bh;
	private static MyItinerray mi;
	private static LogOut lo;

	public AdactinPOM(WebDriver driver2) {
		this.driver = driver2;
	}

	public AdactinLp getInstanceAlp() {

		if (alp == null) {

			alp = new AdactinLp(driver);

		}
		return alp;
	}

	public SearchHotel getInstanceSh() {
		if (sh == null) {
			sh = new SearchHotel(driver);

		}
		return sh;
	}

	public SelectHotel getInstanceSeh() {
		if (seh == null) {
			seh = new SelectHotel(driver);
		}
		return seh;
	}

	public BookHotel getInstanceBh() {
		if (bh == null) {
			bh = new BookHotel(driver);
		}
		return bh;
	}

	public  MyItinerray getInstanceMi() {
		if (mi == null) {
			mi = new MyItinerray(driver);
		}
		return mi;
	}

	public LogOut getInstanceLo() {
		if (lo == null) {
			lo = new LogOut(driver);
		}
		return lo;
	}

}
