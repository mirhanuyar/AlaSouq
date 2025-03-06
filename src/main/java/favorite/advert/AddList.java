package favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddList {
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
            arama();
            Thread.sleep(2000);
            emlak();
            Thread.sleep(2000);
            emlakListeleme();
            Thread.sleep(2000);
            clickAdvert();
            Thread.sleep(2000);
            addFavoriteAdvert("KİREÇHANE KİRALIK DENİZ MANZARALI ARSA ");
            Thread.sleep(3000);
            createMultipleFavoriteLists(3);

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

    public static void arama() throws InterruptedException {
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
                    By.xpath("//ion-item[contains(@class, 'advert')]//h3[contains(text(), 'KİREÇHANE KİRALIK DENİZ MANZARALI ARSA')]")));
            advertItem.click();
        } catch (Exception e) {

        }
    }

    public static void addFavoriteAdvert(String advertTitle) {
        try {
            WebElement favoriteButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"open-favorite-modal\"]")));
            favoriteButton.click();

            favoriteAdverts.add(advertTitle);
            System.out.println("Favorilere eklendi: " + advertTitle);

            clickSaveFavoriteListButton();
        } catch (Exception e) {
            System.out.println("Favori butonuna tıklanamadı: " + e.getMessage());
        }
    }

    public static void createMultipleFavoriteLists(int listCount) throws InterruptedException {
        for (int i = 1; i <= listCount; i++) {
            System.out.println("Favori listesi oluşturuluyor: Favori Listem " + i);

            WebElement addNewListButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ion-item[.//span[text()='Yeni Liste Ekle']]")));
            addNewListButton.click();

            Thread.sleep(1000);

            favoriteListName("Favori Listem " + LocalDateTime.now().toString().replace(":", "-"));

            clickSaveFavoriteListButton();

            Thread.sleep(1000);
        }
    }

    public static void favoriteListName(String message) {
        try {
            WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("ion-input-2")));
            descriptionInput.sendKeys(message);
        } catch (Exception e) {
            System.out.println("Yeni favori listesi alanına yazılamadı: " + e.getMessage());
        }
    }

    public static void clickSaveFavoriteListButton() {
        try {
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-save-favorite-list")));
            saveButton.click();

            wait.until(ExpectedConditions.invisibilityOf(saveButton));
        } catch (Exception e) {
            System.out.println("Kaydet butonuna tıklanamadı: " + e.getMessage());
        }
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
