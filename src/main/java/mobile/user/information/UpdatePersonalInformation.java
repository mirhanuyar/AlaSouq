package mobile.user.information;

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
import java.util.Map;

public class UpdatePersonalInformation {
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
            scrollToElement(By.id("link-account-info"));
            Thread.sleep(2000);

            clickAccountInfo();
            Thread.sleep(2000);

            clickPersonalInformation();
            Thread.sleep(2000);

            clickFirstName();
            Thread.sleep(2000);

            clickLastName();
            Thread.sleep(2000);

            clickDisplayName();
            Thread.sleep(2000);

            scrollToElement(By.id("btn-update"));
            Thread.sleep(2000);

            clickSaveButton();

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

    public static void clickAccountInfo() throws InterruptedException {
        WebElement accountInfo = driver.findElement(By.id("link-account-info"));
        accountInfo.click();
    }

    public static void clickPersonalInformation() throws InterruptedException {
        WebElement personalInformation = driver.findElement(By.id("link-profile"));
        personalInformation.click();
    }

    public static void clickFirstName() throws InterruptedException {
        WebElement firstNameField = driver.findElement(By.id("ion-input-2"));
        firstNameField.clear();
        firstNameField.sendKeys("yakup");
    }

    public static void clickLastName() throws InterruptedException {
        WebElement lastNameField = driver.findElement(By.id("ion-input-3"));
        lastNameField.clear();
        lastNameField.sendKeys("şahin");
    }

    public static void clickDisplayName()  throws InterruptedException {
        WebElement displayNameField = driver.findElement(By.id("ion-input-4"));
        displayNameField.clear();
        displayNameField.sendKeys("YAKUP");
    }

    public static void clickSaveButton() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.id("btn-update"));
        saveButton.click();
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
