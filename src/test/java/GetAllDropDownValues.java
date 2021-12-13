import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NSelenium.NSelenium.ElimentUtil;

public class GetAllDropDownValues {
	public static WebDriver driver;
	public static void main(String[] args) {
BrowserUtil br = new BrowserUtil();

		
		driver = br.launchBrowser("chrome");
		br.enterUrl("https://www.orangehrm.com/contact-sales/");
		ElimentUtil eu  = new ElimentUtil(driver);
		String s = br.getPageTitle();
		System.out.println(s);
		By country =By.id("Form_submitForm_Country");
		List<WebElement> Options = eu.selectgetOptions(country);
		for(WebElement e : Options) {
			System.out.println(e.getText());

			if(e.getText().equalsIgnoreCase("India")) {
				System.out.println(e.getText());
				e.click();
				break;
			}
		}
	}

}
