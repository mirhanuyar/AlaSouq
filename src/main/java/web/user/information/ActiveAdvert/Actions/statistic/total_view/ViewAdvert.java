package web.user.information.ActiveAdvert.Actions.statistic.total_view;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewAdvert {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public ViewAdvert() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void performViewAdvertFlow() throws InterruptedException {
        openRegistrationPage();
        clickUserIcon();
        fillForm();
        signIn();
        goHome();
        clickAdvert();
        scrollScreen(-500);
        clickUserIcon();
        scrollScreen(700);
        logOut();
    }

    public void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void openRegistrationPage() throws InterruptedException {
        driver.get("https://alasouq.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }



    public void clickUserIcon() throws InterruptedException {
        Thread.sleep(3000);
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
    }


    public void fillForm() throws InterruptedException {
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("abdullah.sahin@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
    }

    public void signIn() throws InterruptedException {
        Thread.sleep(3000);
        WebElement clickSignIn = driver.findElement(By.id("btn-sign-in"));
        clickSignIn.click();
    }

    public void goHome() throws InterruptedException {
        Thread.sleep(3000);
        WebElement goHome = driver.findElement(By.id("home-link"));
        goHome.click();
    }

    public void clickAdvert() throws InterruptedException {
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ilan = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h6[text()='SAHİBİNDEN BUTİK SİTE İÇİ 3+1 ULTRA LÜKS SIFIR DAİRE']/ancestor::a")
        ));
        ilan.click();
        Thread.sleep(2000);
        scrollScreen(500);
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(4000);
    }

    public static void scrollScreen(int pixels) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(3000);
        WebElement logOutButton = driver.findElement(By.id("link-logout"));
        logOutButton.click();
        Thread.sleep(2000);
        WebElement yesButton = driver.findElement(By.id("confirm_yes_btn"));
        yesButton.click();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        ViewAdvert.driver = driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void setWait(WebDriverWait wait) {
        ViewAdvert.wait = wait;
    }
}
