import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import NSelenium.NSelenium.ElimentUtil;

public class SelectDropDown {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

BrowserUtil br = new BrowserUtil();

		
		driver = br.launchBrowser("chrome");
		br.enterUrl("https://www.facebook.com/");
		ElimentUtil eu  = new ElimentUtil(driver);

		String s = br.getPageTitle();
		System.out.println(s);
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Create new account")).click();
		Thread.sleep(2000);
		By month = By.xpath("//*[@id=\"month\"]");
		String mValue = "Dec";
		eu.select(month, mValue );	
		By day = By.xpath("//*[@id=\"day\"]");
		String dValue = "23";
		eu.select(day, dValue);
		By year = By.xpath("//*[@id=\"year\"]");
		String yValue = "2020";
		eu.select(year, yValue);
	//	List<WebElement> Options = eu.selectgetOptions(country);
	}

}
