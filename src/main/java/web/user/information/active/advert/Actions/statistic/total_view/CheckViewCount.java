package web.user.information.active.advert.Actions.statistic.total_view;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckViewCount {
    public static void main(String[] args) {
        try {
            ViewAdvert viewAdvert = new ViewAdvert();
            viewAdvert.openRegistrationPage();

            WebDriver driver = viewAdvert.getDriver();
            WebDriverWait wait = viewAdvert.getWait();
            Thread.sleep(3000);

            clickSaveAppSettings(driver);
            clickUserIcon(wait);
            fillForm(driver);
            signIn(driver);
            clickMyAdverts(driver);
            refreshPage(driver);
            clickAction(driver);
            clickStatics(driver);
            scrollScreen(driver, 800);
            int firstViewCount = getViewsCount(driver);
            Thread.sleep(2000);
            scrollScreen(driver, 600);
            logOut(driver);
            viewAdvert.performViewAdvertFlow();
            clickUserIcon(wait);
            fillForm(driver);
            signIn(driver);
            clickMyAdverts(driver);
            clickAction(driver);
            clickStatics(driver);
            scrollScreen(driver, 800);
            int secondViewCount = getViewsCount(driver);
            if(firstViewCount == secondViewCount - 1) {
                System.out.println("Test Başarılı");
            } else {
                System.out.println("Test başarısız.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void clickUserIcon(WebDriverWait wait) throws InterruptedException {
        Thread.sleep(3000);
        WebElement userIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("user-icon-button")));
        userIcon.click();
    }

    public static void clickSaveAppSettings(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement save = driver.findElement(By.id("btn-default-app-settings"));
        save.click();
    }


    public static void fillForm(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("yakup.backoffice@solidsoft.com.tr");
        Thread.sleep(3000);
        WebElement currentPasswordField = driver.findElement(By.id("password"));
        currentPasswordField.sendKeys("admin");
        Thread.sleep(3000);
    }

    public static void signIn(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement clickSignIn = driver.findElement(By.id("btn-sign-in"));
        clickSignIn.click();
    }

    public static void clickMyAdverts(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement myAdverts = driver.findElement(By.id("link-adverts"));
        myAdverts.click();
    }

    public static void clickAction(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement action = driver.findElement(By.cssSelector("button.dropdown-toggle.primary.my-advert-action-button"));
        action.click();
    }

    public static void clickStatics(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement statics = driver.findElement(By.cssSelector("button[id*='btn-statistics']"));
        statics.click();
    }

    public static void scrollScreen(WebDriver driver, int pixels) throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }

    public static void refreshPage(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.navigate().refresh();
        driver.manage().window();
    }

    public static int getViewsCount(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        WebElement h6Element = driver.findElement(By.xpath("//h6[contains(., 'Total Views')]"));
        String fullText = h6Element.getText();

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(fullText);

        int viewCount = 0;
        if (matcher.find()) {
            viewCount = Integer.parseInt(matcher.group(1));
        }
        System.out.println(viewCount);
        Thread.sleep(2000);
        return viewCount;
    }

    public static void logOut(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        WebElement logOutButton = driver.findElement(By.id("link-logout"));
        logOutButton.click();
        Thread.sleep(3000);
        WebElement yesButton = driver.findElement(By.id("confirm_yes_btn"));
        yesButton.click();
        Thread.sleep(2000);
    }



}

