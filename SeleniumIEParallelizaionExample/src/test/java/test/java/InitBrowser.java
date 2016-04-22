package test.java;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class InitBrowser {

	protected ThreadLocal<RemoteWebDriver> threadDriver = null;
	
	public WebDriver loadDriver(String browserVersion) throws Exception{
		DesiredCapabilities capab = new DesiredCapabilities();

		System.setProperty("webdriver.ie.driver", "C:\\selenium\\IEDriverServer.exe");
		threadDriver = new ThreadLocal<RemoteWebDriver>();
		capab = DesiredCapabilities.internetExplorer();
		capab.setBrowserName("internet explorer");
		capab.setVersion(browserVersion);
		capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capab));
		threadDriver.get().manage().window().maximize();
		threadDriver.get().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		threadDriver.get().manage().deleteAllCookies();
		
		return threadDriver.get();
	}
}
