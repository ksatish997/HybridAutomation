package examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateLoginPage2 {
	
	@Test
	public void validateLoginPageTest()
	{
		SoftAssert softAssertion=new SoftAssert();
		
		System.out.println("Test started.................");
		softAssertion.assertEquals(5, 6, "Numbers are not same");
		System.out.println("Soft assert1 is done ..");
		softAssertion.assertTrue("hello".equals("Hello"), "String are not equal");
		System.out.println("soft assert2 is done ..");
		System.out.println("Test ended successfully.................");
		
		softAssertion.assertAll();
	}

}
