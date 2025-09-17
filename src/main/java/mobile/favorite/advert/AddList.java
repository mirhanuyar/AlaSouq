package mobile.favorite.advert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mobile.categories.CategoryControls.clickSearch;
import static mobile.favorite.advert.Delete.clickAdvert;
import static mobile.favorite.advert.Notifications.fillForm;
import static mobile.favorite.advert.Notifications.submitForm;
import static mobile.message.ChatWithAdvertOwner.clickAllAds;
import static mobile.message.ChatWithAdvertOwner.clickCategories;
import static web.favorite.search.ControlSearch.clickFavorite;

public class AddList {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static List<String> favoriteAdverts = new ArrayList<>();

    public static void main(String[] args)throws InterruptedException {

        setUpDriver();
        try {
            saveModal();
            Thread.sleep(2000);

            fillForm();
            Thread.sleep(2000);

            submitForm();
            Thread.sleep(2000);

            clickSearch();
            Thread.sleep(2000);

            clickCategories();
            Thread.sleep(2000);

            clickAllAds();
            Thread.sleep(2000);

            clickAdvert();
            Thread.sleep(2000);

            clickFavorite();
            Thread.sleep(2000);

            scrollToElement(By.cssSelector("#add-new-list"));

            createNewFavoriteList();
            Thread.sleep(2000);

            newFavoriteListName();

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


        public static void fillForm () throws InterruptedException {
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

            WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
            currentPasswordField.sendKeys("admin");
            Thread.sleep(3000);
        }

        public static void submitForm () throws InterruptedException {
            WebElement submitIcon = driver.findElement(By.id("btn-lgn-email"));
            submitIcon.click();
            Thread.sleep(2000);
        }

        public static void clickSearch () throws InterruptedException {
            WebElement search = driver.findElement(By.id("btn-search"));
            search.click();
        }

        public static void clickCategories () throws InterruptedException {
            WebElement realEstateElement = driver.findElement(By.xpath("//ion-col[@id='category-selected']//h3[text()='Real Estate']"));
            realEstateElement.click();
        }

        public static void clickAllAds () throws InterruptedException {
            WebElement allAds = driver.findElement(By.id("btn-list-all-ads"));
            allAds.click();
        }

        public static void clickAdvert () throws InterruptedException {
            WebElement advert = driver.findElement(By.xpath("//h3[text()='208 M2 ARSA ÜZERİNDE SIFIRLANMIŞ 2+1 BAHÇELİ MÜSTAKİL']"));
            advert.click();

            List<WebElement> clickadvert = driver.findElements(By.className("advert-container"));
            clickadvert.get(0).click();
            Thread.sleep(500);

        }

        public static void clickFavorite () throws InterruptedException {
            WebElement favorite = driver.findElement(By.id("open-favorite-modal"));
            favorite.click();
        }

    public static void createNewFavoriteList() throws InterruptedException {
        WebElement icon = driver.findElement(By.cssSelector("ion-icon[name='add-circle-outline']"));
        WebElement clickableItem = icon.findElement(By.xpath("./ancestor::ion-item[1]"));
        clickableItem.click();
        Thread.sleep(500);
    }

    public static void newFavoriteListName() throws InterruptedException {
        WebElement input = driver.findElement(By.cssSelector("ion-input#new-favorite-list-name input.native-input"));
        input.click();
        input.sendKeys("Test2");
        Thread.sleep(1000);
        WebElement body = driver.findElement(By.tagName("body"));
        body.click();
        Thread.sleep(1000);
        WebElement save = driver.findElement(By.id("btn-save-favorite-list"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
        save.click();

    }


    public static void clickElement (By locator){
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            try {
                element.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        }

        public static void scrollToElement (By locator){
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
        }
    }
