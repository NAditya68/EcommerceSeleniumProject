package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Baseclass;

import org.testng.annotations.Test;

public class Test2 extends Baseclass {
	WebDriver driver;
	Logger log;

	@Test
	public void test2() throws IOException, InterruptedException {
		System.out.println("Test 2");
		log = LogManager.getLogger(LoginTest.class.getName());

		driver = initializebrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url2"));
		log.debug("Navigated to application URL");
		Thread.sleep(2000);
		driver.close();
	}
}
