import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import NSelenium.NSelenium.ElimentUtil;

public class AjaxSearch {
 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		BrowserUtil br = new BrowserUtil();
		
		driver = br.launchBrowser("chrome");
		br.enterUrl("http://automationpractice.com/index.php");
		String s = br.getPageTitle();
		System.out.println(s);
		By locator2 = By.xpath("//div[@class='ac_results']/ul/li");
		By locator1 = By.xpath("//*[@id='search_query_top']");
		ElimentUtil eu = new ElimentUtil(driver);
		
		eu.search(locator1,locator2, "dress");
		
		//driver.findElement(search).click();
	}
	
	
	
}
