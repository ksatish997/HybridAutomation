package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords {
	
	Properties prop1;
	
	
	public ApplicationKeywords() 
	{
		
		try {
			FileInputStream fis1=new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
		    prop1=new Properties();
		    prop1.load(fis1);
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		softAssert=new SoftAssert();
	}
	
	
	
	
	public void setReport(ExtentTest test)
	{
		this.test=test;
	}

	public void defaultLogin()
	{
		navigate(prop1.getProperty(getTitle()));
		type("username_name", prop1.getProperty("username_name"));
		type("password_name", prop1.getProperty("password_name"));
		click("login_name");
		waitForPageToLoad();
		
	}
}
