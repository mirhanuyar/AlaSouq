package web.search;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class AdvertNo {

        public static WebDriver driver;
        public static WebDriverWait wait;

        public static void main(String[] args)  {
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
                homePage();
                Thread.sleep(2000);
                refreshPage();
                Thread.sleep(2000);
                clickAdvert();
                Thread.sleep(2000);
                copyAdvertNo(driver);
                Thread.sleep(2000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public static void setUpDriver() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        }
        public static void openRegistrationPage() {
            driver.get("https://alasouq.com/tr/");
        }

    public static void clickSaveAppSettings() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-default-app-settings")));
        element.click();
    }

        public static void clickUserIcon() throws InterruptedException {
            WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("user-icon-button")));
            userIcon.click();
            Thread.sleep(1000);
        }

        public static void fillForm() throws InterruptedException {
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("onder.backoffice@solidsoft.com.tr");
            Thread.sleep(3000);
            WebElement currentPasswordField = driver.findElement(By.id("password"));
            currentPasswordField.sendKeys("admin");
            Thread.sleep(3000);
            driver.findElement(By.id("btn-sign-in")).click();
        }

        public static void clickElement(By locator) throws InterruptedException {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.click();
            Thread.sleep(1000);
        }
        public static void homePage() throws InterruptedException {
            WebElement home = driver.findElement(By.id("home-link"));
            home.click();
            Thread.sleep(3000);
        }
        public static void refreshPage() throws InterruptedException {
             driver.navigate().refresh();
             driver.manage().window().maximize();
             Thread.sleep(1000);
        }

        public static void clickAdvert() throws InterruptedException {
        Thread.sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ilan = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h6[text()='SAHİBİNDEN BUTİK SİTE İÇİ 3+1 ULTRA LÜKS SIFIR DAİRE']/ancestor::a")
        ));
        ilan.click();
        Thread.sleep(2000);
         }


            public static void copyAdvertNo(WebDriver driver)throws InterruptedException {

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement kodElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='text-danger']")));
                String kod = kodElementi.getText();
                System.out.println("Kopyalanan Kod: " + kod);


                ((JavascriptExecutor) driver).executeScript("window.open();");


                ArrayList<String> sekmeler = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(sekmeler.get(1));


                driver.get("https://alasouq.com/tr/");


                WebDriverWait newWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                Thread.sleep(2000);

                WebElement searchBox = newWait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.id("nav-search-input")));
                searchBox.sendKeys(kod);
                searchBox.sendKeys(Keys.ENTER);

                Thread.sleep(1000);
                driver.findElement(By.cssSelector(".search-result-product-detail")).click();



            }



}


