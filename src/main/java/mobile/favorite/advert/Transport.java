package mobile.favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Transport {
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
            favoriteAdvert();
            Thread.sleep(2000);
            clickFavoriteListByName();
            Thread.sleep(2000);
            advertAction();
            Thread.sleep(2000);
            clickMoveToAnotherFavoriteList();
            Thread.sleep(2000);
            moveToList();
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

    public static void favoriteAdvert() throws InterruptedException {
        clickElement(By.id("link-favorite-advert"));
    }

    public static void clickFavoriteListByName() throws InterruptedException {
        clickElement(By.id("favorite-list-1"));
    }

    public static void advertAction() throws InterruptedException {
        clickElement(By.id("advert-action-sheet-0"));
    }

    public static void clickMoveToAnotherFavoriteList() {
        WebElement moveButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(@class, 'action-sheet-button')]//span[contains(text(), 'Favori İlanı Başka Bir Listeye Taşı')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", moveButton);
    }

    public static void moveToList() throws InterruptedException{
        WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//ion-radio[contains(text(), 'yeni oluşturulan liste')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", radioButton);
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}