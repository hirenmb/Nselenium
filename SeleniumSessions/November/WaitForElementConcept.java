package November;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import NSelenium.NSelenium.ElimentUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept {
	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		By username = By.name("username");
		By password = By.name("password");
		By loginBtn = By.xpath("//input[@type='submit']");
		By link = By.xpath("//div[@id='navbar-collapse'] //li");
		int timeOut = 10;
		long intervalTime = 2000;
		String sValue = "Hiren";
		By clkContact = By.xpath("//a[text()='Contact']");
		ElimentUtil eu  =  new ElimentUtil(driver);
		eu.doSendKeys(username, timeOut, sValue);
	
		
		
		//	WebElement userName_ele=eu.doPreseneceOfElementLocated(username,  timeOut);
		//TimeoutException: Expected condition failed: waiting for presence of element located by: By.name: username11 
		//(tried for 10 second(s) with 500 milliseconds interval)
	
		try {
			eu.waitElementTobeVisbile(password, timeOut, intervalTime).sendKeys("test123");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			List<WebElement> linkList = eu.waitElementsTobeVisbile(link, timeOut, intervalTime);
				eu.elementsPrint(linkList);			
		}
		
	 //driver.findElement(password).sendKeys("test123");
		eu.doPreseneceOfElementLocated(loginBtn, timeOut, intervalTime).click();
		eu.click(clkContact);
		String cntct = "contact";
		if(eu.waitForURLToBe(cntct , timeOut)) {
			System.out.println("URL match found");
		}
	}

}
