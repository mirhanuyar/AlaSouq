package web.message;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ChatWithAdvertOwner {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickSaveAppSettings();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            backPage();
            Thread.sleep(2000);
            clickAdvertDetails();
            Thread.sleep(2000);
            clickMessageButton();
            Thread.sleep(2000);
            clickMessageInput();
            Thread.sleep(2000);
            clickSendButton();
            Thread.sleep(2000);
            scrollToElement(By.id("btn-send-message"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/tr/");
        driver.manage().window().maximize();
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-default-app-settings")));
        save.click();
    }

    public static void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);

    }

    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("tajdin.gurdal@solidsoft.com.tr");
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

    public static void backPage() {
        driver.navigate().back();
    }

    public static void clickAdvertDetails() throws InterruptedException {
        WebElement details = driver.findElement(By.id("quick-view-link"));
        details.click();
    }

    public static void clickMessageButton() throws InterruptedException {
        WebElement advert = driver.findElement(By.id("message10"));
        advert.click();
    }


    public static void clickMessageInput() throws InterruptedException {
        WebElement messageInput = driver.findElement(By.id("enter-message-textarea"));
        messageInput.click();
        messageInput.sendKeys("selamın aleyküm");
    }

    public static void clickSendButton() throws InterruptedException {
        WebElement sendButton = driver.findElement(By.id("btn-send-message"));
        sendButton.click();
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
