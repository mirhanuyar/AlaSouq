package web.advert.create.real.estate;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class Land {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickSaveButton();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            backPage();
            Thread.sleep(2000);
            clickCreateAdvertButton();
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
            chooseCurrency();
            Thread.sleep(2000);
            //clickAvailableForViewingOption();
            Thread.sleep(2000);
            //selectAvailableForViewingOption();
            Thread.sleep(2000);
            scrollScreen(500);
            Thread.sleep(2000);
            clickProvince();
            Thread.sleep(2000);
            clickDistrict();
            Thread.sleep(2000);
            clickNeighbourhood();
            Thread.sleep(2000);
            selectMap();
            Thread.sleep(2000);
            scrollScreen(800);
            Thread.sleep(2000);
            clickAdCreateConfirmationCheckbox();
            Thread.sleep(2000);
            clickNextButton();
            Thread.sleep(2000);
            uploadPhoto();
            Thread.sleep(2000);
            scrollScreen(400);
            Thread.sleep(2000);
            clickNextButton2();
            Thread.sleep(2000);
            scrollScreen(300);
            Thread.sleep(2000);
            clickNextButton3();
            Thread.sleep(2000);
            scrollScreen(300);
            Thread.sleep(2000);
            clickBuyDopingButton();


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/");
    }

    public static void clickSaveButton() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
        saveButton.click();
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

    public static void backPage() throws InterruptedException {
        driver.navigate().back();
    }

    public static void clickCreateAdvertButton() throws InterruptedException {
        WebElement createAdvert = driver.findElement(By.id("btn-post-free-ad"));
        createAdvert.click();
    }

    public static void clickRealEstate() throws InterruptedException {
        WebElement realEstateCard = driver.findElement(By.id("base-category-1"));
        realEstateCard.click();
    }

    public static void chooseCategory() throws InterruptedException {
        WebElement buildingCategory = driver.findElement(By.id("sub-category-land"));
        buildingCategory.click();
    }

    public static void clickForRentCategory() {
        WebElement forRentCategory = driver.findElement(By.id("sub-category-land-for-rent-land"));
        forRentCategory.click();
    }


    public static void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.id("btn-continue-selection"));
        continueButton.click();
    }

    public static void titleInput() throws InterruptedException {
        WebElement title = driver.findElement(By.id("value-change"));
        title.click();
        Thread.sleep(500);
        title.clear();
        title.sendKeys("TEST");
    }

    public static void enterDescription() throws InterruptedException {
        WebElement editor = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
        editor.click();
        Thread.sleep(500);
        editor.sendKeys("TEST");
    }

    public static void enterPrice() throws InterruptedException {
        WebElement price = driver.findElement(By.id("value-num"));
        price.sendKeys("10000");
    }

    public static void chooseCurrency() throws InterruptedException {
        WebElement selectDropdown = driver.findElement(By.id("currency"));
        selectDropdown.click();
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath("//span[text()='TRY']"));
        option.click();
    }

    public static void clickAvailableForViewingOption() throws InterruptedException {
        WebElement selectDropdown = driver.findElement(By.id("facet-available-for-viewing-via-vid-call"));
        selectDropdown.click();

        Thread.sleep(2000);
    }

    public static void selectAvailableForViewingOption() throws InterruptedException {
        WebElement yesButton = driver.findElement(By.id("ad6b85888305-1"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", yesButton);
    }

    public static void clickProvince() throws InterruptedException {

        WebElement provinceSelect = driver.findElement(By.id("secondBreakdown"));
        provinceSelect.click();
        Thread.sleep(2000);

        String province = "Babil";
        WebElement provinceOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ng-option ng-star-inserted']//span[text()='" + province + "']")
        ));
        provinceOption.click();
    }

    public static void clickDistrict() throws InterruptedException {
        WebElement districtDropdown = driver.findElement(By.id("thirdBreakdown"));
        districtDropdown.click();
        Thread.sleep(1000);

        String district = "Al Hashimiya";
        WebElement districtOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'ng-option')]//span[text()='" + district + "']")
        ));
        districtOption.click();
    }

    public static void clickNeighbourhood() throws InterruptedException {
        WebElement neighbourhoodDropdown = driver.findElement(By.id("fourthBreakdown"));
        neighbourhoodDropdown.click();
        Thread.sleep(2000);

        String neighbourhood = "Al Qasim";
        WebElement neighbourhoodOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ng-option ng-star-inserted']//span[text()='" + neighbourhood + "']")
        ));
        neighbourhoodOption.click();
    }

    public static void selectMap() throws InterruptedException {
        WebElement mapDiv = driver.findElement(By.cssSelector("div[style*='z-index: 3'][style*='position: absolute']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mapDiv).click().perform();
    }

    public static void clickAdCreateConfirmationCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("advert-create-confirmation"));
        checkbox.click();
    }

    public static void clickNextButton() throws InterruptedException {
        WebElement next = driver.findElement(By.id("advert-next-button"));
        next.click();
    }

    public static void uploadPhoto() throws InterruptedException, AWTException {
        String[] photoNames = {"download.jpeg", "download (1).jpeg", "download (2).jpeg"};
        String basePath = "/Users/mirhanuyar/IdeaProjects/AlaSouq/src/main/java/web/_images/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addImageButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-new-image")));
        addImageButton.click();

        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type='file']")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display = 'block';", fileInput);

        for (String name : photoNames) {
            String filePath = basePath + name;
            fileInput.sendKeys(filePath);
            Thread.sleep(1000);
        }

        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }

    public static void clickNextButton2() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        nextButton.click();
    }

    public static void clickNextButton3() throws InterruptedException {
        WebElement nextButton = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        nextButton.click();
    }

    public static void clickBuyDopingButton() throws InterruptedException {
        WebElement buyButton = driver.findElement(By.xpath("//button[contains(text(),'Buy')]"));
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
