package mobile.favorite.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RenameSearch {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {

        try {
            setUpDriver();
            Thread.sleep(2000);
            saveModal();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            favoriteAdvert();
            Thread.sleep(2000);
            clickEditFavoriteSearch();
            Thread.sleep(2000);
            renameFavoriteSearch();
            Thread.sleep(2000);
            saveChanges();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://m.alasouq.com/en/home");

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public static void saveModal() throws InterruptedException {
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.cssSelector("ion-button.button-outline"));
        button.click();
        Thread.sleep(2000);

    }


    public static void fillForm() throws InterruptedException {
        WebElement userIcon = driver.findElement(By.id("icon-person-outline"));
        userIcon.click();
        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(
                By.id("login-click"));

        loginButton.click();
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(
                By.cssSelector("input[type='email'].native-input")
        );

        emailField.sendKeys("onder.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);

        WebElement currentPasswordField = driver.findElement(By.cssSelector("input[type='password']"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        WebElement submitIcon = driver.findElement(By.id("btn-lgn-email"));
        submitIcon.click();
        Thread.sleep(2000);
    }

    public static void favoriteAdvert() throws InterruptedException {
        clickElement(By.id("link-favorite-search"));
    }

    public static void clickEditFavoriteSearch() throws InterruptedException {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("change-list-name")));
        editButton.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void renameFavoriteSearch() throws InterruptedException {
        WebElement newNameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("search-list-name")));
        newNameField.clear();
        newNameField.sendKeys("testtt");
    }

    public static void saveChanges() throws InterruptedException {
        clickElement(By.id("btn-save-search"));
    }
}