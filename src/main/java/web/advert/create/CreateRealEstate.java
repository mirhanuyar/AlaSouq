package web.advert.create;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;


public class CreateRealEstate {
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
            scrollToElement(By.id("value-num"));
            Thread.sleep(2000);
            chooseCurrency();
            Thread.sleep(2000);
            selectAvailableForViewingOption();
            Thread.sleep(2000);
            scrollToElement2(By.xpath("//h5[span[text()='Contact Information']]"));
            Thread.sleep(2000);
            clickProvince();
            Thread.sleep(2000);
            clickDistrict();
            Thread.sleep(2000);
            clickNeighbourhood();
            Thread.sleep(2000);
            selectMap();
            Thread.sleep(2000);
            scrollToElement3(By.xpath("//span[text()='Display Name']"));
            Thread.sleep(2000);
            clickAdCreateConfirmationCheckbox();
            Thread.sleep(2000);
            clickNextButton();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/");
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

    public static void clickCreateAdvertButton() throws InterruptedException {
        WebElement createAdvert = driver.findElement(By.cssSelector("a.advert-create-button"));
        createAdvert.click();
    }

    public static void clickRealEstate() throws InterruptedException {
        WebElement realEstateCard = driver.findElement(By.xpath("//span[text()='Real Estate']"));
        realEstateCard.click();
    }

    public static void chooseCategory() throws InterruptedException {
        WebElement buildingCategory = driver.findElement(By.xpath("//li[text()=' Building ']"));
        buildingCategory.click();
    }

    public static void clickForRentCategory() {
        WebElement forRentCategory = driver.findElement(By.xpath("//li[normalize-space(text())='For Rent']"));
        forRentCategory.click();
    }

    /*public static void clickForSaleCategory() {
        WebElement forSaleCategory = driver.findElement(By.xpath("//li[normalize-space(text())='For Sale']"));
        forSaleCategory.click();
    }*/

    public static void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space(text())='Continue']"));
        continueButton.click();
    }

    public static void titleInput() throws InterruptedException {
        WebElement title = driver.findElement(By.id("value-change"));
        title.click();
        Thread.sleep(500);
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

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void chooseCurrency() throws InterruptedException {
        WebElement selectDropdown = driver.findElement(By.id("currency"));
        selectDropdown.click();
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath("//span[text()='TRY']"));
        option.click();
    }

    public static void selectAvailableForViewingOption() throws InterruptedException {
        WebElement selectDropdown = driver.findElement(By.id("facet-undefined"));
        selectDropdown.click();

        Thread.sleep(2000);

        WebElement yesButton = driver.findElement(By.xpath("//div[@role='option' and .//span[text()='Yes']]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yesButton).click().perform();

        /*WebElement noButton = driver.findElement(By.xpath("//div[@role='option' and .//span[text()='Yes']]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yesButton).click().perform();*/
    }

    public static void scrollToElement2(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
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

        String neighbourhood = "Al Madhatiya";
        WebElement neighbourhoodOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ng-option ng-star-inserted']//span[text()='" + neighbourhood + "']")
        ));
        neighbourhoodOption.click();
    }

    public static void selectMap() throws InterruptedException {
        System.out.println("Haritada bir alan seçin ve devam etmek için enter tuşuna basın");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void scrollToElement3(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickAdCreateConfirmationCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("ad-create-confirmation"));
        checkbox.click();
    }

    public static void clickNextButton() throws InterruptedException {
        WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        next.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
