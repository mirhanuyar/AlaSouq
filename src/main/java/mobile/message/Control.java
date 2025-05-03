package mobile.message;

import io.appium.java_client.PerformsTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class Control {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            viewMessages();
            Thread.sleep(2000);
            swipeLeftOnMessage();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("http://localhost:4200/home");
    }

    public static void fillForm() throws InterruptedException {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Giriş Yap']")));
        loginButton.click();
        Thread.sleep(1000);

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


    public static void viewMessages() throws InterruptedException {
        clickElement(By.id("link-messages"));
    }


    public static void swipeLeftOnMessage() {
        try {
            WebElement messageItem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("click-message-detail")));

            int startX = messageItem.getLocation().getX() + messageItem.getSize().getWidth() - 10;
            int endX = messageItem.getLocation().getX() + 10;
            int startY = messageItem.getLocation().getY() + (messageItem.getSize().getHeight() / 2);

            TouchAction action = new TouchAction((PerformsTouchActions) driver);
            action.press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(endX, startY))
                    .release()
                    .perform();

            Thread.sleep(1000);

            WebElement unreadButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ion-item-option[.//span[text()='Okunmadı İşaretle']]")));
            unreadButton.click();
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}