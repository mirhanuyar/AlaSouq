package Register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Individual {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            clickRegisterButton();
            clickRegisterEmail();
            fillForm();
            submitForm();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void openRegistrationPage() {
        driver.get("http://localhost:4200/");
    }

    public static void clickRegisterButton() throws InterruptedException {
        clickElement(By.xpath("//ion-item[contains(@class, 'item')]//ion-label[@id='link-register']"));
        Thread.sleep(1000);
    }

    public static void clickRegisterEmail() throws InterruptedException {
        clickElement(By.xpath("//ion-button[contains(text(), 'Register with email')]"));
    }

    public static void fillForm() throws InterruptedException {
        enterText(By.id("ion-input-0"), "uyaruyr73@gmail.com");
        Thread.sleep(1000);
        enterText(By.id("ion-input-1"), "Mirhan");
        Thread.sleep(1000);
        enterText(By.id("ion-input-2"), "Uyar");
        Thread.sleep(1000);
        enterText(By.id("ion-input-4"), "i");
        Thread.sleep(1000);

        clickElement(By.id("register-select-language"));
        Thread.sleep(1000);
        clickElement(By.id("alert-input-4-3"));
        Thread.sleep(1000);
        clickElement(By.cssSelector("button[class='alert-button ion-focusable ion-activatable sc-ion-alert-ios']"));
        Thread.sleep(1000);
        clickElement(By.id("checkbox-read-accept"));
        Thread.sleep(1000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(1000);
        clickElement(By.id("btn-email-address-correct-continue"));
        Thread.sleep(1000);
        clickElement(By.id("btn-register-ok"));
    }

    public static void enterText(By locator, String text) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(text);
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}
