package user_ınformation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class UpdateProfile {
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
            personalInformation();
            Thread.sleep(2000);
            updateFirstName();
            Thread.sleep(2000);
            updateLastName();
            Thread.sleep(2000);
            scrollByAmount(500);
            Thread.sleep(2000);
            scrollToElement(By.id("account-phone-number-0"));
            Thread.sleep(2000);
            updateAccountDisplayName();
            Thread.sleep(2000);
            updatePhoneNumber();
            Thread.sleep(2000);
            radioCheckBox();
            Thread.sleep(2000);
            saveButton();
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

    public static void userInformation() throws InterruptedException {
        clickElement(By.id("link-account-info"));
    }

    public static void personalInformation() throws InterruptedException {
        clickElement(By.id("link-profile"));
    }

    public static void updateFirstName() throws InterruptedException {
        WebElement inputField = driver.findElement(By.xpath("//ion-input[@formcontrolname='firstName']//input"));
        inputField.clear();
        inputField.sendKeys("Yakup Adm. TEST");
    }

    public static void updateLastName() throws InterruptedException {
        WebElement lastNameField = driver.findElement(By.xpath("//ion-input[@formcontrolname='lastName']//input"));
        lastNameField.clear();
        lastNameField.sendKeys("Şahin TEST");

    }

    public static void scrollByAmount(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ");");
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void updateAccountDisplayName() throws InterruptedException {
        WebElement lastNameField = driver.findElement(By.xpath("//ion-input[@formcontrolname='displayName']//input"));
        lastNameField.clear();
        lastNameField.sendKeys("Yakup Adm. Ş. TEST");
    }

    public static void updatePhoneNumber() throws InterruptedException {
        WebElement lastNameField = driver.findElement(By.xpath("//ion-input[@formcontrolname='phoneNumber']//input"));
        lastNameField.clear();
        lastNameField.sendKeys("+90(501) 337 00 70");
    }

    public static void radioCheckBox() throws InterruptedException {
        WebElement radioButton = driver.findElement(By.xpath("//ion-radio[contains(text(), 'Yakup Adm. TEST Şahin TEST')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);

    }

    public static void saveButton() throws InterruptedException {
        WebElement button = driver.findElement(By.id("btn-update"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}