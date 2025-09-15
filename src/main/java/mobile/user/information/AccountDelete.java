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

public class AccountDelete {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void initWait() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void main(String[] args) throws InterruptedException {

        initWait();

        setUpDriver();

        try {

            Thread.sleep(2000);
            saveModal();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            userInformation();
            Thread.sleep(2000);
            accountDeleted();
            Thread.sleep(2000);
            deletedButton();
            Thread.sleep(2000);
            checkbox();
            Thread.sleep(2000);
            buttonCancel();
            Thread.sleep(2000);
            /*buttonDelete();*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://m.alasouq.com/en/home");
    }

    public static void saveModal () throws InterruptedException {
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.cssSelector("ion-button.button-outline"));
        button.click();
        Thread.sleep(2000);

    }
    public static void fillForm() throws InterruptedException {
        WebElement userIcon = driver.findElement(By.id("icon-person-outline"));
        userIcon.click();
        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(
                By.id("login-click"));

        loginButton.click();
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(
                By.cssSelector("input[type='email'].native-input")
        );
        emailField.sendKeys("yakup.user@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        driver.findElement(By.id("btn-lgn-email")).click();
        Thread.sleep(2000);
    }

    public static void userInformation() throws InterruptedException {
        driver.findElement(By.id("link-dashboard")).click();
        Thread.sleep(1000);
    }

    public static void accountDeleted() throws InterruptedException {
        driver.findElement(By.id("link-delete-account")).click();
        Thread.sleep(1000);
    }

    public static void deletedButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelector('ion-button.delete-button').shadowRoot.querySelector('button.button-native').click();"
        );
        Thread.sleep(1000);

    }

    public static void checkbox() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("document.querySelector('ion-checkbox').click();");
        Thread.sleep(1000);
    }

    public static void buttonCancel() throws InterruptedException{
        WebElement deleteButton = driver.findElement(By.id("btn-cancel-delete"));
        deleteButton.click();
    }
   /* public static void buttonDelete() throws InterruptedException{
        WebElement deleteButton = driver.findElement(By.id("btn-delete"));
        deleteButton.click();
    }*/

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}