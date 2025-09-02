package web.user.information.active.advert.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShareAdvert {
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
            clickShareAdvert();
            Thread.sleep(2000);
            //clickShareFacebook();
            //clickShareTwitter();
            //clickShareWhatsapp();
            //clickShareMail();
            //clickCopyButton();
            clickCloseButton();
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
        emailField.sendKeys("yakup.user@solidsoft.com.tr");
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

    public static void clickShareAdvert() throws InterruptedException {
        WebElement shareAdvert = driver.findElement(By.cssSelector("button[id*='btn-share']"));
        shareAdvert.click();
        Thread.sleep(3500);
    }

    public static void clickShareTwitter() throws InterruptedException {
        WebElement facebookIcon = driver.findElement(By.id("social-btn-twitter"));
        facebookIcon.click();
        Thread.sleep(3500);
    }

    public static void clickShareWhatsapp() throws InterruptedException {
        WebElement facebookIcon = driver.findElement(By.id("social-btn-whatsapp"));
        facebookIcon.click();
        Thread.sleep(3500);
    }

    public static void clickShareMail() throws InterruptedException {
        WebElement facebookIcon = driver.findElement(By.id("social-btn-mail"));
        facebookIcon.click();
        Thread.sleep(3500);
    }

    public static void clickCopyButton() throws InterruptedException {
        WebElement copyButton = driver.findElement(By.id("button-addon1"));
        copyButton.click();
        Thread.sleep(3500);
    }

    public static void clickCloseButton() throws InterruptedException {
        WebElement closeButton = driver.findElement(By.id("share_modal_close_btn"));
        closeButton.click();
        Thread.sleep(3500);
    }



}
