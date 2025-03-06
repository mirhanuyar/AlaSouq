package favorite.seller;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.time.Duration;
import java.util.List;

public class Create {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static List<String> favoriteAdverts = new ArrayList<>();

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            clickItemByText("Konut");
            Thread.sleep(2000);
            search();
            Thread.sleep(2000);
            emlak();
            Thread.sleep(2000);
            emlakListeleme();
            Thread.sleep(2000);
            clickAdvert();
            Thread.sleep(2000);
            clickTenantName();
            Thread.sleep(2000);
            clickAddSellerToFavorites();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clickItemByText(String text) {
        List<WebElement> listItems = driver.findElements(By.tagName("ion-item"));
        for (WebElement item : listItems) {
            if (item.getText().contains(text)) {
                item.click();
                break;
            }
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

    public static void search() throws InterruptedException {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-search")));
        searchButton.click();
    }

    public static void emlak() throws InterruptedException {
        WebElement realEstateCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='real-estate']")));
        realEstateCategory.click();
    }

    public static void emlakListeleme() throws InterruptedException {
        WebElement emlakListAllButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-item[contains(@id, 'btn-list-all-ads')]")));
        emlakListAllButton.click();
    }

    public static void clickAdvert() {
        try {
            WebElement advertItem = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ion-item[contains(@class, 'advert')]//h3[contains(text(), '208 M2 ARSA ÜZERİNDE SIFIRLANMIŞ 2+1 BAHÇELİ MÜSTAKİL')]")));
            advertItem.click();
        } catch (Exception e) {

        }
    }

    public static void clickTenantName() {
        WebElement tenantElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tenant-name']/span")));
        tenantElement.click();
    }

    public static void clickAddSellerToFavorites() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button']//span[contains(text(),'Satıcıyı Favorilere Ekle')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
