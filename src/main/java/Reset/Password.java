package Reset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class Password {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
            hesapBilgilerim();
            Thread.sleep(1000);
            resetPassword();
            Thread.sleep(1000);
            fillForm2();
            Thread.sleep(1000);
            resetPasswordButton();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void setUpDriver(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void openRegistrationPage(){
        driver.get("https://alasouq.com/my-account");
    }



    public static void fillForm() throws InterruptedException {

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Giriş Yap']")));
        loginButton.click();
        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("mirhan225@gmail.com");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("uyar6565");
        Thread.sleep(3000);
    }
   public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void hesapBilgilerim() throws InterruptedException {
        WebElement accountInfoButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Hesap Bilgilerim']")));
        accountInfoButton.click();
        Thread.sleep(2000);
    }

    public static void resetPassword() throws InterruptedException {
        WebElement resetPasswordButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Şifre Değişikliği']")));
        resetPasswordButton.click();
        Thread.sleep(2000);
    }

    public static void fillForm2() throws InterruptedException {
        WebElement oldPasswordButton = driver.findElement(By.id("ion-input-2"));
        oldPasswordButton.sendKeys("uyar6565");

        WebElement newPasswordButton = driver.findElement(By.id("ion-input-3"));
        newPasswordButton.sendKeys("mirhan6565");

        WebElement confirmPasswordButton = driver.findElement(By.id("ion-input-4"));
        confirmPasswordButton.sendKeys("mirhan6565");
    }

    public static void resetPasswordButton() throws InterruptedException {
        WebElement resetPasswordButton = driver.findElement(By.id("btn-password-update"));
        resetPasswordButton.click();
        Thread.sleep(2000);
    }
}
