package web.user.information.active;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BuyDoping {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            clickUserIcon2();
            Thread.sleep(2000);
            clickMyAdverts();
            Thread.sleep(2000);
            clickDoping();
            Thread.sleep(2000);
            checkBoldText();
            Thread.sleep(2000);
            checkScrollPositionIsTop();
            Thread.sleep(2000);
            checkImFresh();
            Thread.sleep(2000);
            checkUrgent();
            Thread.sleep(2000);
            clickContinueButton();
            Thread.sleep(2000);
            scrollToElement(By.id("ngb-accordion-item-3-toggle"));
            Thread.sleep(2000);
            checkPaymentMethod();
            Thread.sleep(2000);
            clickPlaceOrder();
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

    public static void clickUserIcon2() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.mobile-cart i.ri-user-line")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public static void clickMyAdverts() throws InterruptedException {
        WebElement myAdverts = driver.findElement(By.id("link-my-adverts"));
        myAdverts.click();
    }

    public static void clickDoping() throws InterruptedException {
        WebElement dopingButton = driver.findElement(By.id("btn-do-doping-100011"));
        dopingButton.click();
    }

    public static void checkBoldText() throws InterruptedException {
        WebElement bold = driver.findElement(By.id("boost-boost-kalin-yazi-renkli-cerceve"));
        bold.click();
    }

    public static void checkScrollPositionIsTop() throws InterruptedException {
        WebElement top = driver.findElement(By.id("boost-boost-ust-siradayim"));
        top.click();
    }

    public static void checkImFresh() throws InterruptedException {
        WebElement fresh = driver.findElement(By.id("boost-boost-güncelim"));
        fresh.click();
    }

    public static void checkUrgent() throws InterruptedException {
        WebElement urgent = driver.findElement(By.id("boost-boost-acil-acil"));
        urgent.click();
    }

    public static void clickContinueButton() throws InterruptedException {
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(normalize-space(), 'Continue')]"));
        continueButton.click();
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void checkPaymentMethod() throws InterruptedException {
        WebElement payment = driver.findElement(By.id("ngb-accordion-item-1-toggle"));
        payment.click();
    }

    public static void clickPlaceOrder() throws InterruptedException {
        WebElement order = driver.findElement(By.id("place_order"));
        order.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
