package naga;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeleniumTest {
	ExtentReports extent;
	String path;
	@BeforeTest
	public void extentReport() {
		 path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Slenium Test");
		reporter.config().setReportName("Selenium Automation Test");
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Naga");
		
	}
	@Test
	public void getdata() throws InterruptedException {
		ExtentTest test= extent.createTest("Selenium Java Test");
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://gmail.com");
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.close();
		extent.flush();
	}
	@Test
	public void getBrowser() {
		System.out.println("Browser Application");
	}

}
