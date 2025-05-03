package mobile.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PriceReduction {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();

        try {
            executeSteps();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void executeSteps() throws InterruptedException {
        openRegistrationPage();
        Thread.sleep(2000);
        fillForm();
        Thread.sleep(2000);
        submitForm();
        Thread.sleep(2000);
        activeAdvert();
        Thread.sleep(2000);
        clickAdvert();
        Thread.sleep(2000);
        clickUpdateAdvert();
        Thread.sleep(2000);
        decreasePrice();
        Thread.sleep(2000);
        acceptRules();
        Thread.sleep(2000);
        clickContinue();
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
        emailField.sendKeys("onder.backoffice@solidsoft.com.tr");
        Thread.sleep(1000);

        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(1000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
    }

    public static void activeAdvert() throws InterruptedException {
        clickElement(By.id("link-active"));
    }

    public static void clickAdvert() throws InterruptedException {
        WebElement advertItem = driver.findElement(By.xpath("//ion-item[div/div/label[text()='#100012']]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", advertItem);

    }

    public static void clickUpdateAdvert() throws InterruptedException{
        clickElement(By.id("btn-edit-advert"));
    }

    public static void decreasePrice() throws InterruptedException{
        WebElement element = clickElement(By.id("ion-input-3"));
        element.clear();
        element.sendKeys("1000");
        Thread.sleep(1500);
        clickElement(By.id("btn-update-advert-details"));
    }

    public static void acceptRules() throws InterruptedException{
        clickElement(By.id("checkbox-accept-rules-advert"));
    }

    public static void clickContinue() throws InterruptedException{
        clickElement(By.id("btn-continue"));
    }

    public static WebElement clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
        return element;
    }
}



