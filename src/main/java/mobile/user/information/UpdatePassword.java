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
import java.util.List;
import java.util.Map;

public class UpdatePassword {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args)throws InterruptedException {
        setUpDriver();
        try {
            saveModal();
            Thread.sleep(2000);

            fillForm();
            Thread.sleep(2000);

            submitForm();
            Thread.sleep(2000);

            clickAccountInfo();
            Thread.sleep(2000);

            clickPasswordChangeButton();
            Thread.sleep(2000);

            currentPasswordInput();
            Thread.sleep(2000);

            newPasswordInput();
            Thread.sleep(2000);

            confirmPasswordInput();
            Thread.sleep(2000);

            clickUpdateButton();


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

        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);

        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        WebElement submitIcon = driver.findElement(By.id("btn-lgn-email"));
        submitIcon.click();
        Thread.sleep(2000);
    }

    public static void clickAccountInfo() throws InterruptedException {
        WebElement element = driver.findElement(By.id("link-dashboard"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public static void clickPasswordChangeButton() throws InterruptedException {
        WebElement buttons = driver.findElement(By.id("link-change-password"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttons);
        Thread.sleep(1000);
    }

    public static void currentPasswordInput() throws InterruptedException {
        WebElement current = driver.findElement(By.id("ion-input-2"));
        current.click();
        current.sendKeys("admin");
    }

    public static void newPasswordInput() throws InterruptedException {
        WebElement newPassword = driver.findElement(By.id("ion-input-3"));
        newPassword.click();
        newPassword.sendKeys("admin6565");
    }

    public static void confirmPasswordInput() throws InterruptedException {
        WebElement confirm = driver.findElement(By.id("ion-input-4"));
        confirm.click();
        confirm.sendKeys("admin6565");
    }

    public static void clickUpdateButton() throws InterruptedException {
        WebElement update = driver.findElement(By.id("btn-password-update"));
        update.click();
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
