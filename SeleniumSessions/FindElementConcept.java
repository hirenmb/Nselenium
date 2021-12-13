

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import NSelenium.NSelenium.ElimentUtil;



public class FindElementConcept extends BrowserUtil{
 static WebDriver driver;
	public int size;
	public static String attributeSrc;
	public static String attributeAlt;
	

	public static void main(String[] args) throws InterruptedException {
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		br.enterUrl("https://www.amazon.ca/");
		
		ElimentUtil rp = new ElimentUtil(driver);
		By links = By.tagName("a");
		rp.getElementsCount(links);
		List<WebElement> linkList = rp.getElements(links);
		rp.elementsPrint(linkList);

		By imageAlt = By.tagName("img");
		attributeSrc = "src";
		attributeAlt = "alt";
		rp.printlistAltElements(imageAlt, attributeSrc);
		rp.printlistAltElements(imageAlt, attributeAlt);
	}


}
