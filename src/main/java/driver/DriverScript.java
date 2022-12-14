package driver;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentTest;

import keywords.ApplicationKeywords;

public class DriverScript {
	
	public ApplicationKeywords app;
	
	public ITestContext context;
	
	public DriverScript()
	{
		
		app=new ApplicationKeywords();
	}
	
	
	public void quit() {
		if(app!=null)
			app.quit();
		
	}

	

	public void log(String logMessage) {
		app.log(logMessage);
		
	}

	public void setTestContext(ITestContext context) {
		this.context=context;
		app.setTestContext(context);
		
	}

	public void setReport(ExtentTest test)
	{
		app.setReport(test);
	}

	public void defaultLogin(String browser)
	{
		
		app.openBrowser(browser);
		
		
	}
	
}
