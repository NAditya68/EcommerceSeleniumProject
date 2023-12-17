import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProgam {
	public static void main(String[] args) {
		// Set the path to the ChromeDriver executable (download it from
		System.setProperty("webdriver.chrome.driver",
				"/home/aditya/Downloads/chromedriver-linux6401/chromedriver-linux64/chromedriver");
		// WebDriverManager.chromedriver().setup();

		// WebDriverManager.chromedriver().setup();
		// ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.addArguments("--disable-browser-side-navigation");
//		options.addArguments("--remote-allow-origins=*");
		// options.setBrowserVersion("114");
		ChromeDriver driver = new ChromeDriver();
		// Create a new instance of the ChromeDriver
		// WebDriver driver = new ChromeDriver();

		// Navigate to Google
		driver.get("https://www.google.com");

		// Find the search box element by name
//		WebElement searchBox = driver.findElement(By.name("q"));
//
//		// Enter a search query
//		searchBox.sendKeys("Selenium WebDriver");
//
//		// Find the Google Search button using its name attribute value
//		WebElement searchButton = driver.findElement(By.name("btnK"));
//		System.out.println(driver.getTitle());
//
//		// Click the Google Search button
//		searchButton.click();
//
//		// Wait for a few seconds to see the search results
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		// Close the browser
		// driver.quit();
	}
}
