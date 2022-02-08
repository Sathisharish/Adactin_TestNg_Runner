package com.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.BaseClass.Base_Class;

public class Parallel_Guru99 extends Base_Class {
	
	 @Test    
	    public void executSessionOne(){
	            //First session of WebDriver
			WebDriver driver = launchDriver("chrome");
	            //Goto guru99 site
	            driver.get("http://demo.guru99.com/V4/");
	            //find user name text box and fill it
	            driver.findElement(By.name("uid")).sendKeys("Driver 1");
	            
	        }
	        
	    @Test    
	        public void executeSessionTwo(){
	            //Second session of WebDriver
	    	WebDriver driver = launchDriver("chrome");
	            //Goto guru99 site
	        driver.get("http://demo.guru99.com/V4/");
	        //find user name text box and fill it
	        driver.findElement(By.name("uid")).sendKeys("Driver 2");
	        
	        }
	        
	    @Test    
	        public void executSessionThree(){
	            //Third session of WebDriver
	    	WebDriver driver = launchDriver("chrome");
	            //Goto guru99 site
	        driver.get("http://demo.guru99.com/V4/");
	        //find user name text box and fill it
	        driver.findElement(By.name("uid")).sendKeys("Driver 3");
	        
	        }        
	
}
