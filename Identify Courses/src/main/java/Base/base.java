package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String url;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Properties properties;

	public void driverSetup() throws IOException {
		properties = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		properties.load(file);
		String driverSelection = properties.getProperty("browser").toLowerCase();

		switch (driverSelection) {

		case "chrome":

			chromeDriverSetup();

			break;

		case "edge":

			edgeDriverSetup();

			break;

		default:

			System.out.println("Invalid Input");

		}

		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		excel();
	}

	private void chromeDriverSetup() {

		System.setProperty("webdriver.chrome.driver",

				System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	private void edgeDriverSetup() {

		System.setProperty("webdriver.edge.driver",

				System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
	}

	public Sheet excel() throws IOException {
		FileInputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\InputDatas.xlsx");
		workbook = new XSSFWorkbook(inputStream);
		return sheet = workbook.getSheetAt(0);
	}

	public void navigation() {
		driver.navigate().back();
	}

	public void quit() throws InterruptedException, IOException {
		TimeUnit.SECONDS.sleep(5);
		workbook.close();
		driver.quit();
	}

}
