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
	
	ITestContext context;
	
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
	
	
	public void setTestContext(ITestContext context)
	{
		this.context=context;
	}
	
	public void setReport(ExtentTest test)
	{
		this.test=test;
	}

}
