package web.favorite.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Control {

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
            clickFavorite();
            Thread.sleep(2000);
            favoritesearch();
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
        emailField.sendKeys("onder.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
        driver.findElement(By.id("btn-sign-in")).click();
    }

    public static void clickFavorite() throws InterruptedException {
        WebElement favorite = driver.findElement(By.id("link-my-favorites"));
        favorite.click();

    }
     public static void favoritesearch() throws InterruptedException {
         WebElement favoritesLink = driver.findElement(By.cssSelector("a[href$='/my-account/favorites/searches']"));
         favoritesLink.click();
         Thread.sleep(3000);
         driver.findElement(By.cssSelector(".favorite-search-name")).click();

     }



}
