package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Baseclass {

	public Properties prop;

	public WebDriver initializebrowser() throws IOException {
		ChromeDriver driver = null;
		prop = new Properties();
		String propath = System.getProperty("user.dir") + "/src/main/java/resources/data.properties";
		FileInputStream fis = new FileInputStream(propath);
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			// driver.get("https://googlechromelabs.github.io/chrome-for-testing/#stable");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

}
