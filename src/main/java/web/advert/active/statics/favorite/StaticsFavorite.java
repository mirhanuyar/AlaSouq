package web.advert.active.statics.favorite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.advert.active.statics.message.SendMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StaticsFavorite {

    public static void main(String[] args) {
        try {
            AddFavorite addFavorite = new AddFavorite();
            addFavorite.openRegistrationPage();
            WebDriver driver = addFavorite.getDriver();
            WebDriverWait wait = addFavorite.getWait();
            Thread.sleep(3000);
            clickSaveAppSettings(driver);
            clickUserIcon(wait);
            Thread.sleep(2000);
            fillForm(driver);
            Thread.sleep(2000);
            signIn(driver);
            Thread.sleep(2000);
            clickMyAdverts(driver);
            Thread.sleep(2000);
            refreshPage(driver);
            Thread.sleep(2000);
            clickAction(driver);
            Thread.sleep(2000);
            clickStatics(driver);
            Thread.sleep(2000);
            scrollScreen(driver, 800);
            Thread.sleep(2000);
            int firstFavCount = getFavoritesCount(driver);
            Thread.sleep(2000);
            clickUserIcon(wait);
            Thread.sleep(2000);
            scrollScreen(driver, 450);
            Thread.sleep(2000);
            logOut(driver);
            addFavorite.performViewAdvertFlow();
            clickUserIcon(wait);
            Thread.sleep(2000);
            fillForm(driver);
            Thread.sleep(2000);
            signIn(driver);
            Thread.sleep(2000);
            clickMyAdverts(driver);
            Thread.sleep(2000);
            refreshPage(driver);
            Thread.sleep(2000);
            clickAction(driver);
            Thread.sleep(2000);
            clickStatics(driver);
            Thread.sleep(2000);
            scrollScreen(driver, 300);
            int secondFavCount = getFavoritesCount(driver);
            if(firstFavCount == secondFavCount - 1) {
                System.out.println("Test Başarılı");
            } else {
                System.out.println("Test başarısız.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void clickSaveAppSettings(WebDriver driver) throws InterruptedException {
        WebElement save = driver.findElement(By.id("btn-default-app-settings"));
        save.click();
    }

    public static void clickUserIcon(WebDriverWait wait) throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);
    }


    public static void fillForm(WebDriver driver) throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(2000);
    }

    public static void signIn(WebDriver driver) throws InterruptedException {
        WebElement clickSignIn = driver.findElement(By.id("btn-sign-in"));
        clickSignIn.click();
        Thread.sleep(5000);
    }

    public static void clickMyAdverts(WebDriver driver) throws InterruptedException {
        WebElement myAdverts = driver.findElement(By.id("link-adverts"));
        myAdverts.click();
        Thread.sleep(1000);
    }

    public static void clickAction(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn = driver.findElement(By.cssSelector("button[id^='dropdown-actions-toggle-']"));
        js.executeScript("arguments[0].click();", btn);
    }

    public static void clickStatics(WebDriver driver) throws InterruptedException {
        WebElement statics = driver.findElement(By.cssSelector("button[id*='btn-statistics']"));
        statics.click();
        Thread.sleep(2000);
    }

    public static int getFavoritesCount(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        WebElement h6Element = driver.findElement(By.xpath("//h6[contains(., 'Total Favorites')]"));
        String fullText = h6Element.getText(); // Örnek çıktı: "Total Favorites: 5"

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(fullText);

        int favoriteCount = 0;
        if (matcher.find()) {
            favoriteCount = Integer.parseInt(matcher.group(1));
        }
        System.out.println(favoriteCount);
        driver.navigate().back();
        Thread.sleep(2000);
        return favoriteCount;
    }

    public static void scrollScreen(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public static void logOut(WebDriver driver) throws InterruptedException {
        WebElement logOutButton = driver.findElement(By.id("link-logout"));
        logOutButton.click();
        Thread.sleep(3000);
        WebElement yesButton = driver.findElement(By.id("confirm_yes_btn"));
        yesButton.click();
        Thread.sleep(2000);
    }

    public static void refreshPage(WebDriver driver) throws InterruptedException {
        driver.navigate().refresh();
        driver.manage().window();
    }
}

