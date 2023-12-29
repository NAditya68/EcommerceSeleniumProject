package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentReport;

	public static ExtentReports getExtentReport() {

		String extentReportPath = System.getProperty("user.dir") + "/reports/extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName(" Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System", "Ubuntu 18.04");
		extentReport.setSystemInfo("Tested By", "Aditya");

		return extentReport;

	}


}
