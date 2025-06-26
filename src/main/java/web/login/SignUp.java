package web.login;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignUp {
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
            clickSignButoon();
            Thread.sleep(2000);
            SignUpAndEnterEmail();
            Thread.sleep(2000);
            registermail();
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

    public static void clickSignButoon() throws InterruptedException {
        WebElement SignIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("link-sign-up")));
        SignIcon.click();
        Thread.sleep(1000);
    }

    public static void SignUpAndEnterEmail() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input.form-control[formcontrolname='email']:not([id='newsletter-email'])")));
        System.out.println("E-posta alanı bulundu (kayıt formu)!");

        try {
            emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input.form-control[formcontrolname='email']:not([id='newsletter-email'])")));
            js.executeScript("arguments[0].scrollIntoView(true);", emailInput);
            emailInput.click();
        } catch (Exception e) {
            System.out.println("E-posta alanı görünür değil: " + e.getMessage());
            WebElement authBox = driver.findElement(By.cssSelector("div.auth-box"));
            js.executeScript("arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.zIndex='9999';", authBox);
            emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("input.form-control[formcontrolname='email']:not([id='newsletter-email'])")));
            js.executeScript("arguments[0].scrollIntoView(true);", emailInput);
            emailInput.click();
        }

        js.executeScript("arguments[0].value='yakup.backoffice@solidsoft.com.tr';", emailInput);
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", emailInput);
        String outerHTML = (String) js.executeScript("return arguments[0].outerHTML;", emailInput);
        System.out.println("E-posta alanı HTML: " + outerHTML);
        System.out.println("E-posta alanı başarıyla dolduruldu.");
    }
    public static void registermail() throws InterruptedException {
        WebElement checkEmailButton = driver.findElement(By.cssSelector(".check-email-btn"));
        checkEmailButton.click();

    }
}