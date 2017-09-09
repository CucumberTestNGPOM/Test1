package com.quidco.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quidco.base.TestBase;

public class WelcomePage extends TestBase {
	public WebDriver driver;
	public String ActualUser;
	
	public WelcomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="html/body/div[3]/div[2]/div/div[2]/div/div/div/div[1]/h1") 
	public WebElement Userjoined;
	 
	 public void validateJoinedUser()
	 {
		 validate_Joined_User(Userjoined, "firstname");
	 }
	
	
}
