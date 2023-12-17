package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageojects.AccountPage;
import pageojects.LandingPage;
import pageojects.LoginPage;
import resources.Baseclass;

public class LoginTest extends Baseclass {
	WebDriver driver;

	@BeforeMethod
	public void urlopening() throws IOException {
		driver = initializebrowser();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void login(String email, String password, String expectedStatus) throws IOException, InterruptedException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		Thread.sleep(5000);
		landingPage.loginoption().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailBox().sendKeys(email);
		loginPage.passwordBox().sendKeys(password);
		loginPage.loginButton().click();
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
		Assert.assertEquals(actualResult, expectedStatus);

		// System.out.println(accountPage.editaccountinformation().isDisplayed());

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = { { "aditya123@gmail.com", "cricket100", "Successfull" },
				{ "aditya1234@gmail.com", "dummy123", "Failed" } };
		return data;
	}
}
