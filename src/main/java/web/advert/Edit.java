package web.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;


public class Edit {
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
            clickMyAdverts();
            Thread.sleep(2000);
            clickActions();
            Thread.sleep(2000);
            clickEdit();
            Thread.sleep(2000);
            clickTitleEdit();
            Thread.sleep(2000);
            scrollToElement(By.id("value-num"));
            Thread.sleep(2000);
            clickDescription();
            Thread.sleep(2000);
            scrollToElement2(By.id("facet-undefined"));
            Thread.sleep(2000);
            clickPrice();
            Thread.sleep(2000);
            chooseCurrency();
            Thread.sleep(2000);
            clickBalcony();
            Thread.sleep(2000);
            clickNumberBathrooms();
            Thread.sleep(2000);
            clickHeating();
            Thread.sleep(2000);
            clickNumberRooms();
            Thread.sleep(2000);
            scrollToElement3(By.xpath("//label[contains(text(), 'Number of Rooms')]"));
            Thread.sleep(2000);
            clickFloorNumber();
            Thread.sleep(2000);
            scrollToElement4(By.xpath("//label[text()='From']/following-sibling::ng-select"));
            Thread.sleep(2000);
            m2Gross();
            Thread.sleep(2000);
            m2Net();
            Thread.sleep(2000);
            clickVideoCall();
            Thread.sleep(2000);
            clickProvince();
            Thread.sleep(2000);
            clickDistrict();
            Thread.sleep(2000);
            clickNeighbourhood();
            Thread.sleep(2000);
            scrollToElement5(By.xpath("//span[text()='Display Name']"));
            Thread.sleep(2000);
            selectMap();
            Thread.sleep(2000);
            clickAdCreateConfirmationCheckbox();
            Thread.sleep(2000);
            clickNextButton();
            Thread.sleep(2000);
            scrollToElement6(By.xpath("//button[contains(text(), 'Next')]"));
            Thread.sleep(2000);
            addImage();
            Thread.sleep(2000);
            clickNextButton2();
            Thread.sleep(2000);
            scrollToElement7(By.xpath("//button[contains(text(),'Next')]"));
            Thread.sleep(2000);
            clickNextButton3();
            Thread.sleep(2000);
            scrollToElement8(By.xpath("//button[contains(text(), 'Buy')]"));
            Thread.sleep(2000);
            clickBuyButton();
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
        emailField.sendKeys("onder.user@solidsoft.com.tr");
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

    public static void clickMyAdverts() throws InterruptedException {
        WebElement myAdverts = driver.findElement(By.xpath("//a[contains(@href, '/account/my-adverts')]"));
        myAdverts.click();
    }

    public static void clickActions() throws InterruptedException {
        WebElement action = driver.findElement(By.xpath("//button[contains(@class, 'dropdown-toggle') and contains(@class, 'my-advert-action-button')]"));
        action.click();
    }

    public static void clickEdit() throws InterruptedException {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@class, 'dropdown-item') and .//span[text()='Edit']]")));
        editButton.click();
    }

    public static void clickTitleEdit() throws InterruptedException {
        WebElement title = driver.findElement(By.id("value-change"));
        title.click();
        Thread.sleep(400);
        title.clear();
        title.sendKeys("TEST");
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickDescription() throws InterruptedException {
        WebElement description = driver.findElement(By.cssSelector("div.ql-editor"));
        description.click();
        Thread.sleep(400);
        description.clear();
        description.sendKeys("TEST");
    }

    public static void scrollToElement2(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickPrice() throws InterruptedException {
        WebElement price = driver.findElement(By.id("value-num"));
        Thread.sleep(200);
        price.clear();
        price.sendKeys("10000");
    }

    public static void chooseCurrency() throws InterruptedException {
        WebElement selectDropdown = driver.findElement(By.id("currency"));
        selectDropdown.click();
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath("//span[text()='TRY']"));
        option.click();
    }

    public static void clickBalcony() throws InterruptedException {
        WebElement ngSelect = driver.findElement(By.id("facet-undefined"));
        ngSelect.click();
        Thread.sleep(500);

        WebElement option = driver.findElement(By.xpath("//span[contains(text(), 'Available')]"));
        option.click();
    }

    public static void clickNumberBathrooms() throws InterruptedException {
        WebElement label = driver.findElement(By.xpath("//label[contains(text(), 'Number of Bathrooms')]"));
        WebElement ngSelect = label.findElement(By.xpath("./following-sibling::ng-select"));
        ngSelect.click();

        WebElement option = driver.findElement(By.xpath("//span[contains(text(), '2')]"));
        option.click();
    }

    public static void clickHeating() throws InterruptedException {
        WebElement label = driver.findElement(By.xpath("//label[contains(text(), 'Heating')]"));
        WebElement ngSelect = label.findElement(By.xpath("./following-sibling::ng-select"));
        ngSelect.click();

        WebElement option = driver.findElement(By.xpath("//span[contains(text(), 'VRV')]"));
        option.click();
    }

    public static void clickNumberRooms() throws InterruptedException {
        WebElement label = driver.findElement(By.xpath("//label[contains(text(), 'Number of Rooms')]"));
        WebElement ngSelect = label.findElement(By.xpath("./following-sibling::ng-select"));
        ngSelect.click();

        WebElement option = driver.findElement(By.xpath("//span[contains(text(), '1+1')]"));
        option.click();
    }

    public static void scrollToElement3(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }


    public static void clickFloorNumber() throws InterruptedException {
        WebElement label = driver.findElement(By.xpath("//label[contains(text(), 'Floor Number')]"));
        WebElement ngSelect = label.findElement(By.xpath("./following-sibling::ng-select"));
        ngSelect.click();

        WebElement option = driver.findElement(By.xpath("//span[contains(text(), '27')]"));
        option.click();
    }

    public static void scrollToElement4(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void m2Gross() throws InterruptedException {
        WebElement grossInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='m² (Gross)']/following-sibling::input")
        ));
        grossInput.clear();
        grossInput.sendKeys("1200");
    }

    public static void m2Net() throws InterruptedException {
        WebElement netInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='m² (Net)']/following-sibling::input")
        ));
        netInput.clear();
        netInput.sendKeys("1100");
    }

    public static void clickVideoCall() throws InterruptedException {
        WebElement videoCallSelect = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(), 'Available for Viewing with Video Call')]/following-sibling::ng-select//div[contains(@class, 'ng-select-container')]")
        ));
        videoCallSelect.click();

        WebElement yesOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option']//span[text()='Yes']")
        ));
        yesOption.click();
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

    public static void scrollToElement5(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void selectMap() throws InterruptedException {
        System.out.println("Haritada bir alan seçin ve devam etmek için enter tuşuna basın");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void clickAdCreateConfirmationCheckbox() throws InterruptedException {
        WebElement checkbox = driver.findElement(By.id("ad-create-confirmation"));
        checkbox.click();
    }

    public static void clickNextButton() throws InterruptedException {
        WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        next.click();
    }

    public static void scrollToElement6(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void addImage() throws InterruptedException {
        System.out.println("Yeni bir fotoğraf ekleyin ve devam etmek için enter tuşuna basın");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void clickNextButton2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Next')]")
        ));
        nextButton.click();
    }

    public static void scrollToElement7(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickNextButton3() throws InterruptedException {
        WebElement next = driver.findElement(By.xpath("//button[contains(text(),'Next')]"));
        next.click();
    }

    public static void scrollToElement8(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickBuyButton() throws InterruptedException {
        WebElement buyButton = driver.findElement(By.cssSelector("button.btn.btn-STANDARD"));
        buyButton.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}