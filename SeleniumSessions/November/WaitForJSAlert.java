package November;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import NSelenium.NSelenium.ElimentUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForJSAlert {

	public static void main(String[] args) {

		String url = "https://mail.rediff.com/cgi-bin/login.cgi";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		By signUp = By.cssSelector("input[type='submit']");
		ElimentUtil eu  =  new ElimentUtil(driver);
		eu.click(signUp);
		int timeOut =5;
		eu.waitForAlert(timeOut);
		//driver.switchTo().alert().getText();
		
	}

}
