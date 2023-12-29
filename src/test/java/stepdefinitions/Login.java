package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageojects.AccountPage;
import pageojects.LandingPage;
import pageojects.LoginPage;
import resources.Baseclass;

public class Login extends Baseclass {
	WebDriver driver;

	@Given("Open any Browser")
	public void open_any_browser() throws IOException {
		driver = initializebrowser();
	}

	@Given("Navigate to Login page")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("url"));

	}

	@When("User enters username as {string} and password as {string} into the fields")
	public void user_enters_username_as_and_password_as_into_the_fields(String string, String string2)
			throws InterruptedException {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		Thread.sleep(5000);
		landingPage.loginoption().click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailBox().sendKeys(string);

		loginPage.passwordBox().sendKeys(string2);

	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginButton().click();
	}

	@Then("Verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {
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
		AssertJUnit.assertEquals(actualResult, "Successfull");

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
