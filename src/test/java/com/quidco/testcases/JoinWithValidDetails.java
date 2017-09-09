package com.quidco.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.quidco.base.TestBase;
import com.quidco.pages.HomePage;
import com.quidco.pages.JoinFormPage;
import com.quidco.pages.WelcomePage;

public class JoinWithValidDetails extends TestBase {
	
	@Test
	public void join() throws InterruptedException, IOException
	{
		
		HomePage hp=new HomePage(driver);
		hp.join();
		JoinFormPage jf=new JoinFormPage(driver);
		jf.join_with_valid_details("firstname","lastname","email", "password");
		WelcomePage wp=new WelcomePage(driver);
		wp.validateJoinedUser();
	}

}
