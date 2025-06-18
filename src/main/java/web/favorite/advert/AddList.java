package web.favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.*;
import java.time.Duration;


public class AddList {
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
            backPage();
            Thread.sleep(2000);
            clickAdvert();
            Thread.sleep(2000);
            addFavoriteList();
            Thread.sleep(2000);
            createNewFavoriteList();
            Thread.sleep(2000);
          //  selectFavoriteList();
            Thread.sleep(2000);
            saveFavoriteList();
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
        emailField.sendKeys("onder.backoffice@solidsoft.com.tr");
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

    public static void backPage() throws InterruptedException {
        driver.navigate().back();
    }

    public static void clickAdvert() throws InterruptedException {
        List<WebElement> advert = driver.findElements(By.cssSelector("a.product-title"));

        if (!advert.isEmpty()) {
            WebElement firstAd = advert.get(0);

            Thread.sleep(1000);

            firstAd.click();
        } else {
            System.out.println("İlan bulunamadı.");
        }

        Thread.sleep(2000);
    }


    public static void addFavoriteList() throws InterruptedException {
        WebElement addFavoriebutoon = driver.findElement(By.id("btn-toggle-favorite-10"));

        addFavoriebutoon.click();
        Thread.sleep(2000);
    }

    public static void createNewFavoriteList() throws InterruptedException {
        WebElement addNewList = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("listName")));
        addNewList .click();
        addNewList .sendKeys("TEST");
    }

    public static void saveFavoriteList() throws InterruptedException {
        WebElement savebutton = driver.findElement(By.id("add-favorite_save_btn"));
        savebutton.click();
        Thread.sleep(2000);
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
