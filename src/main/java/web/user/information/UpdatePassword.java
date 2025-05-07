package web.user.information;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UpdatePassword {
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
            clickEditPassword();
            Thread.sleep(2000);
            clickCurrentPassword();
            Thread.sleep(2000);
            clickNewPassword();
            Thread.sleep(2000);
            clickConfirmPassword();
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
        driver.get("http://localhost:4300");
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

    public static void clickEditPassword() throws InterruptedException {
        driver.findElement(By.xpath("//h6[contains(text(), 'Password')]/following-sibling::a")).click();
    }

    public static void clickCurrentPassword() throws InterruptedException {
        WebElement password = driver.findElement(By.id("cpass"));
        password.click();
        Thread.sleep(500);
        password.sendKeys("admin");
    }

    public static void clickNewPassword() throws InterruptedException {
        WebElement newPassword = driver.findElement(By.id("npass"));
        newPassword.click();
        Thread.sleep(500);
        newPassword.sendKeys("testadmin");
    }

    public static void clickConfirmPassword() throws InterruptedException {
        WebElement confirmPassword = driver.findElement(By.id("cnpass"));
        confirmPassword.click();
        Thread.sleep(500);
        confirmPassword.sendKeys("testadmin");
    }

    public static void clickSubmitButton() throws InterruptedException {
        WebElement submit = driver.findElement(By.id("submit_profile_btn"));
        submit.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
