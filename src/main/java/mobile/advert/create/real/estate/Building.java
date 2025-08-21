package mobile.advert.create.real.estate;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class Building {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickSaveAppSettings();
            Thread.sleep(2000);
            Thread.sleep(2000);
            clickCreateAdvertButton();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            clickRealEstate();
            Thread.sleep(2000);
            chooseCategory();
            Thread.sleep(2000);
            clickForRentCategory();
            Thread.sleep(2000);
            clickContinueButton();
            Thread.sleep(2000);
            titleInput();
            Thread.sleep(2000);
            enterDescription();
            Thread.sleep(2000);
            enterPrice();
            Thread.sleep(2000);
            scrollScreen(300);
            Thread.sleep(2000);
            //uploadPhotodnl();
            Thread.sleep(2000);
            scrollScreen(400);
            Thread.sleep(2000);
            clickNextButton2();
            Thread.sleep(2000);
            continueWithoutUploadingPhotos();
            Thread.sleep(2000);
            scrollScreen(1000);
            Thread.sleep(2000);
            clickNextButton3();
            Thread.sleep(2000);
            scrollScreen(1000);
            Thread.sleep(2000);
            clickBuyDopingButton();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 500);
        deviceMetrics.put("height", 800);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 14_0 like Mac OS X) " +
                "AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0 Mobile/15A372 Safari/604.1");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public static void openRegistrationPage() throws InterruptedException {
        driver.get("https://m.alasouq.com");
        driver.manage().window().fullscreen();
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//ion-button[text()='Default']"));
        button.click();
    }

    public static void clickCreateAdvertButton() throws InterruptedException {
        WebElement createAdvert = driver.findElement(By.id("btn-construct"));
        createAdvert.click();
    }

    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("yakup.user@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void signIn() throws InterruptedException {
        WebElement clickSignIn;
        clickSignIn = driver.findElement(By.id("btn-lgn-email"));
        clickSignIn.click();
        Thread.sleep(1000);
    }

    public static void clickRealEstate() throws InterruptedException {
        WebElement realEstateCard = driver.findElement(By.id("icon-chevron-forward-outline"));
        realEstateCard.click();
    }

    public static void chooseCategory() throws InterruptedException {
        WebElement item = driver.findElement(By.xpath("//ion-item[contains(., 'Building')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", item);
    }

    public static void clickForRentCategory() {
        WebElement item = driver.findElement(By.xpath("//ion-item[contains(., 'For Rent')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", item);
    }

    public static void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.id("btn-continue-selection"));
        continueButton.click();
    }


    public static void titleInput() throws InterruptedException {
        WebElement input = driver.findElement(By.id("ion-input-2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", input);
        input.sendKeys("My Title");
    }

    public static void enterDescription() throws InterruptedException {
        WebElement editor = driver.findElement(By.id("ion-input-4"));
        editor.click();
        Thread.sleep(500);
        editor.sendKeys("TEST");
    }

    public static void enterPrice() throws InterruptedException {
        WebElement price = driver.findElement(By.id("ion-input-3"));
        price.sendKeys("10000");
    }


    /*public static void uploadPhotodnl() throws InterruptedException, AWTException {
        String[] photoNames = {"download.jpeg", "download (1).jpeg", "download (2).jpeg"};
        String basePath = "src/main/java/web/_images/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addImageButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-new-image")));
        addImageButton.click();

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible'; arguments[0].style.opacity = 1;", fileInput);

        for (String name : photoNames) {
            String filePath = Paths.get(basePath + name).toAbsolutePath().toString();
            System.out.println("Yükleniyor: " + filePath);
            fileInput.sendKeys(filePath);
            Thread.sleep(1000);
        }

        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

    }*/

    public static void clickNextButton2() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.id("btn-continue-details-advert"));
        nextButton.click();
    }

    public static void continueWithoutUploadingPhotos() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.id("confirm_yes_btn"));
        nextButton.click();
    }

    public static void clickNextButton3() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.xpath("//button[contains(text(),'İleri')]"));
        nextButton.click();
    }

    public static void clickBuyDopingButton() throws InterruptedException {
        WebElement buyButton = driver.findElement(By.xpath("//button[contains(text(),'Satın Al')]"));
        buyButton.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

    public static void scrollScreen(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
}
