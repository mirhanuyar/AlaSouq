package mobile.user.information.active;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyDoping {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickCountry();
            Thread.sleep(2000);
            selectCountry();
            Thread.sleep(2000);
            clickPreferredLanguage();
            Thread.sleep(2000);
            clickSelectLanguage();
            Thread.sleep(2000);
            clickPreferredCurrency();
            Thread.sleep(2000);
            clickSelectCurrency();
            Thread.sleep(2000);
            clickSaveButton();
            Thread.sleep(2000);
            accountClick();
            Thread.sleep(2000);
            changeLanguage();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            activeAdvert();
            Thread.sleep(2000);
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
        driver.manage().window().maximize();
    }

    public static void clickCountry() throws InterruptedException {
        WebElement country = driver.findElement(By.id("ion-input-2"));
        country.click();
    }

    public static void selectCountry() throws InterruptedException {
        WebElement iraqItem = driver.findElement(By.xpath("//ion-item[contains(text(), 'Iraq')]"));
        iraqItem.click();
        iraqItem.sendKeys(Keys.ESCAPE);
    }

    public static void clickPreferredLanguage() throws InterruptedException {
        WebElement country = driver.findElement(By.id("ion-input-0"));
        country.click();
    }

    public static void clickSelectLanguage() throws InterruptedException {
        WebElement turkishLanguage = driver.findElement(By.xpath("//ion-item[.//ion-label[text()='Türkçe']]"));
        turkishLanguage.click();
        turkishLanguage.sendKeys(Keys.ESCAPE);
    }

    public static void clickPreferredCurrency() throws InterruptedException {
        WebElement currency = driver.findElement(By.id("ion-input-1"));
        currency.click();
    }

    public static void clickSelectCurrency() throws InterruptedException {
        WebElement tryCurrency = driver.findElement(By.xpath("//ion-item[.//ion-label[text()='Türk Lirası']]"));
        tryCurrency.click();
        tryCurrency.sendKeys(Keys.ESCAPE);
    }

    public static void clickSaveButton() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.xpath("//ion-button[normalize-space()='Save']"));
        saveButton.click();
    }

    public static void accountClick() throws InterruptedException {
        clickElement(By.id("btn-my-account"));
    }

    public static void changeLanguage() throws InterruptedException {
        clickElement(By.id("present-action-sheet"));
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
        currentPasswordField.sendKeys("adminadmin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void activeAdvert() throws InterruptedException {
        clickElement(By.id("link-active"));
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}
