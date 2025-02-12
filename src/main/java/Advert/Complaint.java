package Advert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Complaint {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void main(String[] args) {
        setUpDriver();
        try {
            openRegistrationPage();
            Thread.sleep(1000);
            fillForm();
            Thread.sleep(1000);
            submitForm();
            Thread.sleep(1000);
            clickItemByText("Konut");
            Thread.sleep(1000);
            arama();
            Thread.sleep(1000);
            emlak();
            Thread.sleep(1000);
            emlakListeleme();
            Thread.sleep(1000);
            clickAdvert();
            Thread.sleep(1000);
            clickComplaintButton();
            Thread.sleep(1000);
            selectComplaintOptionByText("İlan kategorisi hatalı");
            Thread.sleep(1000);
            enterComplaintDescription("bu ilan hatalı bilgiler içeriyor");
            Thread.sleep(1000);
            clickSendButton();
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

    public static void setUpDriver() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void openRegistrationPage() {
        driver.get("https://alasouq.com/my-account");
    }

    public static void fillForm() throws InterruptedException {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class, 'sc-ion-label-ios') and text()='Giriş Yap']")));
        loginButton.click();
        Thread.sleep(1000);

        WebElement emailField = driver.findElement(By.id("ion-input-0"));
        emailField.sendKeys("uyaruyr73@gmail.com");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("ion-input-1"));
        currentPasswordField.sendKeys("mirhan6565");
        Thread.sleep(3000);
    }

    public static void submitForm() throws InterruptedException {
        clickElement(By.id("btn-lgn-email"));
        Thread.sleep(2000);
    }

    public static void arama() throws InterruptedException {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn-search")));
        searchButton.click();
    }

    public static void emlak() throws InterruptedException {
        WebElement realEstateCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='real-estate']")));
        realEstateCategory.click();
    }

    public static void clickElement(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public static void emlakListeleme() throws InterruptedException {
        WebElement emlakListAllButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//ion-item[contains(@id, 'btn-list-all-ads')]")));

        emlakListAllButton.click();
    }

    public static void clickAdvert() throws InterruptedException {
        try {
            WebElement advertItem = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//h3[contains(text(), 'AYDIN GERMENCİKTE BAHÇELİ 2 +1 MÜSTAKİL EV')]")));
            advertItem.click();
        } catch (Exception e) {
            System.out.println("İlan bulunamadı veya tıklanamadı: " + e.getMessage());
        }
    }

    public static void clickComplaintButton() throws InterruptedException {
        try {
            WebElement complaintButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("advert-complaint-link")));
            complaintButton.click();
        } catch (Exception e) {
            System.out.println("Şikayet butonu bulunamadı veya tıklanamadı: " + e.getMessage());
        }
     }
    public static void selectComplaintOptionByText(String optionText) throws InterruptedException {
        try {
            WebElement complaintOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ion-radio[contains(text(), '" + optionText + "')]")));
            complaintOption.click();
        } catch (Exception e) {
            System.out.println("Şikayet seçeneği bulunamadı veya tıklanamadı: " + e.getMessage());
        }
    }

    public static void enterComplaintDescription(String message) throws InterruptedException {
        try {
            WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("ion-input-2")));
            descriptionInput.sendKeys(message);
        } catch (Exception e) {
            System.out.println("Şikayet açıklaması alanına yazılamadı: " + e.getMessage());
        }
    }

    public static void clickSendButton() throws InterruptedException {
        try {
            WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-complaint-send")));
            sendButton.click();
        } catch (Exception e) {
            System.out.println("Gönder butonuna tıklanamadı: " + e.getMessage());
        }
    }
}
