package mobile.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Update {
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
        searchBar();
        update();
        updateAdvertTitle();
        updateDescription();
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


    public static void searchBar() throws InterruptedException {
        WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Kelime / İlan Numarası Girin']"));
        searchBar.sendKeys("AYDIN GERMENCİKTE BAHÇELİ 2 +1 MÜSTAKİL EV");
        Thread.sleep(1000);
        searchBar.clear();
        searchBar.sendKeys("100003");
    }


    public static void update() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement advertItem = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-item//span[contains(text(),'SAHİBİNDEN BUTİK SİTE İÇİ 3+1 ULTRA LÜKS SIFIR DAİRE')]")
        ));
        advertItem.click();
    }

    public static void updateAdvertTitle() throws InterruptedException {
        WebElement titleInput = driver.findElement(By.xpath("//ion-input[@id='value-change']//input"));
        titleInput.clear();
        titleInput.sendKeys("SAHİBİNDEN BUTİK SİTE İÇİ 3+1 ULTRA LÜKS SIFIR DAİREEE");
        Thread.sleep(1000);
    }

    public static void updateDescription() throws InterruptedException {
        WebElement descriptionInput = driver.findElement(By.xpath("//ion-input[@id='html-mode-active']//input"));
        descriptionInput.clear();
        descriptionInput.sendKeys("Hawaaiiii maleeeee");
        Thread.sleep(1000);
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}



