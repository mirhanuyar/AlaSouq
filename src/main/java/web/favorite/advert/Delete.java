package web.favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Delete {
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
            clickMyFavorite();
            Thread.sleep(2000);
            clickFavoriteAdvert();
            Thread.sleep(2000);
            dropDown();
            Thread.sleep(2000);
            deleteFavoriteAdvert();
            Thread.sleep(2000);
            backPage();
            Thread.sleep(2000);
            deleteListAction();
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
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebElement save = driver.findElement(By.id("btn-save-app-settings"));
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

    public static void clickMyFavorite() throws InterruptedException {
        driver.findElement(By.cssSelector(".ri-heart-line")).click();
    }

    public static void clickFavoriteAdvert() throws InterruptedException {
        WebElement clickAdvert = wait.until(ExpectedConditions.elementToBeClickable(By.id("favorite-list-content-0")));
        clickAdvert.click();
    }

    public static void dropDown() throws InterruptedException {
        WebElement dropdownToggle = driver.findElement(By.id("favorite-product-actions-button-0"));
        dropdownToggle.click();
        Thread.sleep(500);
    }

    public static void deleteFavoriteAdvert() throws InterruptedException {
        driver.findElement(By.id("favorite-product-remove-12")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("confirm_yes_btn")).click();
    }


    public static void backPage() throws InterruptedException {
        driver.navigate().back();
    }

    public static void deleteListAction() throws InterruptedException {
        driver.findElement(By.id("favorite-list-delete-0")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("confirm_yes_btn")).click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
