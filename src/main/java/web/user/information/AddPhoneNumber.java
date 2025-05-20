package web.user.information;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddPhoneNumber {
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
            scrollToElement(By.linkText("Edit"));
            Thread.sleep(2000);
            addNewPhoneNumber();
            Thread.sleep(2000);
            clickCountryCodeComboBox();
            Thread.sleep(2000);
            clickInputPhoneNumber();
            Thread.sleep(2000);
            submitButton();
            Thread.sleep(2000);
            clickSubmitButton();
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

    public static void clickUserIcon2() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.mobile-cart i.ri-user-line")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void addNewPhoneNumber() throws InterruptedException {
        WebElement number = driver.findElement(By.id("add-first-phone"));
        number.click();
    }

    public static void clickSubmitButton() throws InterruptedException {
        WebElement submit = driver.findElement(By.id("submit_profile_btn"));
        submit.click();
    }

    public static void clickCountryCodeComboBox() throws InterruptedException {
        WebElement comboBox = driver.findElement(By.id("pn"));
        comboBox.click();
        Thread.sleep(1000);
        WebElement countryCode = driver.findElement(By.id("pn-option-227"));
        countryCode.click();
    }

    public static void clickInputPhoneNumber() throws InterruptedException {
        WebElement input = driver.findElement(By.id("input-phone-number"));
        input.click();
        Thread.sleep(400);
        input.sendKeys("5444033986");
    }

    public static void submitButton() throws InterruptedException {
        WebElement submit = driver.findElement(By.id("submit_profile_btn"));
        submit.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }


}
