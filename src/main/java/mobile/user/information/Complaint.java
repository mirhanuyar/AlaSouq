package mobile.user.information;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Complaint {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args)throws InterruptedException {
        setUpDriver();
        try {
            saveModal();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
            clickSvgElement();
            Thread.sleep(1000);
            clickItemByText("Konut");
            Thread.sleep(1000);
            emlak();
            Thread.sleep(1000);
            clickAdvert();
            Thread.sleep(1000);
            sendComplaint(driver);
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void clickItemByText(String text) throws InterruptedException {
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

    public static void clickSvgElement()throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = driver.findElement(By.cssSelector(".logo.ios.hydrated"));
        icon.click();
        Thread.sleep(1000);
        }


    public static void emlak() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = driver.findElement(
                By.xpath("//ion-col[@id='category-selected']//h3[text()='Real Estate']")
        );

        element.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void clickAdvert() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement listAllAdsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-list-all-ads")));
        listAllAdsBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("advert-container")));
        Thread.sleep(1000);

        List<WebElement> adverts = driver.findElements(By.className("advert-container"));

        for (int i = 0; i < adverts.size(); i++) {
            try {
                WebElement advert = adverts.get(i);
                wait.until(ExpectedConditions.elementToBeClickable(advert)).click();
                Thread.sleep(1000);

                WebElement complaintButton = driver.findElement(By.id("advert-complaint-link"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", complaintButton);
                Thread.sleep(500);

                wait.until(ExpectedConditions.elementToBeClickable(complaintButton)).click();
                Thread.sleep(500);

                try {
                    WebElement complaintOption = wait.until(ExpectedConditions.elementToBeClickable(
                            By.id("radio-complaint-item")));
                    complaintOption.click();
                } catch (Exception e) {
                    System.out.println("Şikayet seçeneği bulunamadı: " + e.getMessage());

                }
                Thread.sleep(500);

                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("document.querySelector('#ion-input-2').value='Bu ilan yanlış kategoriye eklenmiş.';");



                } catch (Exception e) {
                    System.out.println("Şikayet açıklaması yazılamadı: " + e.getMessage());
                }
                Thread.sleep(1000);

                try {
                    WebElement overlay = driver.findElement(By.className("item-native"));
                    if (overlay.isDisplayed() && overlay.isEnabled()) {
                        overlay.click();
                        Thread.sleep(500);
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Overlay bulunamadı, skip edildi.");
                }

                break;

            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element hatası, ilan listesi yenileniyor: " + i);
                i--;
            } catch (TimeoutException | NoSuchElementException e) {
                System.out.println("Timeout veya element yok, diğer ilana geçiliyor: " + i);

                try {
                    WebElement body = driver.findElement(By.tagName("body"));
                    new Actions(driver).moveToElement(body, 10, 10).click().perform();
                    Thread.sleep(1000);

                    driver.navigate().back();
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("advert-container")));
                    Thread.sleep(500);
                } catch (Exception ex) {
                    System.out.println("Geri dönüş sırasında hata: " + ex.getMessage());
                }

            } catch (Exception e) {
                System.out.println("Beklenmeyen hata: " + e.getMessage());

                try {
                    WebElement body = driver.findElement(By.tagName("body"));
                    new Actions(driver).moveToElement(body, 10, 10).click().perform();
                    Thread.sleep(1000);

                    driver.navigate().back();
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("advert-container")));
                    Thread.sleep(500);
                } catch (Exception ex) {
                    System.out.println("Geri dönüş sırasında hata: " + ex.getMessage());
                }
            }
        }
    }

    public static void sendComplaint(WebDriver driver) {
        WebElement sendButton = driver.findElement(By.id("btn-complaint-send"));
        if (!sendButton.isEnabled() || !sendButton.isDisplayed()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
        } else {
            sendButton.click();
        }
    }



}
