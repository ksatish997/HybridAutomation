package keywords;

import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords{

	public boolean validateTitle(String expTitle)
	{
		
		Assert.assertEquals(getTitle(), expTitle,"Title doesn't match .........");
		
		return false;
		
	}
	
	public void  validateText(String locatorKey,String text)
	{
		softAssert.assertTrue(getText(locatorKey).contains(text), "Text is not matched");
	}
	
	
}
