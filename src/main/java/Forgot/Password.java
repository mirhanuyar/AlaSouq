package Forgot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static Register.Individual.submitForm;

public class Password {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void setUpDriver(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void openRegistrationPage(){
        driver.get("https://alasouq.com/auth/reset-password/init");
    }
    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("uyaruyr73@gmail.com");
        Thread.sleep(3000);
    }
}
