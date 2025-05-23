package mobile.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

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
        Thread.sleep(2000);
        accountClick();
        Thread.sleep(2000);
        changeLanguage();
        Thread.sleep(2000);
        clickTurkishButton();
        Thread.sleep(2000);
        fillForm();
        Thread.sleep(2000);
        submitForm();
        Thread.sleep(2000);
        createAdvert();
        Thread.sleep(2000);
        emlak();
        Thread.sleep(2000);
        isyeri();
        Thread.sleep(2000);
        kiralik();
        Thread.sleep(2000);
        akaryakitIst();
        Thread.sleep(2000);
        ilanBasligi();
        Thread.sleep(2000);
        aciklama();
        Thread.sleep(2000);
        fiyat();
        Thread.sleep(2000);
        tamam();
        Thread.sleep(2000);
        location();
        Thread.sleep(2000);
        devamEt();
        Thread.sleep(2000);
        mapClick();
        Thread.sleep(2000);
        adresBilgisiButton();
        Thread.sleep(2000);
        iletisimButton();
        Thread.sleep(2000);
        photoUpload();
        Thread.sleep(2000);
        photoButton();
        Thread.sleep(2000);
        acceptRulesAdvert();
        Thread.sleep(2000);
        btnContinue();
        Thread.sleep(2000);
        clickProButton();
    }

    public static void openRegistrationPage() {
        driver.get("http://localhost:4200/home");
    }

    public static void accountClick() throws InterruptedException{
        clickElement(By.id("btn-my-account"));
    }


    public static void changeLanguage() throws InterruptedException{
        clickElement(By.id("present-action-sheet"));
    }

    public static void clickTurkishButton() throws InterruptedException {
        WebElement turkishButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'action-sheet-button') and span[text()='Türkçe']]")));

        turkishButton.click();
        Thread.sleep(2000);
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
    }

    public static void createAdvert() throws InterruptedException {
        clickElement(By.id("btn-construct"));
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

    public static void adresBilgisiButton()  throws InterruptedException {
        clickElement(By.id("btn-continue-address"));
    }

    public static void mapClick() throws InterruptedException {
        System.out.println("devam etmek için enter tuşuna basın");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public static void iletisimButton() throws InterruptedException {
        List<WebElement> buttons = driver.findElements(By.id("btn-continue-communication"));
        WebElement correctButton = buttons.get(1);
        correctButton.click();
    }

    public static void photoUpload() throws InterruptedException {
        System.out.println("devam etmek için enter tuşuna basın");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void photoButton() throws InterruptedException {
        clickElement(By.id("btn-continue-photo-select"));
    }

    public static void acceptRulesAdvert() throws InterruptedException {
        clickElement(By.id("checkbox-accept-rules-advert"));
        Thread.sleep(1000);
    }

    public static void btnContinue() throws InterruptedException {
        clickElement(By.id("btn-continue"));
    }

    public static void clickProButton() throws InterruptedException {
        WebElement proButton = driver.findElement(By.xpath("//ion-segment-button[@id='btn-offer-segment']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", proButton);

        Thread.sleep(1000);
    }




    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
