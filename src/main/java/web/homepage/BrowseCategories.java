package web.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BrowseCategories {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(2000);
            clickSaveAppSettings();
            Thread.sleep(2000);
            clickUserIcon();
            Thread.sleep(2000);
            fillForm();
            Thread.sleep(2000);
            signIn();
            Thread.sleep(2000);
            homePage();
            Thread.sleep(2000);
            clickRealEstate();
            Thread.sleep(2000);
            clickCommercial();
            Thread.sleep(2000);
            clickLand();
            Thread.sleep(2000);
            clickHousingDevelopments();
            Thread.sleep(2000);
            clickBuilding();
            Thread.sleep(2000);
            clickTourismFacilities();
            Thread.sleep(2000);
            scrollToElement(By.id("li-child-touristic-rentals"));
            Thread.sleep(2000);
            clickTouristicRentals();
            Thread.sleep(2000);
            clickVehiclesCars();
            Thread.sleep(2000);
            clickVehicleParts();
            Thread.sleep(2000);
            clickLinkMotherBaby();
            Thread.sleep(2000);
            scrollToElement4(By.id("link-mother-baby"));
            Thread.sleep(2000);
            clickLinkEngineeringVehicle();
            Thread.sleep(2000);
            clickRepairAndDecoration();
            Thread.sleep(2000);
            scrollToElement2(By.id("link-tutors-music-instruments"));
            Thread.sleep(2000);
            clickSchoolCollege();
            Thread.sleep(2000);
            clickPrimaryEducation();
            Thread.sleep(2000);
            clickForeignLanguages();
            Thread.sleep(2000);
            clickTutorsComputer();
            Thread.sleep(2000);
            clickTutorsDriving();
            Thread.sleep(2000);
            clickTutorsSports();
            Thread.sleep(2000);
            clickTutorsArt();
            Thread.sleep(2000);
            clickTutorsDance();
            Thread.sleep(2000);
            clickTutorsMusicInstruments();
            Thread.sleep(2000);
            clickTutorsTheaterActing();
            Thread.sleep(2000);
            scrollToElement3(By.id("link-advocacy-legal-concultancy-jobs"));
            Thread.sleep(2000);
            clickTutorsPersonalGrowth();
            Thread.sleep(2000);
            clickTutorsProfessionalCourses();
            Thread.sleep(2000);
            clickTutorsSpecialEducation();
            Thread.sleep(2000);
            clickTutorsChildDevelopment();
            Thread.sleep(2000);
            clickTutorsDiction();
            Thread.sleep(2000);
            clickTutorsPhotography();
            Thread.sleep(2000);
            clickLegalConsultancy();
            Thread.sleep(2000);
            clickBabysittersNurses();
            Thread.sleep(2000);
            clickPatientAndElderlyCare();
            Thread.sleep(2000);
            clickCleanersHousekeepers();
            Thread.sleep(2000);
            clickPets();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/tr/");
        driver.manage().window().maximize();
    }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebElement save = driver.findElement(By.id("btn-default-app-settings"));
        save.click();
    }

    public static void clickUserIcon() throws InterruptedException {
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("li.mobile-cart i.ri-user-line")));
        userIcon.click();
        Thread.sleep(1000);
    }

    public static void fillForm() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("yakup.user@solidsoft.com.tr");
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

    public static void homePage() throws InterruptedException {
        WebElement home = driver.findElement(By.id("home-link"));
        home.click();
    }

    public static void clickRealEstate() throws InterruptedException {
        driver.findElement(By.id("link-real-estate-residental")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickCommercial() throws InterruptedException {
        driver.findElement(By.id("link-commercial")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickLand() throws InterruptedException {
        driver.findElement(By.id("link-land")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickHousingDevelopments() throws InterruptedException {
        driver.findElement(By.id("link-real-estate-housing-developments")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickBuilding() throws InterruptedException {
        driver.findElement(By.id("link-buildings")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTourismFacilities() throws InterruptedException {
        driver.findElement(By.id("link-real-estate-tourism-facilities")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickTouristicRentals() throws InterruptedException {
        driver.findElement(By.id("link-touristic-rentals")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickVehiclesCars() throws InterruptedException {
        driver.findElement(By.id("link-vehicles-cars")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickVehicleParts() throws InterruptedException {
        driver.findElement(By.id("link-vehicles-cars")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickLinkMotherBaby() throws InterruptedException {
        driver.findElement(By.id("link-mother-baby")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void scrollToElement4(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickLinkEngineeringVehicle() throws InterruptedException {
        driver.findElement(By.id("link-engineering-vehicle")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickRepairAndDecoration() throws InterruptedException {
        driver.findElement(By.id("link-interior-repairs-and-decoration-services-experts")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void scrollToElement2(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickSchoolCollege() throws InterruptedException {
        driver.findElement(By.id("link-tutors-high-school-college")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickPrimaryEducation() throws InterruptedException {
        driver.findElement(By.id("link-tutors-primary-education")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickForeignLanguages() throws InterruptedException {
        driver.findElement(By.id("link-tutors-foreign-languages")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsComputer() throws InterruptedException {
        driver.findElement(By.id("link-tutors-computer")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsDriving() throws InterruptedException {
        driver.findElement(By.id("link-tutors-driving")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsSports() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-sports")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsArt() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-art")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsDance() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-dance")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsMusicInstruments() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-music-instruments")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsTheaterActing() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-theater-acting")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void scrollToElement3(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static void clickTutorsPersonalGrowth() throws InterruptedException {
        driver.findElement(By.id("link-tutors-personal-growth")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsProfessionalCourses() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-professional-courses")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsSpecialEducation() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-special-education")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsChildDevelopment() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-child-development-and-education")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsDiction() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-diction")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickTutorsPhotography() throws InterruptedException {
        driver.findElement(By.id("li-child-tutors-photography")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickLegalConsultancy() throws InterruptedException {
        driver.findElement(By.id("link-advocacy-legal-concultancy-jobs")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickBabysittersNurses() throws InterruptedException {
        driver.findElement(By.id("link-babysitters-and-nurses")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickPatientAndElderlyCare() throws InterruptedException {
        driver.findElement(By.id("link-patient-and-elderly-care")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickCleanersHousekeepers() throws InterruptedException {
        driver.findElement(By.id("li-child-cleaners-housekeepers")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickPets() throws InterruptedException {
        driver.findElement(By.id("link-pets-livestock-pets")).click();
        Thread.sleep(700);
        driver.navigate().back();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }
}
