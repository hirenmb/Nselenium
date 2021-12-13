
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NSelenium.NSelenium.ElimentUtil;

public class CricketScore {

	private static  WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		driver.get("https://www.espncricinfo.com/series/icc-men-s-t20-world-cup-2021-22-1267897/australia-vs-pakistan-2nd-semi-final-1273755/full-scorecard");
		ElimentUtil<WebDriver> eu = new ElimentUtil<WebDriver>(driver);
		String name = "Shoaib Malik";
		By playerName = By.xpath("//table[@class='table batsman']//tbody//a[text()='"+name+"']");
		System.out.println(eu.getElement(playerName).getText());
		By wicket = By.xpath("//table[@class='table batsman']//tbody//a[text()='"+name+"']//..//following-sibling::td/span");
		Thread.sleep(2000);
	//By wicket = By.xpath("//span[@class='cursor-pointer']/ancestor::tr//a[text()='Mohammad Rizwan']//../..//td[2]/span");
		List<WebElement> w = eu.getElements(wicket);
		eu.elementsPrint(w);
	//	driver.close();
	}

}
