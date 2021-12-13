package NSelenium.NSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest extends BrowserUtil {
	static WebDriver driver;
	static By id;

	public static void main(String args[]) throws InterruptedException {
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.enterUrl("https://demo.opencart.com/index.php?route=account/register");
		ElimentUtil rp = new ElimentUtil(driver);
		String fName = "//*[@id='input-firstname']";
		String email = "input-email";
		String lName = "input-lastname";
		String phone = "input-telephone";
		String pwd = "input-password";
		String cpwd = "input-confirm";
		rp.doSendKeys("xpath", fName, "Hiren");
		rp.doSendKeys("id", lName, "Patel");
		rp.doSendKeys("id", email, "hiren@gmail.com");
		rp.doSendKeys("id", phone, "6476216363");
		rp.doSendKeys("id", pwd,"admin@123");
		rp.doSendKeys("id", cpwd,"admin@123");
		System.out.println(br.getPageTitle());
		Thread.sleep(5000);
		//br.closeBrowser();
		By locator = By.id("input-email");
		String value = "New@newemaild.com";
		rp.doSendKeys(locator, value);

	}


}
