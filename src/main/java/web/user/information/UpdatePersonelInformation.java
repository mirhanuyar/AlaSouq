package web.user.information;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UpdatePersonelInformation {
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
            clickUserIcon2();
            Thread.sleep(2000);
            scrollToElement(By.id("edit-email"));
            Thread.sleep(2000);
            clickEditProfile();
            Thread.sleep(2000);
            clickFirstNameInput();
            Thread.sleep(2000);
            clickLastNameInput();
            Thread.sleep(2000);
            clickDisplayNameInput();
           Thread.sleep(2000);
            clickSaveButton();
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
        driver.manage().window().fullscreen();
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
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickEditProfile() throws InterruptedException {
        WebElement edit = driver.findElement(By.id("edit-profile"));
        edit.click();
    }

    public static void clickFirstNameInput() throws InterruptedException {
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.click();
        Thread.sleep(500);
        firstName.clear();
        firstName.sendKeys("Yakup Adm. TEST");
    }

    public static void clickLastNameInput() throws InterruptedException {
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.click();
        Thread.sleep(500);
        lastName.clear();
        lastName.sendKeys("Şahin TEST");
    }

    public static void clickDisplayNameInput() throws InterruptedException {
        WebElement displayName = driver.findElement(By.id("displayName"));
        displayName.click();
        Thread.sleep(500);
        displayName.clear();
        displayName.sendKeys("Yakup Adm. Ş TEST");
    }

    public static void clickSaveButton() throws InterruptedException {
        WebElement save = driver.findElement(By.id("submit_profile_btn"));
        save.click();
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}