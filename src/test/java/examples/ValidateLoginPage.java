package examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateLoginPage {
	
	@Test
	public void validateLoginPageTest()
	{
		System.out.println("Test started.................");
		Assert.assertEquals(5, 5, "Numbers are not same");
		System.out.println("Hard assert1 is done ..");
		Assert.assertTrue("hello".equals("Hello"), "String are not equal");
		System.out.println("Hard assert2 is done ..");
		System.out.println("Test ended successfully.................");
	}

}
