package utilities;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pgobjects.LoginPgObj;

public class BaseClass {

	public WebDriver driver = null;
	public CommonUtils commonUtils = null;
	public LoginPgObj loginPgObj;
	final static Logger log = Logger.getLogger(BaseClass.class.getName());
	
@Before
	public void includePageObjects() {
		driver = new FirefoxDriver();
		loginPgObj = new LoginPgObj(driver);
		commonUtils = new CommonUtils(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	

	
}