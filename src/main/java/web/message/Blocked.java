package web.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Blocked {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            clickUserIcon2();
            Thread.sleep(2000);
            clickMessagesMenu();
            Thread.sleep(2000);
            clickMessage();
            Thread.sleep(2000);
            clickBlockButton();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("http://localhost:4300");
    }

    public static void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.mobile-cart i.ri-user-line")));
        userIcon.click();
        Thread.sleep(1000);
    }


    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void signIn() throws InterruptedException {
        WebElement clickSignIn;
        clickSignIn = driver.findElement(By.cssSelector("button.custom-login-button"));
        clickSignIn.click();
        Thread.sleep(1000);
    }

    public static void clickUserIcon2() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.mobile-cart i.ri-user-line")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public static void clickMessagesMenu() throws InterruptedException {
        driver.findElement(By.linkText("Messages")).click();
    }

    public static void clickMessage() throws InterruptedException {
        List<WebElement> messages = driver.findElements(By.cssSelector("section.message-list .message"));

        WebElement firstMessage = messages.get(0);
        firstMessage.click();
    }

    public static void clickBlockButton() throws InterruptedException {
        WebElement blockButton = driver.findElement(By.cssSelector("button.block-button"));
        blockButton.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
