package testcases;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import util.UtilKit;

public class ToVerifyValidLoginDetails extends BaseTest{
	
	@DataProvider
	public Object[][] testData()
	{
		return UtilKit.getData("com.adactin.hotelapp", "TC101");
	}
	
	
	@Test(dataProvider = "testData" )
	public void toVerifyValidLoginDetailsTest(String username,String pwd,String expTitle,String name)
	{
		ApplicationKeywords app= new ApplicationKeywords();
		
		app.openBrowser("chrome");
		app.navigate("url");
		app.type("username_name", username);
		app.type("password_name", pwd);
		app.click("login_name");
		app.validateTitle(expTitle);
		app.validateAttibuteValue("usernameshow_name", "value", name);
		app.quit();
		
		
	}

}
