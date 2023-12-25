package listners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.*;

import resources.Baseclass;

public class Listeners extends Baseclass implements ITestListener {
	WebDriver driver = null;

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testname = result.getName();
		String testMethodName = result.getName();

		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			takeScreenshot(testMethodName, driver);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
