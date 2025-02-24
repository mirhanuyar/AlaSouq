package Advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteAdvert {
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
        fillForm();
        submitForm();
        activeAdvert();
        clickSpecificAdvert();
        update();
        radioButton();
        activateToggleButton();
        clickRempveButton();
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/my-account");
    }

    public static void fillForm() throws InterruptedException {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Giriş Yap']")));
        loginButton.click();
        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
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

    public static void clickSpecificAdvert() throws InterruptedException {
        clickElement(By.xpath("//ion-item[.//label[text()='#101135']]"));
    }

    public static void update() throws InterruptedException {
        clickElement(By.id("btn-take-down-advert"));
    }

    public static void radioButton() throws InterruptedException {
        clickElement(By.id("radio-complaint-item"));
    }

    public static void activateToggleButton() throws InterruptedException {
        WebElement toggleButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-toggle[contains(@class, 'toggle-justify-space-between')]")
        ));

        toggleButton.click();
        Thread.sleep(1000);
    }

    public static void clickRempveButton() throws InterruptedException {
        clickElement(By.xpath("//ion-button[contains(@class, 'button-full') and text()='Yayından Kaldır']"));
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
