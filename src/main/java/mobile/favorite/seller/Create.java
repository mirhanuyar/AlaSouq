package mobile.favorite.seller;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Create {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static List<String> favoriteAdverts = new ArrayList<>();

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
            clickItemByText("Konut");
            Thread.sleep(2000);
            clickButtonHome();
            Thread.sleep(2000);
            emlak();
            Thread.sleep(2000);
            favoriyeEklemeIslemi();
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clickItemByText(String text) {
        List<WebElement> listItems = driver.findElements(By.tagName("ion-item"));
        for (WebElement item : listItems) {
            if (item.getText().contains(text)) {
                item.click();
                break;
            }
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

    public static void clickButtonHome()throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement element = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("ion-tab-button#btn-search"))
            );
            element.click();

        } catch (TimeoutException e) {
            System.out.println("Hata: 'btn-search' elementi bulunamadı!");
        }
        Thread.sleep(1000);
    }


    public static void emlak() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> categories = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ion-col#category-selected"))
        );
        if (!categories.isEmpty()) {
            WebElement firstCategory = categories.get(0);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstCategory);
            firstCategory.click();
        }

    }

    public static void favoriyeEklemeIslemi() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement listAllAdsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-list-all-ads")));
        listAllAdsBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("advert-container")));
        Thread.sleep(1000);

        List<WebElement> adverts = driver.findElements(By.className("advert-container"));

        for (int i = 0; i < adverts.size(); i++) {
            try {
                adverts = driver.findElements(By.className("advert-container"));
                WebElement advert = adverts.get(i);

                wait.until(ExpectedConditions.elementToBeClickable(advert)).click();
                System.out.println(i + ". ilana tıklandı.");
                Thread.sleep(1000);

                WebElement overlay = driver.findElement(By.className("seller"));
                overlay.click();
                Thread.sleep(500);


                try {
                    WebElement favSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("span.action-sheet-button-inner.sc-ion-action-sheet-ios")));

                    WebElement favButton = favSpan.findElement(By.xpath(".."));
                    wait.until(ExpectedConditions.elementToBeClickable(favButton)).click();
                    System.out.println("Favori butonuna tıklandı, işlem durduruluyor.");
                    break;

                } catch (TimeoutException e) {

                    WebElement body = driver.findElement(By.tagName("body"));
                    new Actions(driver).moveToElement(body, 10, 10).click().perform();

                    System.out.println("Satıcı veya favori butonu bulunamadı, diğer ilana geçiliyor.");
                    Thread.sleep(1000);
                    driver.navigate().back();
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("advert-container")));
                    Thread.sleep(500);
                }


            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element hatası, ilan listesi yenileniyor: " + i);
                i--;
            } catch (TimeoutException | NoSuchElementException e) {
                System.out.println("Timeout veya element yok, diğer ilana geçiliyor: " + i);
                driver.navigate().back();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("advert-container")));
            }
        }


    }



    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        Thread.sleep(1000);
    }

}
