package mobile.user.information;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceReduction {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {


        try {
            executeSteps();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void executeSteps() throws InterruptedException {
        setUpDriver();
        Thread.sleep(2000);
        saveModal();
        Thread.sleep(2000);
        fillForm();
        Thread.sleep(2000);
        submitForm();
        Thread.sleep(2000);
        activeAdvert();
        Thread.sleep(2000);
        clickAdvert();
        Thread.sleep(2000);
        clickUpdateAdvert();
        Thread.sleep(2000);
        decreasePrice();
        Thread.sleep(2000);
        acceptRules();
        Thread.sleep(2000);
    }

    public static void setUpDriver() throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://m.alasouq.com/en/home");

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void saveModal () throws InterruptedException {
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.cssSelector("ion-button.button-outline"));
        button.click();
        Thread.sleep(2000);

    }

    public static void fillForm() throws InterruptedException {
        WebElement userIcon = driver.findElement(By.id("icon-person-outline"));
        userIcon.click();
        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(
                By.id("login-click"));

        loginButton.click();
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(
                By.cssSelector("input[type='email'].native-input")
        );

        emailField.sendKeys("onder.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);

        WebElement currentPasswordField = driver.findElement(By.cssSelector("input[type='password']"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        WebElement submitIcon = driver.findElement(By.id("btn-lgn-email"));
        submitIcon.click();
        Thread.sleep(2000);
    }


    public static void activeAdvert() throws InterruptedException {
        WebElement activeadvert= driver.findElement(By.id("link-active"));
        activeadvert.click();
        Thread.sleep(2000);
    }

    public static void clickAdvert()throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> adverts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.cssSelector("ion-list.result-list ion-item")));

        if (!adverts.isEmpty()) {
            WebElement firstAdvert = adverts.get(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstAdvert);
            System.out.println("İlk ilan JS ile tıklandı!");
            } else {
            System.out.println("Hiç ilan bulunamadı!");
            }
        }

    public static void clickUpdateAdvert() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement menuButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("ion-button ion-icon[name='ellipsis-horizontal-outline']"))
        ).findElement(By.xpath("./ancestor::ion-button"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuButton);
        System.out.println("Button tıklandı!");

        Thread.sleep(1000);
        WebElement updatePriceBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Update Price']]")));
        js.executeScript("arguments[0].click();", updatePriceBtn);
        System.out.println("Update Price butonuna tıklandı!");

    }

    public static void decreasePrice() throws InterruptedException{
        WebElement element = driver.findElement(By.id("ion-input-2"));
        element.clear();
        element.sendKeys("2000");
        Thread.sleep(1500);

    }

    public static void acceptRules() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement updateBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("btn-update-price")));
        updateBtn.click();

    }

    public static WebElement clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
        return element;
    }
}



