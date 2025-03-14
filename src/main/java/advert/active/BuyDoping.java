package advert.active;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BuyDoping {
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
            clickDoping();
            Thread.sleep(2000);
            dopingOptions();
            Thread.sleep(2000);
            dopingContinue();
            Thread.sleep(2000);
            urgentUrgentSelect();
            Thread.sleep(2000);
            updateSelect();
            Thread.sleep(2000);
            boldText();
            Thread.sleep(2000);
            selectTopListing();
            Thread.sleep(2000);
            //paymentMethod();
            Thread.sleep(2000);
            continuePayment();
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
        currentPasswordField.sendKeys("admin");
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

    public static void clickDoping() throws InterruptedException {
        clickElement(By.id("click-goto-doping"));
    }

    public static void dopingOptions() throws InterruptedException {
        List<WebElement> checkboxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ion-checkbox")));

        for (WebElement checkbox : checkboxes) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
            Thread.sleep(500);
        }
    }

    public static void dopingContinue() throws InterruptedException {
        clickElement(By.id("btn-doping-info-continue"));
    }

    public static void urgentUrgentSelect() throws InterruptedException {
        WebElement selectOffer = driver.findElement(By.cssSelector(".select-offer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectOffer);
        Thread.sleep(2000);
        WebElement fourWeeksOption = driver.findElement(By.xpath("//ion-item/div/span[contains(text(), '4 Hafta')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fourWeeksOption);

    }

    public static void updateSelect() throws InterruptedException {
        WebElement updateOffer = driver.findElement(By.xpath("//div[contains(@class, 'offer-item')][.//span[text()='Güncelim']]"));

        WebElement selectOffer = updateOffer.findElement(By.cssSelector(".select-offer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectOffer);
        Thread.sleep(2000);

        WebElement onePieceOption = driver.findElement(By.xpath("//ion-list//ion-item/div/span[contains(text(), '1 Adet')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", onePieceOption);
    }

    public static void boldText() throws InterruptedException {
        WebElement boldText = driver.findElement(By.xpath("//div[contains(@class, 'offer-item')][.//span[text()='Kalın Yazı & Renkli Çerçeve']]"));

        WebElement selectOffer = boldText.findElement(By.cssSelector(".select-offer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectOffer);
        Thread.sleep(2000);

        WebElement oneWeekOption = driver.findElement(By.xpath("//ion-list//ion-item/div/span[contains(text(), '4 Hafta')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", oneWeekOption);
    }

    public static void selectTopListing() throws InterruptedException {
        WebElement topListingOffer = driver.findElement(By.xpath("//div[contains(@class, 'offer-item')][.//span[text()='Üst Sıradayım']]"));

        WebElement selectOffer = topListingOffer.findElement(By.cssSelector(".select-offer"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectOffer);
        Thread.sleep(2000);

        WebElement oneWeekOption = driver.findElement(By.xpath("//ion-list//ion-item/div/span[contains(text(), '4 Hafta')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", oneWeekOption);
    }


    /*public static void paymentMethod() throws InterruptedException {
        WebElement radioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ion-radio[span[text()='PayPal']]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioButton);
    }*/

    public static void continuePayment() throws InterruptedException {

        WebElement continueButton = driver.findElement(By.xpath("//*[text()='Devam Et' or contains(@id, 'doping-info-continue')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", continueButton);

        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueButton);
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}
