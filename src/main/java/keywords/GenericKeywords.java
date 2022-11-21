package keywords;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class GenericKeywords {
	
	WebDriver driver;
	
	Properties envProp;
	
	Properties prop;
	
	SoftAssert softAssert;
	
	//true -- if element is visible
	//false -- if element is not visible
	
	public boolean isElementVisible(String locatorKey)
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try
		{
		wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
		

		
		
	}
	//true -- if element is present
	//false -- if element is not present
	
	public boolean isElementPresent(String locatorKey)
	{
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try
		{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getLocator(locatorKey)));
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
		
	
		
		
		
	}
	
	public List<WebElement> getElements(String locatorKey)
	{
		
		List<WebElement> elements = driver.findElements(getLocator(locatorKey));
		
		
		return elements;
	}
	public WebElement getElement(String locatorKey)
	{
		
		
		//presence of element
		
		if(!isElementPresent(locatorKey))
		{
			return null;
		}
		
		//visbilibity of element
		
		if(!isElementVisible(locatorKey))
		{
			return null;
		}
		
		
		
		WebElement element = driver.findElement(getLocator(locatorKey));
		
		
		return element;
		
	}
	
	public By getLocator(String locatorKey)
	{
		
		
		By by=null;
		
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(prop.getProperty(locatorKey));
		}

		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_css"))
		{
			by=By.cssSelector(prop.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(prop.getProperty(locatorKey));
		}
		
		return by;
		
		
	}
	
	public void click(String locatorKey)
	{
		
		getElement(locatorKey).click();
		
	}
	
	public void wait(int noOfSeconds)
	{
		try {
			Thread.sleep(noOfSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickEnterButton(String locatorKey)
	{
		getElement(locatorKey).sendKeys(Keys.ENTER);
	}

	public String getText(String locatorKey)
	{
		
		return getElement(locatorKey).getText();
		
	}
	
	public void selectByVisibleText(String locatorKey, String text)
	{
		
		new Select(getElement(locatorKey)).selectByVisibleText(text);
	}
	
	public void type(String locatorKey, String text)
	{
		getElement(locatorKey).sendKeys(text);
	}

	public void takeScreenShot()
	{
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String screenShotFile = simpleDateFormat.format(new Date());
		
		screenShotFile=screenShotFile.replace(":", "-");
		
		String screenshotDirPath=System.getProperty("user.dir")+"\\screenshots";
		
		File screenshotDir=new File(screenshotDirPath);
		
		screenshotDir.mkdir();
		try
		{
		FileUtils.copyFile(srcFile, new File(screenshotDirPath+"\\"+screenShotFile+".png"));
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void waitForPageToLoad()
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		String status=(String) js.executeScript("return document.readyState;");
		int i=1;
		while(i<10)
		{
			if(status.equals("complete"))
			{
				break;
			}
			else
			{
				wait(2);
			}
			
			i++;
		}
	}
	
	public void quit()
	{
		driver.quit();
	}
	
	
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	
}
