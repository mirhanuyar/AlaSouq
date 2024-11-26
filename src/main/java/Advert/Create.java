package Advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Create {
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
        createAdvert();
        emlak();
        isyeri();
        kiralik();
        akaryakitIst();
        ilanBasligi();
        aciklama();
        fiyat();
        tamam();
        location();
        devamEt();
        buttonAddress();
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

    public static void createAdvert() throws InterruptedException {
        clickElement(By.id("icon-circle-outline"));
    }

    public static void emlak() throws InterruptedException {
        clickElement(By.xpath("//ion-item[contains(text(), 'Emlak')]"));
    }

    public static void clickItemByText(String text) throws InterruptedException {
        List<WebElement> items = driver.findElements(By.cssSelector("ion-item"));
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                item.click();
                Thread.sleep(1000);
                break;
            }
        }
    }

    public static void isyeri() throws InterruptedException {
        clickItemByText("İş Yeri");
    }

    public static void kiralik() throws InterruptedException {
        clickItemByText("Kiralık");
    }

    public static void akaryakitIst() throws InterruptedException {
        clickItemByText("Akaryakıt İstasyonu");
    }

    public static void ilanBasligi() throws InterruptedException {
        WebElement ilanbasligi = driver.findElement(By.id("ion-input-2"));
        ilanbasligi.sendKeys("Acil Kiralık");
        Thread.sleep(1000);
    }

    public static void aciklama() throws InterruptedException {
        WebElement aciklama = driver.findElement(By.id("ion-input-4"));
        aciklama.sendKeys("Acil Kiralık");
        Thread.sleep(1000);
    }

    public static void fiyat() throws InterruptedException {
        WebElement fiyat = driver.findElement(By.id("ion-input-3"));
        fiyat.sendKeys("10000");
        Thread.sleep(1000);
    }

    public static void tamam() throws InterruptedException {
        clickElement(By.id("btn-continue-details-advert"));
    }

    public static void location() throws InterruptedException {
        clickElement(By.id("btn-current-location"));
    }

    public static void devamEt() throws InterruptedException {
        clickElement(By.id("btn-continue-communication"));
    }

    public static void buttonAddress() throws InterruptedException {
        clickElement(By.id("btn-continue-communication"));
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }



    /*public static void mapClick() throws InterruptedException {
        WebElement mapElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".map-container-inner")));

        Actions actions = new Actions(driver);

        int xOffset = 100;
        int yOffset = 100;

        actions.moveToElement(mapElement, xOffset, yOffset).click().perform();

        System.out.println("Harita üzerinde belirtilen alana tıklama işlemi gerçekleştirildi.");
        Thread.sleep(2000);
    }*/


}
