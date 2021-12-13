package November;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import NSelenium.NSelenium.ElimentUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitforNonWebElement {

static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		By clkContact = By.xpath("//a[text()='Contact']");
		int timeOut = 5;
		ElimentUtil eu  =  new ElimentUtil(driver);
		eu.click(clkContact);
		String cntct = "contact";
		if(eu.waitForURLToBe(cntct , timeOut)) {
			System.out.println("URL match found");
		}

		
		
		

	}

}
