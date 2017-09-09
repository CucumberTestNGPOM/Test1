package com.quidco.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.quidco.base.TestBase;
import com.quidco.pages.HomePage;
import com.quidco.pages.JoinFormPage;

public class ValidateErrorMessages extends TestBase {

	@Test
	public void validate_email_error_message() throws IOException, InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.join();
		JoinFormPage jf=new JoinFormPage(driver);
		jf.validate_invalid_emailerror("invalidemail");
	}
	@Test
	public void validate_password_error_message() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.join();
		JoinFormPage jf=new JoinFormPage(driver);
		jf.validate_invalid_password("invalidpassword");
	}
	
}
