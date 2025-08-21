package mobile.user.information.passive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Unpublished {
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
            passiveAdvert();
            Thread.sleep(2000);
            searchBar();
            Thread.sleep(2000);
            clickAdvert();
            Thread.sleep(2000);
            clickEdit();
            Thread.sleep(2000);
            backPage();
            Thread.sleep(2000);
            clickPublish();
            Thread.sleep(2000);
            scrollToBottom();
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

    public static void passiveAdvert() throws InterruptedException {
        clickElement(By.id("link-passive"));
    }

    public static void searchBar() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Kelime / İlan Numarası Girin']"));
        searchBar.sendKeys("DENİZ MANZARALI YOLA SIFIR İMARLI TEK TAPU ARSA-ARAÇ TAKASLI");
        Thread.sleep(1000);
        searchBar.clear();
        searchBar.sendKeys("100036");
    }

    public static void clickAdvert() throws InterruptedException {
        clickElement(By.xpath("//div[contains(@class, 'advert-content')]"));
    }

    public static void clickEdit() throws InterruptedException {
        clickElement(By.id("btn-edit-advert"));
    }

    public static void backPage() throws InterruptedException {
        driver.navigate().back();
    }

    public static void clickPublish() throws InterruptedException {
        clickElement(By.id("btn-take-down-advert"));
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}