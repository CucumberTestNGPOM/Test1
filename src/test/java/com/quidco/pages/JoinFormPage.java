package com.quidco.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.quidco.base.TestBase;

public class JoinFormPage extends TestBase {

	public WebDriver driver;
	public String invalidemailerror="Email address is invalid";
	public String invalidpassworderror="Oops, that's not long enough";
	
	
	public JoinFormPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="first_name_join")   public WebElement Firstname;
	@FindBy(id="last_name_join")    public WebElement Lastame;
	@FindBy(id="new_email_join")    public WebElement Email;
	@FindBy(id="new_password_join") public WebElement Password;
	@FindBy(xpath="//input[@name='agree_to_terms']") public WebElement Tc;
	@FindBy(id="join-quidco-submit-button") public WebElement submit;
	@FindBy(xpath="html/body/div[3]/div[4]/div[3]/div[2]/div/div/div[1]/form/fieldset/div[3]/div/div")
	public WebElement invalidemailerrormess;
	@FindBy(xpath="html/body/div[3]/div[4]/div[3]/div[2]/div/div/div[1]/form/fieldset/div[4]/div/div")
	public WebElement passworderrrmess;
	
	
	
	public void join_with_valid_details(String firstname, String lastname, String email, String password) throws InterruptedException, IOException
	{
		Initialized();
		sendkeys(Firstname, firstname);
		sendkeys(Lastame, lastname);
		sendkeys(Email, email);
		sendkeys(Password, password);
		Thread.sleep(3000);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 350)");
        jse.executeScript("arguments[0].click();",Tc);
        clickOn(submit);
        Thread.sleep(3000);
    }
	public void validate_invalid_emailerror(String invalidemail) throws InterruptedException
	{
		sendkeysEnter(Email, invalidemail);
		String ActualError=invalidemailerrormess.getText();
		if(ActualError.equalsIgnoreCase(invalidemailerror))
		{
			System.out.println(ActualError +"="+ invalidemailerror);
		}else{
			System.err.println("The Expected and Actual Results are not Matched ");
		}
			
		
	}
	public void validate_invalid_password(String invalidpassword) throws InterruptedException
	{
		sendkeysEnter(Password,invalidpassword);
		String ActualError=passworderrrmess.getText();
		if(ActualError.equalsIgnoreCase(invalidpassworderror))
		{
			System.out.println(ActualError +"="+ invalidpassworderror);
		}else{
			System.err.println("The Expected and Actual Results are not Matched ");
		}
	}
	
}

