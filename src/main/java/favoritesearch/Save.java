package favoritesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Save {
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
            clickCategory();
            Thread.sleep(2000);
            selectCategory("Arsa");
            Thread.sleep(2000);
            btnCategorySelected();
            Thread.sleep(2000);
            saveSearch();
            Thread.sleep(2000);
            favoriteSearchNameFilling();
            Thread.sleep(2000);
            clickSaveSearchButton();

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

    public static void clickCategory() throws InterruptedException {
        WebElement realEstateCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='real-estate']")));
        realEstateCategory.click();
    }

    public static void selectCategory(String categoryName) {
        WebElement categoryElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-item[@id='btn-category-selected'][.//ion-label[text()='" + categoryName + "']]")
        ));
        categoryElement.click();
    }

    public static void btnCategorySelected() {
        WebElement category = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-list-all-ads")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", category);
    }


    public static void saveSearch() throws InterruptedException{
        clickElement(By.id("save-search-modal"));
    }

    public static void favoriteSearchNameFilling() throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-input[@id='favorite-search-name']//input")
        ));
        element.clear();
        element.sendKeys("favori arama testi");
    }

    public static void clickSaveSearchButton() throws InterruptedException {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ion-button[@id='btn-save-search' and contains(text(),'Kaydet')]")));
        saveButton.click();
    }




    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
