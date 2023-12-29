package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageojects.AccountPage;
import pageojects.LandingPage;
import pageojects.LoginPage;
import resources.Baseclass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends Baseclass {
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void urlopening() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());

		driver = initializebrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");

	}

	@Test(dataProvider = "getData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {
		log = LogManager.getLogger(LoginTest.class.getName());
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		Thread.sleep(5000);
		landingPage.loginoption().click();
		log.debug("Clicked on URL");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailBox().sendKeys(email);
		log.debug("The Email enetred is" + email);
		loginPage.passwordBox().sendKeys(password);
		log.debug("The Password enetred is" + password);
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		AccountPage accountPage = new AccountPage(driver);

		// Assert.assertTrue(accountPage.editaccountinformation().isDisplayed());
		String actualResult = null;
		try {
			if (accountPage.editaccountinformation().isDisplayed()) {
				actualResult = "Successfull";
			}
		} catch (Exception e) {
			actualResult = "Failed";
		}
		AssertJUnit.assertEquals(actualResult, expectedStatus);

		// System.out.println(accountPage.editaccountinformation().isDisplayed());

	}

	@AfterMethod
	public void closeBrowser() {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "aditya123@gmail.com", "cricket100", "Successfull" },
				{ "aditya1234@gmail.com", "dummy123", "Failed" } };
		return data;
	}
}
