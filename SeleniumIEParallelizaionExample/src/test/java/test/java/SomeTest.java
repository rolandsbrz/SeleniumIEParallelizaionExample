package test.java;

import static org.junit.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SomeTest {

	public String version = "10";
	private WebDriver driver;
	InitBrowser init = new InitBrowser();
	Methods methods = new Methods();
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeMethod
	public void init() throws Exception{
		this.driver = init.loadDriver(version);
	}

	@Test
	public void testSite1A() {
		methods.testSite(driver);
	}
	
	@Test
	public void testSite1B() {
		methods.testSite(driver);
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		driver.quit();
		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	
}