package November;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import NSelenium.NSelenium.ElimentUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {

	public static void main(String[] args) {

		String url = "https://the-internet.herokuapp.com/frames";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		By iFrame = By.xpath("//a[text()='iFrame']");
		//By locator = 
		ElimentUtil eu = new ElimentUtil(driver);
		eu.click(iFrame);
		int timeOut = 5;
		//eu.click(iFrame);
		eu.waitforFrame(iFrame, timeOut);

	}
}
