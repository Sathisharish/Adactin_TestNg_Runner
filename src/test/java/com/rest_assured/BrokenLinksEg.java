package com.rest_assured;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksEg {

	@Test
	public void brokenLink() throws IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/links");

		List<WebElement> linkList = driver.findElements(By.tagName("a"));

		int size = linkList.size();
		System.out.println(size);

		for (WebElement link : linkList) {

			String url = link.getAttribute("href");
			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			try {

				URL htt = new URL(url);
				HttpURLConnection huc = (HttpURLConnection) htt.openConnection();

				huc.setRequestMethod("HEAD");

				huc.connect();

				int respCode = huc.getResponseCode();

				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * HttpURLConnection con = (HttpURLConnection) htt.openConnection();
		 * 
		 * con.setRequestMethod("HEAD");
		 * 
		 * con.connect();
		 * 
		 * int respCode = con.getResponseCode();
		 * 
		 * if (respCode>=400) { System.out.println("broken link");
		 * System.out.println(url); } else System.out.println("Non broken link"); }
		 */

	}

}
