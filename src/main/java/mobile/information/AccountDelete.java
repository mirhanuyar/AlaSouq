package mobile.information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDelete {
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
            userInformation();
            Thread.sleep(2000);
            accountDeleted();
            Thread.sleep(2000);
            deletedButton();
            Thread.sleep(2000);
            checkbox();
            Thread.sleep(2000);
            buttonDelete();

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
        currentPasswordField.sendKeys("admin6565");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void userInformation() throws InterruptedException {
        clickElement(By.id("link-account-info"));
    }

    public static void accountDeleted() throws InterruptedException {
        clickElement(By.id("link-delete-account"));
    }

    public static void deletedButton() throws InterruptedException {
        WebElement deleteButton = driver.findElement(By.xpath("//ion-button[contains(text(), 'Hesabımı İptal Et')]"));
        deleteButton.click();
    }

    public static void checkbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.xpath("//ion-checkbox//span[contains(text(), 'Hesap İptalini Onaylıyorum')]"));
        checkbox.click();
    }

    public static void buttonDelete() throws InterruptedException{
        WebElement deleteButton = driver.findElement(By.xpath("//ion-button[contains(text(), 'Hesabımı İptal Et')]"));
        deleteButton.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}