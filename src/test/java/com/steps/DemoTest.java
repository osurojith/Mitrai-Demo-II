package com.steps;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pgobjects.LoginPgObj;
import utilities.CommonUtils;

public class DemoTest {
	
	public CommonUtils commonUtils;
	public LoginPgObj loginPgObj;
	public WebDriver driver = null;
	final static Logger log = Logger.getLogger(DemoTest.class.getName());
	
	@cucumber.api.java.Before
	public void includePageObjects() {
		driver = new FirefoxDriver();
		loginPgObj = new LoginPgObj(driver);
		commonUtils = new CommonUtils(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	@Given("^user direct to the site \"([^\"]*)\"$")
	public void user_direct_to_the_site(String url) throws Throwable {
		commonUtils.getUrl(url);
		log.info("url is :"+url);
		driver.manage().window().maximize();
		try {
			commonUtils.takeSnapShot("HomePage.png") ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

	@Given("^user enter username \"([^\"]*)\"$")
	public void user_enter_username(String user) throws Throwable {
		//start of login test
				commonUtils.takeSnapShot("LoginSuccess.png") ;
				commonUtils.sendKeys(loginPgObj.userName_txt,user );
				

	    
	}

	@Given("^user enter password \"([^\"]*)\"$")
	public void user_enter_password(String pass) throws Throwable {
		commonUtils.sendKeys(loginPgObj.password_txt,pass );
		
	    
	}

	@When("^user click on the login button$")
	public void user_click_on_the_login_button() throws Throwable {
	    
		commonUtils.click(loginPgObj.login_btn);
		Thread.sleep(5000);
		
	}

	@Then("^validate home page \"([^\"]*)\"$")
	public void validate_home_page(String url) throws Throwable {
		if(commonUtils.assertValue("Validate LogIn",commonUtils.getCurrentUrl(), url)){
			System.out.println("Test Passed");
		}else{
			System.out.println("Test Failed");
		}
		
			commonUtils.takeSnapShot("LoginSuccess.png") ;
	}

	
	}
	

