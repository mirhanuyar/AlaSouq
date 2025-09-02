package mobile.favorite.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Create {
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

            clickButtonHome();
            Thread.sleep(2000);

            clickSearchInput();
            Thread.sleep(2000);

            clickRealEstate();
            Thread.sleep(2000);

            clickSaveSearch();
            Thread.sleep(3000);

            clickSearchNameInput();
            Thread.sleep(2000);



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

    public static void clickSaveAppSettings() throws InterruptedException {
        clickElement(By.xpath("//ion-button[text()='Default']"));
    }

    public static void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public static void clickTabButtonMyAccount() throws InterruptedException {
        clickElement(By.id("btn-my-account"));
    }

    public static void clickLoginButton() throws InterruptedException {
        clickElement(By.id("login-click"));
    }

    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void clickButtonHome() throws InterruptedException {
        clickElement(By.id("btn-search"));
    }

    public static void clickSearchInput() throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector("ion-searchbar input.searchbar-input"));

        input.clear();

        input.sendKeys("REAL ESTATE");
    }

    public static void clickRealEstate() throws InterruptedException {
        WebElement realEstate = driver.findElement(By.xpath("//ion-item[.//h3[text()='Real Estate']]"));
        realEstate.click();
    }

    public static void clickSaveSearch() throws InterruptedException {
        WebElement search = driver.findElement(By.id("save-search-modal"));
        search.click();
    }

    public static void clickSearchNameInput() throws InterruptedException {
        WebElement search = driver.findElement(By.id("favorite-search-name"));
        search.click();
        Thread.sleep(5000);
        search.sendKeys("TEST");
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
