package mobile.favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddList {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);

            clickSaveAppSettings();
            Thread.sleep(2000);

            fullScreen();
            Thread.sleep(2000);

            clickTabButtonMyAccount();
            Thread.sleep(2000);

            clickLoginButton();
            Thread.sleep(2000);

            fillForm();
            Thread.sleep(2000);

            submitForm();
            Thread.sleep(2000);

            clickSearch();
            Thread.sleep(2000);

            clickCategories();
            Thread.sleep(2000);

            clickAllAds();
            Thread.sleep(2000);

            clickAdvert();
            Thread.sleep(2000);

            clickFavorite();
            Thread.sleep(2000);

            scrollToElement(By.cssSelector("#add-new-list"));

            createNewFavoriteList();
            Thread.sleep(2000);

            newFavoriteListName();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 500);
        deviceMetrics.put("height", 800);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) " +
                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15A372 Safari/604.1");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://m.alasouq.com");
    }

    public static void clickSaveAppSettings() {
        clickElement(By.xpath("//ion-button[text()='Default']"));
    }

    public static void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public static void clickTabButtonMyAccount() {
        clickElement(By.id("btn-my-account"));
    }

    public static void clickLoginButton() {
        clickElement(By.id("login-click"));
    }

    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(1000);

        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(1000);
    }

    public static void submitForm() {
        clickElement(By.id("btn-lgn-email"));
    }

    public static void clickSearch() throws InterruptedException {
        WebElement search = driver.findElement(By.id("btn-search"));
        search.click();
    }

    public static void clickCategories() throws InterruptedException {
        WebElement realEstateElement = driver.findElement(By.xpath("//ion-col[@id='category-selected']//h3[text()='Real Estate']"));
        realEstateElement.click();
    }

    public static void clickAllAds() throws InterruptedException {
        WebElement allAds = driver.findElement(By.id("btn-list-all-ads"));
        allAds.click();
    }

    public static void clickAdvert() throws InterruptedException {
        WebElement advert = driver.findElement(By.xpath("//h3[text()='Arsa']"));
        advert.click();

    }

    public static void clickFavorite() throws InterruptedException {
        WebElement favorite = driver.findElement(By.id("open-favorite-modal"));
        favorite.click();
    }

    public static void createNewFavoriteList() throws InterruptedException {
        WebElement newFavoriteList = driver.findElement(By.cssSelector("#add-new-list"));
        newFavoriteList.click();
    }

    public static void newFavoriteListName() throws InterruptedException {
        WebElement newName = driver.findElement(By.id("new-favorite-list-name"));
        newName.click();
        Thread.sleep(500);
        newName.sendKeys("TEST");
    }

    public static void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
    }
}
