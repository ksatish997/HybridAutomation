package base;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driver.DriverScript;
import reports.ExtentManager;

public class BaseTest {

	public DriverScript  ds;
	
	public ExtentReports reports;
	
	public ExtentTest test;
	
	@BeforeTest(alwaysRun=true)
	public void beforeTest(ITestContext context)
	{
		reports=ExtentManager.getReports();
		test=reports.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting Test "+context.getCurrentXmlTest().getName());
		
		context.setAttribute("report", reports);
		context.setAttribute("test", test);
		
		ds=new DriverScript();
		ds.setReport(test);
		ds.defaultLogin("chrome");
		ds.setTestContext(context);
		context.setAttribute("driver", ds);
		
	}
		
	}

