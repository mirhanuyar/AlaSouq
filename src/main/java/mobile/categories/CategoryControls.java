package mobile.categories;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryControls {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args)throws InterruptedException{
        setUpDriver();

        try {
            saveModal();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
            clickSearch();
            Thread.sleep(1000);
            searchMultipleCategories();
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



    public static void clickSearch() throws InterruptedException {
      WebElement clickSearch = driver.findElement(By.id("icon-search-outline"));
      clickSearch.click();
      Thread.sleep(1000);

    }

   public static void searchMultipleCategories() throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


       List<String> realEstateCategories = Arrays.asList(
               "Real Estate", "Residental", "For Rent", "Datached House", "Mansion",
               "Office of Yali", "Summer Villa", "Cooperative", "Land", "Commercial",
               "Housing Developments", "Flat", "Residence", "Villa", "Flat",
               "Residence", "Villa", "Building", "Tourism Facilities", "Flats",
               "Residence", "Datached Houses", "Villas", "Timeshares", "Touristic Rentals"
       );

       for (String category : realEstateCategories) {
           WebElement clickSearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-search-advert-no")));
           clickSearch.click();
           Thread.sleep(2000);

           WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchbar-input.sc-ion-searchbar-ios")));
           input.clear();
           input.sendKeys(category);
           Thread.sleep(3000);
       }

       List<String> carsCategories = Arrays.asList("Abarth", "Aiways", "Aixam", "Alfa Romeo", "ALPINA", "Alpine", "ARI Motors",
               "Aston Martin", "Audi", "Bentley", "BMW", "Borgward", "brand", "Brilliance", "Bugatti", "BYD", "Cadillac", "Casalini",
               "Chevrolet", "Chrysler", "Citroen", "CUPRA", "Dacia", "Daewoo", "Daihatsu", "Datsun", "Dodge", "DS Automobiles", "e.GO Mobile",
               "Elaris", "Electric Brands", "Estrima", "Ferrari", "Fiat", "Fisker", "Ford", "Genesis", "GWM", "HiPhi", "Honda", "Hummer",
               "Hyundai", "Hyundai Precision", "Ineos", "Infiniti", "Isuzu", "Jaguar", "Jeep", "Kia", "Lada", "Lamborghini", "Lancia",
               "Land Rover", "Lexus", "Ligier", "Lotus", "Lucid", "Lynk & Co", "Maserati", "Maxus", "Maybach", "Mazda", "McLaren", "Mercedes-Benz",
               "MG", "MINI", "Micro", "Microcar", "Mitsubishi", "Morgan", "NIO", "Nissan", "Opel", "ORA", "Peugeot", "Polestar", "Porsche", "Proton",
               "Renault", "Rolls-Royce", "Rover", "Saab", "SEAT", "SERES", "Skoda", "Smart", "Sono Motors", "SsangYong", "Subaru", "Suzuki", "Talbot",
               "Tesla", "Togg", "Toyota", "Trabant", "TYN-e", "VinFast", "Volvo", "VW", "Wartburg", "WEY", "Wiesmann", "XPeng", "Yugo", "ZEEKR"

       );

       for (String category : carsCategories) {
           WebElement clickSearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-search-advert-no")));
           clickSearch.click();
           Thread.sleep(2000);

           WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchbar-input.sc-ion-searchbar-ios")));
           input.clear();
           input.sendKeys(category);
           Thread.sleep(3000);
       }

       List<String> otherCategories = Arrays.asList("Vehicle Parts",
               "Used & Brand New Items",
               "Machinery",
               "Services & Experts",
               "Mother & Baby",
               "Engineering Vehicle",
               "Interior Repairs and Decoration Jobs",
               "In-home Help",
               "Pets & Livestock",
               "Advocacy & Legal Consultancy",
               "Babysitters and Nurses",
               "Pets",
               "Patient and Elderly Care",
               "Cleaners & Housekeepers");

       for (String category : otherCategories) {
           WebElement clickSearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-search-advert-no")));
           clickSearch.click();
           Thread.sleep(2000);

           WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchbar-input.sc-ion-searchbar-ios")));
           input.clear();
           input.sendKeys(category);
           Thread.sleep(3000);
       }
       List<String> TutorsTutors = Arrays.asList("Vehicle Parts",
               "Used & Brand New Items",
               "Machinery",
               "Services & Experts",
               "Mother & Baby",
               "Engineering Vehicle",
               "Interior Repairs and Decoration Jobs",
               "In-home Help",
               "Pets & Livestock",
               "Advocacy & Legal Consultancy",
               "Babysitters and Nurses",
               "Pets",
               "Patient and Elderly Care",
               "Cleaners & Housekeepers");

       for (String category : TutorsTutors) {
           WebElement clickSearch = wait.until(ExpectedConditions.elementToBeClickable(By.id("filter-search-advert-no")));
           clickSearch.click();
           Thread.sleep(2000);

           WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".searchbar-input.sc-ion-searchbar-ios")));
           input.clear();
           input.sendKeys(category);
           Thread.sleep(3000);

       }
   }
}