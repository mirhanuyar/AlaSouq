package Advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Favorite {
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
            clickItemByText("Konut");
            Thread.sleep(1000);
            arama();
            Thread.sleep(1000);
            emlak();
            Thread.sleep(1000);
            emlakListeleme();
            Thread.sleep(1000);
            clickAdvert();
            Thread.sleep(1000);
            clickFavorite();
            Thread.sleep(1000);
            clickFavoriteList();
            Thread.sleep(1000);
            favoriteListName("emlak favori listem");
            Thread.sleep(1000);
            clickSaveFavoriteListButton();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clickItemByText(String text) throws InterruptedException {
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

    public static void arama() throws InterruptedException {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-search")));
        searchButton.click();
    }

    public static void emlak() throws InterruptedException {
        WebElement realEstateCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='real-estate']")));
        realEstateCategory.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void emlakListeleme() throws InterruptedException {
        WebElement emlakListAllButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-item[contains(@id, 'btn-list-all-ads')]")));

        emlakListAllButton.click();
    }

    public static void clickAdvert() throws InterruptedException {
        try {
            WebElement advertItem = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//h3[contains(text(), 'AYDIN GERMENCİKTE BAHÇELİ 2 +1 MÜSTAKİL EV')]")));
            advertItem.click();
        } catch (Exception e) {
            System.out.println("İlan bulunamadı veya tıklanamadı: " + e.getMessage());
        }
    }

    public static void clickFavorite() throws InterruptedException {
        try {
            WebElement favoriteButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"open-favorite-modal\"]")));
            favoriteButton.click();
        } catch (Exception e) {
            System.out.println("Favori butonuna tıklanamadı: " + e.getMessage());
        }
    }

    public static void clickFavoriteList() throws InterruptedException {
        try {
            WebElement favoriteListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"ion-overlay-5\"]/div/app-add-to-favorite/ion-content/ion-list/ion-item[2]")));
            favoriteListButton.click();
        } catch (Exception e) {
            System.out.println("Favori listesi eklenemedi: " + e.getMessage());
        }
    }

    public static void favoriteListName(String message) throws InterruptedException {
        try {
            WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("ion-input-2")));
            descriptionInput.sendKeys(message);
        } catch (Exception e) {
            System.out.println("yeni favori listesi alanına yazılamadı: " + e.getMessage());
        }
    }

    public static void clickSaveFavoriteListButton() throws InterruptedException {
        try {
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-save-favorite-list")));
            saveButton.click();
        } catch (Exception e) {
            System.out.println("Kaydet butonuna tıklanamadı: " + e.getMessage());
        }
    }
}