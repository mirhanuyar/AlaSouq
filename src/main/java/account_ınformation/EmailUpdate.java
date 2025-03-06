package account_ınformation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailUpdate {
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
            userInformation();
            Thread.sleep(2000);
            updateEmail();
            Thread.sleep(2000);
            newEmail();
            Thread.sleep(2000);
            enterAccountPassword();
            Thread.sleep(2000);
            clickChangeEmail();
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
        currentPasswordField.sendKeys("admin6565");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void userInformation() throws InterruptedException {
        clickElement(By.id("link-account-info"));
    }

    public static void updateEmail() throws InterruptedException {
        clickElement(By.id("link-reset-email"));
    }

    public static void newEmail() throws InterruptedException {
        WebElement newEmail = driver.findElement(By.xpath("//ion-input[@formcontrolname='newEmail']//input"));
        newEmail.sendKeys("yako.backoffice+testt@solidsoft.com.tr");
    }

    public static void enterAccountPassword() throws InterruptedException {
        WebElement password = driver.findElement(By.xpath("//ion-input[@formcontrolname='password']//input"));
        password.sendKeys("admin6565");
    }

    public static void clickChangeEmail() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement changeEmailButton = driver.findElement(By.xpath("//ion-button[@id='change-email-init']"));
        js.executeScript("arguments[0].click();", changeEmailButton);
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}