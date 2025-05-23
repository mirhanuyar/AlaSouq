package web.advert.active.statics.view;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticsView {
    public static void main(String[] args) {
        try {
            ViewAdvert viewAdvert = new ViewAdvert();
            viewAdvert.performViewAdvertFlow();

            WebDriver driver = viewAdvert.getDriver();
            WebDriverWait wait = viewAdvert.getWait();
            Thread.sleep(3000);

            clickUserIcon(wait);
            Thread.sleep(2000);
            fillForm(driver);
            Thread.sleep(2000);
            signIn(driver);
            Thread.sleep(2000);
            clickMyAdverts(driver);
            Thread.sleep(2000);
            clickAction(driver);
            Thread.sleep(2000);
            clickStatics(driver);
            Thread.sleep(2000);
            scrollScreen(driver);
        } catch (InterruptedException e) {
        e.printStackTrace();
    }

    }

    public static void clickUserIcon(WebDriverWait wait) throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
        Thread.sleep(1000);
    }


    public static void fillForm(WebDriver driver) throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void signIn(WebDriver driver) throws InterruptedException {
        WebElement clickSignIn = driver.findElement(By.id("btn-sign-in"));
        clickSignIn.click();
        Thread.sleep(1000);
    }

    public static void clickMyAdverts(WebDriver driver) throws InterruptedException {
        WebElement myAdverts = driver.findElement(By.id("link-my-adverts"));
        myAdverts.click();
    }

    public static void clickAction(WebDriver driver) throws InterruptedException {
        WebElement action = driver.findElement(By.cssSelector("button.dropdown-toggle.primary.my-advert-action-button"));
        action.click();
    }

    public static void clickStatics(WebDriver driver) throws InterruptedException {
        WebElement statics = driver.findElement(By.cssSelector("button[id*='btn-statistics']"));
        statics.click();
        Thread.sleep(2000);
    }

    public static void scrollScreen(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", 500);
    }



}
