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

public class Delete {
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
            clickAdvert();
            Thread.sleep(2000);
            deleteAdvertAction();
            Thread.sleep(2000);
            deleteAdvert();
            Thread.sleep(2000);
            backPage();
            Thread.sleep(2000);
            deleteListAction();
            Thread.sleep(2000);
            deleteList();
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


    public static void clickAdvert() throws InterruptedException {
        clickElement(By.id("favorite-list-0"));
    }

    public static void deleteAdvertAction() throws InterruptedException {
        clickElement(By.id("advert-action-sheet-0"));
    }

    public static void deleteAdvert() throws InterruptedException {
        WebElement removeFavoriteButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(@class, 'action-sheet-button')]//span[contains(text(), 'Favorilerimden Kaldır')]")
        ));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", removeFavoriteButton);

    }

    public static void backPage() throws InterruptedException {
        driver.navigate().back();
    }

    public static void deleteListAction() throws InterruptedException {
        clickElement(By.id("show-delete-modal-0"));
    }

    public static void deleteList() throws InterruptedException{
        clickElement(By.id("btn-delete"));
    }
    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}