package Advert;

import org.openqa.selenium.By;
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
            openRegistrationPage();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
            createAdvert();
            Thread.sleep(1000);
            emlak();
            Thread.sleep(1000);
            isyeri();
            Thread.sleep(1000);
            kiralik();
            Thread.sleep(1000);
            clickItemByText();
            Thread.sleep(1000);
            akaryakitIst();
            Thread.sleep(1000);
            ilanBasligi();
            Thread.sleep(1000);
            aciklama();
            Thread.sleep(1000);
            fiyat();
            Thread.sleep(1000);
            tamam();
            Thread.sleep(1000);
            location();
            Thread.sleep(1000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clickItemByText() {
    }

    public static void setUpDriver(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public static void openRegistrationPage(){
        driver.get("https://alasouq.com/my-account");
    }
    public static void fillForm() throws InterruptedException {

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Giriş Yap']")));
        loginButton.click();
        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("mirhan225@gmail.com");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("uyar6565");
        Thread.sleep(3000);
    }
    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void createAdvert() throws InterruptedException {
        clickElement(By.id("icon-circle-outline"));
        Thread.sleep(2000);
    }

    public static void emlak() throws InterruptedException {
        clickElement(By.xpath("//ion-item[contains(text(), 'Emlak')]"));
        Thread.sleep(2000);
    }

    public static void clickItemByText(String text) throws InterruptedException {
        List<WebElement> items = driver.findElements(By.cssSelector("ion-item"));
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                item.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    public static void isyeri() throws InterruptedException {
        clickItemByText("İş Yeri");
    }

    public static void kiralik() throws InterruptedException{
        clickItemByText("Kiralık");
    }

    public static void akaryakitIst() throws InterruptedException{
        clickItemByText("Akaryakıt İstasyonu");
    }
    public static void bekle()throws InterruptedException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Manuel işlemi yapın ve devam etmek için Enter'a basın...");
        scanner.nextLine();
    }

    public static void ilanBasligi()throws InterruptedException{
        WebElement ilanbasligi = driver.findElement(By.id("ion-input-2"));
        ilanbasligi.sendKeys("!!!!!!!!!!!!!??????????????_------");
        Thread.sleep(2000);
    }

    public static void aciklama()throws InterruptedException{
        WebElement aciklama  = driver.findElement(By.id("ion-input-4"));
        aciklama.sendKeys("!!!!!!!!!!!!!??????????????_------");
    }

    public static void fiyat()throws InterruptedException{
        WebElement fiyat  = driver.findElement(By.id("ion-input-3"));
        fiyat.sendKeys("10000000000");
    }

    public static void tamam() throws InterruptedException{
        clickElement(By.id("btn-continue-details-advert"));
        Thread.sleep(2000);
    }

    public static void location()throws InterruptedException{
        clickElement(By.id("btn-current-location"));
        Thread.sleep(2000);
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
    }
}
