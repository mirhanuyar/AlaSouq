package web.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPassword {
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
            clickForgotPassword();
            Thread.sleep(2000);
         /*   clickE_posta();
            Thread.sleep(2000);*/
            wrongE_mail();
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/tr/");
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebElement save = driver.findElement(By.id("btn-default-app-settings"));
        save.click();
    }

    public static void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);
    }
    public static void clickForgotPassword() throws InterruptedException {
        WebElement forgotPassword = driver.findElement(By.id("link-forgot-password"));
        forgotPassword.click();
        Thread.sleep(1000);
    }
  /*  public static void clickE_posta() throws InterruptedException {
        WebElement inputBox = driver.findElement(By.id("email"));
        inputBox.click();
        inputBox.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(500);
        driver.findElement(By.id("btn-send-email")).click();
        Thread.sleep(5000);
    }*/
    public static void wrongE_mail() throws InterruptedException {
        WebElement inputBox = driver.findElement(By.id("email"));
        inputBox.click();
        inputBox.sendKeys("tajdin@solidsoft.com.tr");
        Thread.sleep(500);
        driver.findElement(By.id("btn-send-email")).click();


    }



}
