package NSelenium.NSelenium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElimentUtil<size> {
	WebDriver driver;
	int size;

	public ElimentUtil(WebDriver driver) {
		this.driver = driver;
	}

	
	
	
	public WebElement getElement(String locType, String fName) {

		return driver.findElement(getBy(locType, fName));
	}

	private By getBy(String locType, String Name) {
		By locator = null;
		switch (locType.toLowerCase()) {
		case "id":
			locator = By.id(Name);

			break;
		case "xpath":
			// System.out.println("Xpath Executed");
			locator = By.xpath(Name);
		default:
			// System.out.println("Please pass correct locator type :");
			break;
		}

		return locator;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);

	}

	public void doSendKeys(String locType, String fName, String fValue) {

		getElement(locType, fName).sendKeys(fValue);
	}

	public void doSendKeys(By username, int timeOut, String sValue) {
		WebElement userName_ele = doPreseneceOfElementLocated(username, timeOut);
		userName_ele.sendKeys(sValue);

	}

	public WebElement getElement(By locator) {

		return driver.findElement(locator);
	}

	public void getElementsCount(By links) {
		System.out.println(getElements(links).size());

	}

	public List<WebElement> getElements(By locator) {
		List<WebElement> listElements = driver.findElements(locator);
		System.out.println(listElements.size());
		return listElements;
	}

	public void elementsPrint(List<WebElement> linkList) {
		for (WebElement e : linkList) {
			if (!e.getText().isEmpty()) {
				System.out.println("Printing Element Text ::" + e.getText());
			} else
				System.out.println("Lis is Empty");
		}

	}

	public void printlistAltElements(By imageAlt, String attribute) {
		List<WebElement> listElements = getElements(imageAlt);
		System.out.println(listElements.size());
		for (WebElement e : listElements) {
			System.out.println("Printing image attribute " + e.getAttribute(attribute));
		}
	}

	public void search(By search, By locator, String string) throws InterruptedException {

		doSendKeys(search, string);
		Thread.sleep(5000);

		List<WebElement> searchList = getElements(locator);
		int s = searchList.size();
		for (WebElement e : searchList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Casual Dresses > Printed Dress")) {
				e.click();
				break;
			}

		}

	}

	public void click(By locator) {
		getElement(locator).click();
	}

	public void click(By locator, int timeOut) {

		doPreseneceOfElementLocated(locator, timeOut).click();

	}

	public void select(By locator, String value) {
		WebElement dropDown = getElement(locator);
		Select select = new Select(dropDown);
		select.selectByVisibleText(value);

	}

	public List<WebElement> selectgetOptions(By country) {
		WebElement ops = getElement(country);
		Select select = new Select(ops);
		List<WebElement> options = select.getOptions();
		return options;
	}

	public WebElement selectContact(String contactName) {
		String path = "//a[text()='" + contactName + "']/parent::td//preceding-sibling::td/input";
		return getElement("xpath", path);

	}

	public void printTable(By rowLocator, By colLocator, String before, String after) {

		List<WebElement> rows = getElements(rowLocator);
		List<WebElement> cols = getElements(colLocator);
		for (int row = 2; row <= rows.size(); row++) {
			String path = before + row + after;
			// System.out.println(path);
			for (int col = 1; col <= cols.size(); col++) {
				By colLocator2 = By.xpath(path + "[" + col + "]");
				WebElement dataList = getElement(colLocator2);
				System.out.println(dataList.getText());
			}
			System.out.println();
		}

	}

//******************Wait Class**************************
	public WebElement doPreseneceOfElementLocated(By username, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement userName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(username));
		return userName_ele;
	}



	public WebElement doPreseneceOfElementLocated(By username, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		WebElement userName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(username));
		return userName_ele;
		
	}

	public WebElement waitElementTobeVisbile(By locator, int timeOut, long intervalTime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
		
	}


	public List<WebElement> waitElementsTobeVisbile(By locator, int timeOut, long intervalTime) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		List<WebElement> webElementsList =  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return webElementsList;
		
	}




	public boolean waitForURLToBe(String cntct, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return	wait.until(ExpectedConditions.urlContains(cntct));
	
	}




	public void waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
	}




	public void waitforFrame(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		driver = 	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		System.out.println(driver.getTitle());
	}




	public WebElement fluentWait(By locaotr, int timeOut, long interval) {
		WebElement  web_ele;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) 
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(interval))
					.ignoring(NoSuchElementException.class)
					.withMessage("Element not Found");

		return web_ele = wait.until(ExpectedConditions.presenceOfElementLocated(locaotr));
		
		
	}

	public WebElement waitForElementPresntUsingFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("ELEMENT_NOT_FOUND_ERROR_MESSG");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	
}
