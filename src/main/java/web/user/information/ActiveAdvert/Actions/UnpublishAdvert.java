package web.user.information.ActiveAdvert.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UnpublishAdvert {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            enterPage();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            clickMyAdverts();
            Thread.sleep(2000);
            clickAction();
            Thread.sleep(2000);
            clickUnpublishAdvert();
            Thread.sleep(2000);
            //clickSoldCheckBox();
            //Thread.sleep(2000);
           // clickRentCheckBox();
           // Thread.sleep(2000);
            clickGaveUpCheckBox();
            Thread.sleep(2000);
            //clickDeleteAdvertCheckBox();
            clickUnpublishButton();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/");
    }

    public static void enterPage() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("btn-save-app-settings")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public static void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.mobile-cart i.ri-user-line")));
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

    public static void clickMyAdverts() throws InterruptedException {
        WebElement myAdverts = driver.findElement(By.id("link-my-adverts"));
        myAdverts.click();
    }

    public static void clickAction() throws InterruptedException {
        WebElement action = driver.findElement(By.cssSelector("button.dropdown-toggle.primary.my-advert-action-button"));
        action.click();
    }

    public static void clickUnpublishAdvert() throws InterruptedException {
        WebElement unpublishAdvert = driver.findElement(By.cssSelector("button[id*='btn-unpublish']"));
        unpublishAdvert.click();
        Thread.sleep(3500);
    }

    public static void clickSoldCheckBox() throws InterruptedException {
        WebElement soldCheckBox = driver.findElement(By.id("SOLD"));
        soldCheckBox.click();
        Thread.sleep(2000);

    }

    public static void clickRentCheckBox() throws InterruptedException {
        WebElement rentCheckBox = driver.findElement(By.id("RENT"));
        rentCheckBox.click();
        Thread.sleep(2000);
        closeButton();
    }

    public static void clickGaveUpCheckBox() throws InterruptedException {
        WebElement gaveUpCheckBox = driver.findElement(By.id("GAVE_UP"));
        gaveUpCheckBox.click();
        Thread.sleep(2000);
    }

    public static void clickDeleteAdvertCheckBox() throws InterruptedException {
        WebElement deleteAdvertCheckBox = driver.findElement(By.cssSelector("input[id*='delete-advert']"));
        deleteAdvertCheckBox.click();
        Thread.sleep(2000);
    }

    public static void closeButton() throws InterruptedException {
        WebElement closeButton = driver.findElement(By.id("unpublish_modal_close_btn"));
        closeButton.click();
    }

    public static void clickUnpublishButton() throws InterruptedException {
        WebElement unpublishButton = driver.findElement(By.id("btn-un-publish"));
        unpublishButton.click();
    }

}
