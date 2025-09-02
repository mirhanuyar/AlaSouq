package mobile.user.information.active.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PriceInformation {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
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
            activeAdvert();
            Thread.sleep(2000);
            searchBar();
            Thread.sleep(2000);
            clickAdvert();
            Thread.sleep(2000);
            scrollToBottom();
            Thread.sleep(2000);
            scrollByAmount(500);
            Thread.sleep(2000);
            scrollToElement(By.id("click-goto-doping"));
            Thread.sleep(2000);
            clickPriceHistory();

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
        Thread.sleep(2000);
    }

    public static void activeAdvert() throws InterruptedException {
        clickElement(By.id("link-active"));
    }

    public static void searchBar() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Kelime / İlan Numarası Girin']"));
        searchBar.sendKeys("AYDIN GERMENCİKTE BAHÇELİ 2 +1 MÜSTAKİL EV");
        Thread.sleep(1000);
        searchBar.clear();
        searchBar.sendKeys("100003");
    }

    public static void clickAdvert() throws InterruptedException {
        clickElement(By.xpath("//div[contains(@class, 'advert-content')]"));
    }

    public static void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void scrollByAmount(int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ");");
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickPriceHistory() throws InterruptedException{
        clickElement(By.id("click-price-history"));
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}
