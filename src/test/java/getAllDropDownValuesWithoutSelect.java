import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NSelenium.NSelenium.ElimentUtil;

public class getAllDropDownValuesWithoutSelect {

	public static WebDriver driver;

	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.enterUrl("https://www.orangehrm.com/contact-sales/");
		ElimentUtil eu  = new ElimentUtil(driver);
		String s = br.getPageTitle();
		System.out.println(s);
		By locatorType = By.xpath("//select[@name='Country']/option");
		List<WebElement> options = eu.getElements(locatorType);
		eu.elementsPrint(options);
		
	}

}
