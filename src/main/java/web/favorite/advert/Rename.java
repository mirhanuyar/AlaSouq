package web.favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Rename {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickSaveAppSettings();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);

            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            clickAdvert();
            Thread.sleep(2000);
            favoriteListEdit();
            Thread.sleep(2000);
            clickListNameInput();
            Thread.sleep(2000);
            clickorganise();
            Thread.sleep(1000);
            clickorganise();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/tr/");
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebElement save = driver.findElement(By.id("btn-save-app-settings"));
        save.click();
    }

    public static void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);
    }


    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void signIn() throws InterruptedException {
        WebElement clickSignIn;
        clickSignIn = driver.findElement(By.cssSelector("button.custom-login-button"));
        clickSignIn.click();
        Thread.sleep(1000);
    }

    public static void clickAdvert() throws InterruptedException {
        WebElement productLink = driver.findElement(By.xpath("//*[contains(@class, 'ri-heart-line')]"));
        productLink.click();
        Thread.sleep(2000);
    }


    public static void favoriteListEdit() throws InterruptedException {
        WebElement duzenleButonu = driver.findElement(By.xpath("//span[text()='Düzenle']"));
        duzenleButonu.click();
    }

    public static void clickListNameInput() throws InterruptedException {
        WebElement input = driver.findElement(By.id("listName"));
        input.click();
        Thread.sleep(500);
        input.clear();
        input.sendKeys("RENAME TEST");
    }

 /*  public static void saveCreateList() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.id("btn-save-list"));
        saveButton.click();
    }*/

    public static void clickorganise() throws InterruptedException {
        WebElement organise = driver.findElement(By.cssSelector(".btn.w-25.btn-outline-primary"));

        organise.click();


    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
