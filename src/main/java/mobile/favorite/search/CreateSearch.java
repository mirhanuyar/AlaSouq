package mobile.favorite.search;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CreateSearch {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {

        try {
            setUpDriver();
            Thread.sleep(2000);
            saveModal();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            submitForm();
            Thread.sleep(2000);
            clickButtonHome();
            Thread.sleep(2000);
            clickSearchInput();
            Thread.sleep(2000);
            clickRealEstate();
            Thread.sleep(2000);
            clickSearchNameInput();
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

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public static void saveModal() throws InterruptedException {
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

    public static void clickButtonHome() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("ion-icon.logo")
        ));
        try {
            logoIcon.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", logoIcon);
        }

    }

    public static void clickSearchInput() throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector("ion-searchbar input.searchbar-input"));

        input.clear();

        input.sendKeys("REAL ESTATE");
    }

    public static void clickRealEstate() throws InterruptedException {
        WebElement realEstate = driver.findElement(By.xpath("//ion-item[.//h3[text()='Real Estate']]"));
        realEstate.click();
        Thread.sleep(2000);
    }


    public static void clickSearchNameInput() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement modalButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("save-search-modal")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", modalButton);

            Thread.sleep(500);

            WebElement input;
            try {
                input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ion-input-2")));
            } catch (TimeoutException e) {
                WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("modal-shadow-host-selector")
                ));
                input = (WebElement) ((JavascriptExecutor) driver)
                        .executeScript("return arguments[0].shadowRoot.querySelector('input')", shadowHost);
            }

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value='Test'; arguments[0].dispatchEvent(new Event('input'));", input
            );

            WebElement saveButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-save-search")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveButton);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);

            System.out.println("Input değeri başarıyla atandı ve kaydedildi.");
        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e.getMessage());
        }
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
