
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetCarouselItems_Day2 {

    static WebDriver driver;
    static final String NEXT_BUTTON = "//div[contains(@class, 'swiper-button-next custom-navigation swiper-nav')]";

    public static void main(String[] args) throws InterruptedException {

        String sec_RecommendedForYou = "//h3[text()='Recommended For You']";
        String sec_TopPicks = "//h3[text()='Top picks in electronics']";
        //*** Hardcoded the New arrivals section xpath ***//
        String sec_NewArrivals = "//div[7]//h3[text()='New arrivals']";
        String sec_SaveBigOnMobile = "//h3[contains(text(),'Save big on mobiles')]";

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.noon.com/uae-en/");
        driver.manage().window().maximize();

        System.out.println("Section : Recommended For You");
        getAllProductNames(sec_RecommendedForYou).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Section : Top picks in electronics");
        getAllProductNames(sec_TopPicks).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Section : New arrivals");
        getAllProductNames(sec_NewArrivals).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        System.out.println("Section : Save big on mobiles & tablets");
        getAllProductNames(sec_SaveBigOnMobile).forEach(System.out::println);
        System.out.println("-----------------------------------------------------------------");

        driver.quit();
    }


    public static void selectSection(String sectionName) throws InterruptedException {

        Actions action = new Actions(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        do {
            try {
                WebElement ele_Section = driver.findElement(By.xpath(sectionName));
                executor.executeScript("arguments[0].scrollIntoView(true);", ele_Section);
                break;
            } catch (NoSuchElementException e) {
                action.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(1000);
            }
        }
        while (true);
    }

    public static List<String> getProductNames(String sectionName) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        List<String> itemsToAdd = new ArrayList<>();

        do {
            List<WebElement> allItems = driver.findElements(By.xpath(sectionName + "/../../..//div[@data-qa='product-name']/div"));
            allItems.stream().filter(WebElement::isDisplayed).forEach(element -> itemsToAdd.add(element.getText()));
            if (driver.findElement(By.xpath(sectionName + "/../../.." + NEXT_BUTTON)).getAttribute("class").contains("disabled")) {
                break;
            }
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(sectionName + "/../../.." + NEXT_BUTTON)));
            Thread.sleep(1000);
        }
        while (true);
        System.out.println("Total items : " + itemsToAdd.stream().distinct().count());
        return itemsToAdd.stream().distinct().sorted().collect(Collectors.toList());
    }

    public static List<String> getAllProductNames(String sectionName) throws InterruptedException {

        selectSection(sectionName);
        return getProductNames(sectionName);
    }

}
