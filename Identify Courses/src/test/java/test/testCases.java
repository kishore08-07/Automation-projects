package test;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.courseraHomePage;
import Pages.forCampusPage;
import Pages.resultPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class testCases {

	courseraHomePage cs = new courseraHomePage();
	resultPage rp = new resultPage();
	forCampusPage fc = new forCampusPage();
	private ExtentTest extendTest;
	private ExtentReports extendreports;

	@Test(priority = 1)
	public void driversetup() throws IOException {
		cs.driverSetup();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\report\\extentReport.html");
		htmlReporter.config().setDocumentTitle("Coursera Report");
		htmlReporter.config().setReportName("Test report");
		extendreports = new ExtentReports();
		extendreports.attachReporter(htmlReporter);
	}

	@Test(priority = 2)
	public void search() throws Exception {
		extendTest = extendreports.createTest("Module:1 search");
		try {
			cs.search();
			extendTest.log(Status.INFO, "The search result should be shown");
			extendTest.log(Status.PASS, "The search result is shown successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "The search result is not Displayed");
			e.getMessage();
			throw new Exception(e);
		}
	}

	@Test(priority = 3)
	public void checkbox() throws Exception {
		extendTest = extendreports.createTest("Module:2 checkbox");
		try {
			rp.checkBox();
			extendTest.log(Status.INFO, "The checkbox should be clicked");
			extendTest.log(Status.PASS, "The checkbox is clicked successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "The checkbox is not clicked");
			e.getMessage();
			throw new Exception(e);

		}
	}

	@Test(priority = 4)
	public void allLanguages() throws Exception {
		extendTest = extendreports.createTest("Module:3 all Languages");
		try {
			rp.allLanguages();
			extendTest.log(Status.INFO, "All Languages should be printed");
			extendTest.log(Status.PASS, "All Languages were printed successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "All Languages were not printed");
			e.getMessage();
			throw new Exception(e);

		}
	}

	@Test(priority = 5)
	public void nameResults() throws Exception {
		extendTest = extendreports.createTest("Module:4 Name Results");
		try {
			rp.nameResults();
			extendTest.log(Status.INFO, "All Name Results should be  printed ");
			extendTest.log(Status.PASS, "All Name Results were printed successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "All Name Results are not printed");
			e.getMessage();
			throw new Exception(e);

		}
	}

	@Test(priority = 6)
	public void differentLevels() throws Exception {

		extendTest = extendreports.createTest("Module:5 different Levels");
		try {
			rp.differentLevels();
			extendTest.log(Status.INFO, "Different Levels should be printed ");
			extendTest.log(Status.PASS, "Different Levels were printed successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "Different Levels were not printed");
			e.getMessage();
			throw new Exception(e);

		}
	}

	@Test(priority = 7)
	public void forcampus() throws Exception {
		extendTest = extendreports.createTest("Module:6 forcampusIcon");
		try {
			fc.forCampus();
			extendTest.log(Status.INFO, "forcampusIcon should be clicked");
			extendTest.log(Status.PASS, "forcampusIcon is clicked successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "forcampusIcon is not clicked ");
			e.getMessage();
			throw new Exception(e);

		}
	}

	@Test(priority = 8)
	public void contactUS() throws Exception {
		extendTest = extendreports.createTest("Module:7 contactUsICon");
		try {
			fc.contactUs();
			extendTest.log(Status.INFO, "contactUsICon should be clicked");
			extendTest.log(Status.PASS, "contactUsICon is clicked successfully");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "contactUsICon is not clicked");
			e.getMessage();
			throw new Exception(e);
		}
	}

	@Test(priority = 9)
	public void screenshot() throws Exception {
		extendTest = extendreports.createTest("Module:8 screenshot");
		try {
			fc.screenshot();
			extendTest.log(Status.INFO, "screenshot should be taken");
			extendTest.log(Status.PASS, "screenshot is taken successfully");
			extendTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "\\screenshot\\Kishore.png");
		} catch (Exception e) {
			extendTest.log(Status.FAIL, "screenshot is not taken ");
			e.getMessage();
			throw new Exception(e);

		}
	}

	@Test(priority = 10)
	public void quit() throws InterruptedException, IOException {
		fc.quit();
		extendreports.flush();
	}

}
