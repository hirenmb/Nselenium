import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import NSelenium.NSelenium.ElimentUtil;

public class StaticWebTable {
	public static WebDriver driver;

	public static void main(String[] args) {
		BrowserUtil br = new BrowserUtil();
		driver = br.launchBrowser("chrome");
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		ElimentUtil eu = new ElimentUtil(driver);
		By rowLocator = By.xpath("//*[@id='customers']//tr");
		By colLocator = By.xpath("//*[@id='customers']//tr/th");
		String before = "//*[@id='customers']//tr[";	
		String after = "]/td";
		eu.printTable(rowLocator , colLocator , before , after);
	
		
	}
}
