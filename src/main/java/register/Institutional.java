package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Institutional {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/auth/register-tenant");
    }

    public static void fillForm() throws InterruptedException {
        enterText(By.id("ion-input-0"), "uyaruyr73@gmail.com");
        Thread.sleep(1000);
        enterText(By.id("ion-input-1"), "Mirhan");
        Thread.sleep(1000);
        enterText(By.id("ion-input-2"), "Uyar");
        Thread.sleep(1000);
        enterText(By.id("ion-input-4"), "Uyar6565");
        Thread.sleep(1000);

        clickElement(By.id("register-select-language"));
        Thread.sleep(1000);
        clickElement(By.id("alert-input-2-3"));
        Thread.sleep(1000);
        clickElement(By.cssSelector("button[class='alert-button ion-focusable ion-activatable sc-ion-alert-ios']"));
        Thread.sleep(1000);
        clickElement(By.xpath("//ion-checkbox[contains(text(), 'Bireysel Hesap Sözleşmesi ve Ekleri')]"));
        Thread.sleep(1000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.xpath("//ion-button[contains(text(), 'Kuruma Üye Ol')]"));
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
