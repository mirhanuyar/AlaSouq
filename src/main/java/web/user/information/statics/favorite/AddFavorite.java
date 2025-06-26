package web.user.information.statics.favorite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddFavorite {


    public static WebDriver driver;
    public static WebDriverWait wait;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        web.user.information.statics.message.SendMessage.driver = driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void setWait(WebDriverWait wait) {
        web.user.information.statics.message.SendMessage.wait = wait;
    }

    public AddFavorite() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void performViewAdvertFlow() throws InterruptedException {
        openRegistrationPage();
        Thread.sleep(2000);
        enterPage();
        Thread.sleep(2000);
        clickUserIcon();
        Thread.sleep(2000);
        fillForm();
        Thread.sleep(2000);
        signIn();
        Thread.sleep(2000);
        goHome();
        Thread.sleep(2000);
        scrollScreen(200);
        Thread.sleep(2000);
        clickAdvert();
        Thread.sleep(2000);
        scrollScreen(1300);
        Thread.sleep(2000);
        clickAddFavorite();
        Thread.sleep(2000);
        scrollScreen(-500);
        Thread.sleep(2000);
        clickUserIcon();
        Thread.sleep(2000);
        scrollScreen(300);
        Thread.sleep(2000);
        logOut();
    }

    public void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openRegistrationPage() {
        driver.get("https://alasouq.com/");
    }

    public void enterPage() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("btn-save-app-settings")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);
    }


    public void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("abdullah.sahin@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public void signIn() throws InterruptedException {
        WebElement clickSignIn = driver.findElement(By.id("btn-sign-in"));
        clickSignIn.click();
        Thread.sleep(1000);
    }

    public void goHome() throws InterruptedException {
        WebElement goHome = driver.findElement(By.id("home-link"));
        goHome.click();
        Thread.sleep(1000);
    }

    public void clickAdvert() throws InterruptedException {
        Thread.sleep(4000);
        WebElement advert = driver.findElement(By.cssSelector("a[id*='product-title-link-arsa-bence-bunu-kacirma-100011']"));
        advert.click();
        Thread.sleep(2000);
    }

    public static void scrollScreen(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public static void clickAddFavorite() throws InterruptedException {
        WebElement addFavorite = driver.findElement(By.cssSelector("a[id*='btn-toggle-favorite-seller-11']"));
        addFavorite.click();
        Thread.sleep(3500);
        driver.navigate().back();
    }

    public void logOut() throws InterruptedException {
        WebElement logOutButton = driver.findElement(By.id("link-logout"));
        logOutButton.click();
        Thread.sleep(2000);
        WebElement yesButton = driver.findElement(By.id("confirm_yes_btn"));
        yesButton.click();

    }

}
