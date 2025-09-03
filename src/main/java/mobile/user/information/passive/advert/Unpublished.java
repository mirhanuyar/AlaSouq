package mobile.user.information.passive.advert;

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

public class Unpublished {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args)throws Exception {
        setUpDriver();
        try {
            saveModal();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            passiveAdvert();
            Thread.sleep(2000);
            passiveAdvert();
            Thread.sleep(2000);
            clickFirstAdvert();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() throws InterruptedException {


        ChromeOptions options = new ChromeOptions();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://m.alasouq.com/en/home");
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

        emailField.sendKeys("tajdin.gurdal@solidsoft.com.tr");
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

    public static void passiveAdvert() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement activeTab = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("link-passive"))
        );
        activeTab.click();

    }
    public static void clickFirstAdvert() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        List<WebElement> adverts = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ion-item"))
        );

        if (!adverts.isEmpty()) {
            WebElement firstAdvert = adverts.get(0);

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstAdvert
            );

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstAdvert);

            System.out.println("İlk ilana tıklandı: " + firstAdvert.getText());
        } else {
            System.out.println("Hiç ilan bulunamadı.");
        }
        driver.findElement(By.id("btn-take-down-advert")).click();
    }


    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

}