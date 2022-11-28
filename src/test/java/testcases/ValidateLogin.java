package testcases;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLogin extends BaseTest {
	
	@Test
	public void validateLoginTest()
	{
		
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser("chrome");
		
		app.navigate("url");
		
		app.type("username_name", "reyaz0617");
		
		app.type("password_name", "reyaz123");
		
		app.quit();
	}

}
