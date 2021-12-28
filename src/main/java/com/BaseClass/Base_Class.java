package com.BaseClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

	public static WebDriver driver;

	// ----------------------DRIVER-------------------------------------------------

	public static WebDriver launchDriver(String type) {

		if (type.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (type.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");

			driver = new FirefoxDriver();

		} else if (type.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\driver\\iedriver.exe");

			driver = new InternetExplorerDriver();

		} else if (type.equalsIgnoreCase("opera")) {

			System.setProperty("webdriver.opera.driver.", System.getProperty("user.dir") + "\\driver\\operadriver.exe");

			driver = new OperaDriver();

		} else if (type.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver.", System.getProperty("user.dir") + "\\driver\\edgedriver.exe");

			driver = new EdgeDriver();

		}

		return driver;

	}

	// ----------------------MAXIMIZE-------------------------------------------------

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// ----------------------URL-------------------------------------------------

	public static void url(String url) {

		driver.get(url);

	}

	// ----------------------WAIT-------------------------------------------------

	public static void impWait(int secondstime) {

		driver.manage().timeouts().implicitlyWait(secondstime, TimeUnit.SECONDS);

	}

	// ----------------------SLEEP-------------------------------------------------

	public static void sleep(int milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	// ----------------------CLICK-------------------------------------------------

	public static void click(WebElement element) {

		element.click();

	}
	// ----------------------CLEAR-------------------------------------------------

		public static void clear(WebElement element) {

			element.clear();

		}

	// ----------------------SENDKEYS-------------------------------------------------

	public static void input(WebElement element, String input) {

		element.sendKeys(input);

	}

	// ----------------------ACTIONS-------------------------------------------------

	public static void action(String type, WebElement element) {
		Actions ac = new Actions(driver);
		if (type.equalsIgnoreCase("lc")) {
			ac.moveToElement(element).click().perform();
		} else if (type.equalsIgnoreCase("moveto")) {
			ac.moveToElement(element).perform();
		} else if (type.equalsIgnoreCase("rc")) {
			ac.moveToElement(element).contextClick().perform();
		} else if (type.equalsIgnoreCase("doubleclick")) {
			ac.moveToElement(element).doubleClick().perform();
		}
	}

	// ----------------------JAVASCRIPT EXECUTOR-------------------------------------------------

	public static void js(String type, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (type.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click();", element);
		} else if (type.equalsIgnoreCase("scrollview")) {
			js.executeScript("arguments[0].scrollIntoView();", element);
		}
	}

	// ----------------------SCROLL UP AND SCROLL DOWN-------------------------------------------------

	public static void scroll(String type) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (type.equalsIgnoreCase("scrolldown")) {
			js.executeScript("window.scrollBy(0,350)", "");
		} else if (type.equalsIgnoreCase("scrollup")) {
			js.executeScript("window.scrollBy(0,-350)", "");
		}
	}

	// ----------------------DRAG AND DROP-------------------------------------------------

	public static void draganddrop(String type, WebElement source, WebElement destination) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions ac = new Actions(driver);

		if (type.equalsIgnoreCase("js")) {
			js.executeScript("function createEvent(typeOfEvent) {\n"
					+ "var event =document.createEvent(\"CustomEvent\");\n"
					+ "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n"
					+ "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
					+ "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
					+ "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
					+ "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
					+ "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
					+ "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
					+ "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
					+ "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
					+ "var dropEvent = createEvent('drop');\n"
					+ "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
					+ "var dragEndEvent = createEvent('dragend');\n"
					+ "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
					+ "var source = arguments[0];\n" + "var destination = arguments[1];\n"
					+ "simulateHTML5DragAndDrop(source,destination);", source, destination);
		}

		else if (type.equalsIgnoreCase("ac")) {

			ac.dragAndDrop(source, destination).perform();

		}

	}

	// ----------------------SELECT METHODS-------------------------------------------------

	public static void select(String type, WebElement element, String text) {
		Select s = new Select(element);
		if (type.equalsIgnoreCase("selecttext")) {
			s.selectByVisibleText(text);
		} else if (type.equalsIgnoreCase("selectvalue")) {
			s.selectByValue(text);
		} else if (type.equalsIgnoreCase("selectindex")) {
			int a = Integer.parseInt(text);
			s.selectByIndex(a);
		} else if (type.equalsIgnoreCase("deselecttext")) {
			s.deselectByVisibleText(text);
		} else if (type.equalsIgnoreCase("deselectvalue")) {
			s.deselectByValue(text);
		} else if (type.equalsIgnoreCase("deselectindex")) {
			int a = Integer.parseInt(text);
			s.deselectByIndex(a);
		} else if (type.equalsIgnoreCase("deselectall")) {
			s.deselectAll();
		} else if (type.equalsIgnoreCase("checkmultiple")) {
			boolean a = s.isMultiple();
			if (a == true) {
				System.out.println("Multiple dropdown");
			} else
				System.out.println("Single dropdown");
		} else if (type.equalsIgnoreCase("firstselect")) {
			WebElement a = s.getFirstSelectedOption();
			System.out.println("First selected option is " + a);
		} else if (type.equalsIgnoreCase("allselectedoption")) {
			List<WebElement> a = s.getAllSelectedOptions();
			for (WebElement b : a) {

			}
		}

	}

	// ----------------------SCREEN SHOT-------------------------------------------------

	public static void screenShot(String location) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File save = ts.getScreenshotAs(OutputType.FILE);
		File path = new File("C:\\Users\\heman\\eclipse-workspace\\RunnerClass_MiniProject\\ScreenShot\\Mini project\\"
				+ location + ".png");
		FileHandler.copy(save, path);

	}

	// ----------------------ROBOT-------------------------------------------------

	public static void down() throws AWTException {

		Robot ro = new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
		ro.keyRelease(KeyEvent.VK_DOWN);
	}

	// ----------------------QUIT and CLOSE-------------------------------------------------

	public static void quit(String type) {

		if (type.equalsIgnoreCase("quit")) {
			driver.quit();
		} else if (type.equalsIgnoreCase("close")) {
			driver.close();
		}

	}

	// ----------------------ALERT-------------------------------------------------

	public static void alert(String type) {

		if (type.equalsIgnoreCase("accept")) {

			driver.switchTo().alert().accept();

		} else if (type.equalsIgnoreCase("dismiss")) {
			driver.switchTo().alert().dismiss();
		} else if (type.equalsIgnoreCase("text")) {
			String a = driver.switchTo().alert().getText();
			System.out.println(a);
		} else {
			driver.switchTo().alert().sendKeys(type);
		}

	}

	// ----------------------FRAMES-------------------------------------------------

	public static void frame(String type) {

		if (type.equalsIgnoreCase("parentframe")) {
			driver.switchTo().parentFrame();
		} else if (type.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent();
		}

	}

	public static void switchframe(WebElement element) {
		driver.switchTo().frame(element);
	}

	// ----------------------NAVIGATE-------------------------------------------------

	public static void navigate(String type) {

		if (type.equalsIgnoreCase("refresh")) {

			driver.navigate().refresh();

		} else if (type.equalsIgnoreCase("back")) {
			driver.navigate().back();
		} else if (type.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}

	}

	public static void navigateLaunch(String url) {

		driver.navigate().to(url);

	}

	// ----------------------BOOLEAN-------------------------------------------------

	public static void is(String type, WebElement element) {

		if (type.equalsIgnoreCase("enable")) {

			boolean a = element.isEnabled();
			if (a == true) {
				System.out.println("Webelement is enabled");

			} else
				System.out.println("Webelement is not enabled");

		} else if (type.equalsIgnoreCase("displayed")) {

			boolean b = element.isDisplayed();
			if (b == true) {
				System.out.println("Webelement is displayed");

			} else
				System.out.println("Webelement is not displayed");
		} else if (type.equalsIgnoreCase("selected")) {

			boolean c = element.isSelected();
			if (c == true) {
				System.out.println("Webelement is selected");

			} else
				System.out.println("Webelement is not selected");
		}

	}

	// ----------------------GET METHODS----------------------------------------------

	public static void driverGet(String type) {

		if (type.equalsIgnoreCase("url")) {
			String url = driver.getCurrentUrl();
			System.out.println(url);
		} else if (type.equalsIgnoreCase("title")) {

			String title = driver.getTitle();
			System.out.println(title);
		} else if (type.equalsIgnoreCase("window")) {
			String windowHandle = driver.getWindowHandle();
			System.out.println(windowHandle);
		} else if (type.equalsIgnoreCase("windows")) {
			Set<String> windowHandle = driver.getWindowHandles();
			for (String string : windowHandle) {
				System.out.println(string);
			}
		}

	}

	public static void elementGet(String type, WebElement element) {

		if (type.equalsIgnoreCase("text")) {

			String text = element.getText();
			System.out.println(text);

		} else if (type.equalsIgnoreCase("value")) {

			String attribute = element.getAttribute("value");
			System.out.println(attribute);

		}

	}

	public static void switchwindow(String window) {

		driver.switchTo().window(window);

	}
	
	// ----------------------DATA DRIVEN----------------------------------------------

	public static String value;
	
	public static String dataDriven(String fileLocation,String type,String s ,int rowIndex,int cellIndex) throws IOException {
		
		File f = new File(fileLocation);
		
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(fis);

		if (type.equalsIgnoreCase("particulardata")) {

			Cell cell = w.getSheet(s).getRow(rowIndex).getCell(cellIndex);
			
			CellType cellType = cell.getCellType();
			
			if (cellType.equals(CellType.STRING)) {
				
				value = cell.getStringCellValue();
				
			}
			else if (cellType.equals(CellType.NUMERIC)) {
				
				double cellValue = cell.getNumericCellValue();
				
			//	int cellvalue = (int) cellValue;
				
				value = String.valueOf(cellValue);
				
				
			}
				
		}
		return value;
		
	}

}
