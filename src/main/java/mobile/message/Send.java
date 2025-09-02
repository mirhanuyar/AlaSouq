package mobile.message;

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

public class Send {
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

            clickMessages();
            Thread.sleep(2000);

            clickMessage();
            Thread.sleep(2000);

            sendMessage();

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

    public static void clickMessages() throws InterruptedException {
        WebElement messages = driver.findElement(By.id("link-messages"));
        messages.click();
    }

    public static void clickMessage() throws InterruptedException {
        WebElement messages = driver.findElement(By.id("click-message-detail"));
        messages.click();
    }

    public static void sendMessage() {
        try {

            for (int i = 0; i < 10; i++) {
                WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ion-textarea-0")));
                message.sendKeys("TEST" + i);

                WebElement sendMessageButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("btn-send-message")));
                sendMessageButton.click();

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.getMessage();
        }
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
