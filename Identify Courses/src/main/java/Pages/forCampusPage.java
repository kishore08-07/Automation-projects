package Pages;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import Base.base;



public class forCampusPage extends base {



	private By forCampusLink = By.linkText("For Campus");
	private By contactUsICon = By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[3]/div/a");
	private By firstNameField = By.xpath("//input[@placeholder='First Name']");
	private By lastNameField = By.xpath("//input[@placeholder='Last Name']");
	private By jobTitleField = By.xpath("//select[@id='Title']");
	private By departmentField = By.id("Department");
	private By workEmailField = By.xpath("//input[@id='Email']");
	private By phoneNumberField = By.xpath("//input[@id='Phone']");
	private By institutionNameField = By.xpath("//input[@id='Company']");
	private By instiutionTypeField = By.id("Institution_Type__c");
	private By countryField = By.id("Country");
	private By bestDescribesField = By.id("What_the_lead_asked_for_on_the_website__c");
	private By submitField = By.xpath("//button[@type='submit']");



	public void forCampus() throws InterruptedException {
		WebElement forCampus = driver.findElement(forCampusLink);
		wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.elementToBeClickable(forCampusLink));
		forCampus.click();
		driver.manage().timeouts().pageLoadTimeout(90,TimeUnit.SECONDS);
		//TimeUnit.SECONDS.sleep(5);
	}



	public void contactUs() throws InterruptedException {



		wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.presenceOfElementLocated(contactUsICon));
		WebElement contactUs = driver.findElement(contactUsICon);
		contactUs.click();
		//wait until name field appears
		wait.until(ExpectedConditions.presenceOfElementLocated(firstNameField));
		WebElement firstName = driver.findElement(firstNameField);
		//gets values from excel sheet
		firstName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		//last name
		wait.until(ExpectedConditions.presenceOfElementLocated(lastNameField));
		WebElement lastName = driver.findElement(lastNameField);
		lastName.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		//job title
		wait.until(ExpectedConditions.presenceOfElementLocated(jobTitleField));
		WebElement jobTitle = driver.findElement(jobTitleField);
		Select select = new Select(jobTitle);
		select.selectByIndex(1);
		//jobTitle.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		//dropdown box
		wait.until(ExpectedConditions.presenceOfElementLocated(departmentField));
		WebElement department = driver.findElement(departmentField);
		Select select12 = new Select(department);
		select12.selectByIndex(3);
		//TimeUnit.SECONDS.sleep(5);
		wait.until(ExpectedConditions.presenceOfElementLocated(workEmailField));
		WebElement workEmail = driver.findElement(workEmailField);
		workEmail.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		//phone number
		wait.until(ExpectedConditions.presenceOfElementLocated(phoneNumberField));
		WebElement phoneNumber = driver.findElement(phoneNumberField);
		phoneNumber.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
		//institution name
		wait.until(ExpectedConditions.presenceOfElementLocated(institutionNameField));
		WebElement institutionName = driver.findElement(institutionNameField);
		institutionName.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
		//dropdown box
		wait.until(ExpectedConditions.presenceOfElementLocated(instiutionTypeField));
		WebElement institutionType = driver.findElement(instiutionTypeField);
		Select select1 = new Select(institutionType);
		select1.selectByIndex(4);
		TimeUnit.SECONDS.sleep(1);
		wait.until(ExpectedConditions.presenceOfElementLocated(countryField));
		WebElement country = driver.findElement(countryField);
		Select select2 = new Select(country);
		select2.selectByIndex(1);
		TimeUnit.SECONDS.sleep(1);
		wait.until(ExpectedConditions.presenceOfElementLocated(bestDescribesField));
		WebElement bestDescribes = driver.findElement(bestDescribesField);
		Select select3 = new Select(bestDescribes);
		select3.selectByVisibleText("Meet with Coursera Sales Team");
		TimeUnit.SECONDS.sleep(1);
	
		wait.until(ExpectedConditions.elementToBeClickable(submitField));
		WebElement submit = driver.findElement(submitField);
		submit.click();

	}

	public void screenshot() throws IOException, InterruptedException {
		//TimeUnit.SECONDS.sleep(3);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotfile = screenshot.getScreenshotAs(OutputType.FILE);
		File dfile=new File(System.getProperty("user.dir") + "\\screenshot\\Kishore.png");
		FileHandler.copy(screenshotfile, dfile);

	}
}