package mobile.information;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class UpdateProfilePhoto {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            userInformation();
            Thread.sleep(2000);
            personalInformation();
            Thread.sleep(2000);
            clickUpdatePhoto();
            Thread.sleep(2000);
            loadPhoto();
            Thread.sleep(2000);
            choosingPhoto();
            Thread.sleep(2000);
            saveButton();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("http://localhost:4200/home");
    }

    public static void fillForm() throws InterruptedException {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Giriş Yap']")));
        loginButton.click();
        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void userInformation() throws InterruptedException {
        clickElement(By.id("link-account-info"));
    }

    public static void personalInformation() throws InterruptedException {
        clickElement(By.id("link-profile"));
    }

    public static void clickUpdatePhoto() throws InterruptedException{
        clickElement(By.id("btn-take-photo"));
    }

    public static void loadPhoto() throws InterruptedException{
        WebElement galleryButton = driver.findElement(By.xpath("//div[span[text()='Galeriden Seç']]"));
        galleryButton.click();
    }

    public static void choosingPhoto() throws InterruptedException{
        System.out.println("devam etmek için enter tuşuna basın");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void saveButton() throws InterruptedException{
        clickElement(By.id("btn-update"));
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
}