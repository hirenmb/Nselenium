import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NSelenium.NSelenium.ElimentUtil;

public class DynamicWebTable {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.enterUrl("https://classic.crmpro.com/index.html");
		String title = br.getPageTitle();
		System.out.println(title);
		/*
		 * User name and Password : URL-
		 */
		String username = "groupautomation";
		String password = "Test@12345";

		ElimentUtil eu = new ElimentUtil(driver);
		By userLocator = By.xpath("//*[@id=\"loginForm\"]/div/input[1]");
		By pwdLocator = By.xpath("//*[@id=\"loginForm\"]/div/input[2]");
		By loginLocator = By.xpath("//*[@id=\"loginForm\"]/div/div/input");
		By contctLocator = By.linkText("CONTACTS");
		WebElement checkBox;
		eu.doSendKeys(userLocator, username);
		eu.doSendKeys(pwdLocator, password);
		eu.click(loginLocator);
		Thread.sleep(2000);
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		eu.click(contctLocator);
		//eu.click(checkBoxLocator);
		String  contactName = "deepti Gupta";
		checkBox = eu.selectContact(contactName);
		checkBox.click();
		getCompoanyName("Amar3 Singh3" , eu);
		getPhone("Amar3 Singh3" , eu);
		//a[text()='Amar3 Singh3' ]/parent::td//../td;
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[5]
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[4]
		//*[@id="vContactsForm"]/table/tbody/tr[6]/td[3]
	}
	public static void getCompoanyName(String companyName, ElimentUtil eu) {
		String path ="//a[text()='"+companyName+"']/parent::td/following-sibling::td/a[@context='company']";
		String text = eu.getElement("xpath", path).getText();
		System.out.println(text);
	}
	public static void getPhone(String companyName, ElimentUtil eu) {
		String path ="//a[text()='"+companyName+"']/parent::td/following-sibling::td[2]/span[@context='phone']";
		String text = eu.getElement("xpath", path).getText();
		System.out.println(text);
	}
}
