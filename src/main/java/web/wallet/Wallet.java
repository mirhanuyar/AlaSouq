package web.wallet;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.awt.Robot;

public class Wallet {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args)throws Exception {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickSaveAppSettings();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(4000);
            clickWallet();
            Thread.sleep(2000);
            pageRefresh();
            Thread.sleep(2000);
            clickWallet();
            Thread.sleep(2000);
             /*   clickshareAdvert();
                Thread.sleep(2000);*/
            generateInovatıonLınk();
            Thread.sleep(2000);
            InvitationLink();
            Thread.sleep(2000);


        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/tr/");
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebElement save = driver.findElement(By.id("btn-default-app-settings"));
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
        driver.findElement(By.id("btn-sign-in")).click();
    }

    public static void clickWallet() throws InterruptedException {
        WebElement wallet = driver.findElement(By.id("link-wallet"));
        wallet.click();
        Thread.sleep(1000);
    }

    public static void pageRefresh() throws InterruptedException {
        driver.navigate().refresh();
    }

      /*  public static void clickshareAdvert() throws InterruptedException {
            WebElement clickshareAdvert = driver.findElement(By.id("btn-share-adverts"));
            clickshareAdvert.click();
            Thread.sleep(1000);

        }*/

    public static void generateInovatıonLınk() throws InterruptedException {
        WebElement generateInovatıonLınk = driver.findElement(By.id("btn-generate-invitation-link"));
        generateInovatıonLınk.click();
        Thread.sleep(1000);
    }

    public static void InvitationLink() throws Exception {

        String copiedValue = driver.findElement(By.cssSelector("div.referral-link > span")).getText();


        StringSelection selection = new StringSelection(copiedValue);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        ((JavascriptExecutor) driver).executeScript("window.open()");
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://www.google.com");
        Thread.sleep(2000);

        WebElement searchBox = driver.findElement(By.name("q"));
        driver.findElement(By.cssSelector(".niO4u.VDgVie.SlP8xc")).click();
        Thread.sleep(500);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500); // kısa bekleme

        searchBox.sendKeys(Keys.ENTER);

    }
}



