package mobile.advert.create.real.estate;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.awt.event.InputEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Building {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {

        setUpDriver();
        try {
            Thread.sleep(2000);
            saveModal();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(2000);
            clickRealEstate();
            Thread.sleep(2000);
            clickCreateAdvertButton();
            Thread.sleep(1000);
            chooseCategory();
            Thread.sleep(2000);
            clickForRentCategory();
            Thread.sleep(2000);
            titleInput();
            Thread.sleep(2000);
            enterDescription();
            Thread.sleep(2000);
            enterPrice();
            Thread.sleep(2000);
            clickBody();
            Thread.sleep(2000);
            scrollScreen(300);
            Thread.sleep(2000);
            //uploadPhotodnl();
            Thread.sleep(2000);
            scrollScreen(400);
            Thread.sleep(2000);
            clickNextButton2();
            Thread.sleep(2000);
            clickAddressInformation();
            Thread.sleep(2000);
            clickProvince();
            Thread.sleep(2000);
            clickDistrict();
            Thread.sleep(2000);
            clickNeighbourhood();
            Thread.sleep(2000);
            scrollScreen(1000);
            Thread.sleep(2000);
            clickNextButton3();
            Thread.sleep(2000);
            selectMapMobile();
            Thread.sleep(2000);
            clickVisibleContinueButton(driver);
            Thread.sleep(2000);
            photoselect();
            Thread.sleep(2000);
            clickNextButtonpreview();
            Thread.sleep(2000);
            buydopingtButton();
            Thread.sleep(2000);
            scrollScreen(1000);
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void saveModal () throws InterruptedException {
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.cssSelector("ion-button.button-outline"));
        button.click();
        Thread.sleep(2000);
    }

    public static void fillForm() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("btn-my-account"));
        loginButton.click();
        Thread.sleep(2000);

        WebElement login= driver.findElement(By.id("login-click"));
        login.click();
        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email'].native-input"));
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
        Thread.sleep(500);
    }

    public static void clickRealEstate()throws InterruptedException {
        WebElement btn = driver.findElement(By.cssSelector("ion-fab-button#btn-construct"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btn);
        js.executeScript("arguments[0].click();", btn);
    }

    public static void clickCreateAdvertButton()throws InterruptedException {
        WebElement realEstateItem = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//ion-item[contains(., 'Real Estate')]"))
        );
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", realEstateItem);
    }

    public static void chooseCategory() throws InterruptedException {
        WebElement item = driver.findElement(By.xpath("//ion-item[contains(., 'Building')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", item);
    }

    public static void clickForRentCategory()throws InterruptedException {
        WebElement item = driver.findElement(By.xpath("//ion-item[contains(., 'For Rent')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", item);
        Thread.sleep(500);
    }

    public static void titleInput() throws InterruptedException {
        WebElement input = driver.findElement(By.id("ion-input-2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", input);
        input.sendKeys("My Title");
        Thread.sleep(1000);
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
        Thread.sleep(500);
    }
    public static void clickBody()throws InterruptedException {
        WebElement body = driver.findElement(By.tagName("body"));
        new Actions(driver).moveToElement(body, 10, 10).click().perform();
        Thread.sleep(1000);
    }

    public static void clickNextButton2() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.id("btn-continue-details-advert"));
        nextButton.click();
    }

    public static void clickAddressInformation() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.id("btn-want-choose"));
        nextButton.click();
    }

    public static void clickProvince() throws InterruptedException {
        WebElement provinceSelect = driver.findElement(By.id("breakdown-selected-second"));
        provinceSelect.click();
        Thread.sleep(1000);
        String province = "Babil";
        WebElement provinceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-radio[normalize-space(text())='" + province + "']"))
        );
        provinceOption.click();
    }
    public static void clickDistrict() throws InterruptedException {
        WebElement districtDropdown = driver.findElement(By.id("breakdown-selected-third"));
        districtDropdown.click();
        Thread.sleep(1000);

        String district = "Al Hashimiya";
        WebElement provinceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-radio[normalize-space(text())='" + district + "']"))
        );
        provinceOption.click();
        Thread.sleep(500);

    }

    public static void clickNeighbourhood() throws InterruptedException {
        WebElement neighbourhoodDropdown = driver.findElement(By.id("breakdown-selected-forth"));
        neighbourhoodDropdown.click();
        Thread.sleep(2000);

        String neighbourhood = "Al Qasim";
        WebElement neighbourhoodOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-radio[normalize-space(text())='" + neighbourhood + "']")
        ));
        neighbourhoodOption.click();
        Thread.sleep(500);
    }

    public static void clickNextButton3() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.id("btn-continue-communication"));
        nextButton.click();
        Thread.sleep(1000);
    }

    public static void selectMapMobile() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement mapDiv = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("div[style*='z-index: 3'][style*='position: absolute']"))
        );
        Point location = mapDiv.getLocation();
        Dimension size = mapDiv.getSize();
        int centerX = location.getX() + size.getWidth() / 2;
        int centerY = location.getY() + size.getHeight() / 2;
        new Actions(driver).moveByOffset(centerX, centerY).click().perform();
        new Actions(driver).moveByOffset(-centerX, -centerY).perform();

        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-continue-address")));
        scrollScreen(300);
        try {
            nextButton.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
        }
        Thread.sleep(1000);
    }

    public static void clickVisibleContinueButton(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.id("btn-continue-communication")
        ));
        for (WebElement btn : buttons) {
            if (btn.isDisplayed() && btn.isEnabled()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

                return;
            }
        }
        throw new RuntimeException();
    }

    public static void photoselect() throws InterruptedException {
        WebElement selectButton = driver.findElement(By.id("btn-continue-photo-select"));
        selectButton.click();
        Thread.sleep(1000);

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[span[text()='set-address.alert-next-button']]")
        ));
        button.click();

    }
    public static void clickNextButtonpreview() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.id("checkbox-accept-purchase-agreement"));
        nextButton.click();
        Thread.sleep(1000);

        driver.findElement(By.id("btn-continue")).click();
    }
    public static void buydopingtButton() throws InterruptedException {
        WebElement buydoping = driver.findElement(By.id("btn-offer-buy"));
        buydoping.click();
        Thread.sleep(1000);

        driver.findElement(By.id("btn-return-home-page")).click();
    }


    public static void scrollScreen(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public static void clickElement(WebElement element) {
        try {
            element.click();
        } catch (ElementNotInteractableException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
