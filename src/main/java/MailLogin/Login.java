package MailLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:4200/auth/login");

            Thread.sleep(2000);
            WebElement username = driver.findElement(By.xpath("//*[@id=\"ion-input-0\"]"));

            Thread.sleep(2000);
            WebElement password = driver.findElement(By.xpath("//*[@id=\"ion-input-1\"]"));

            Thread.sleep(2000);
            username.sendKeys("yakup.backoffice@solidsoft.com.tr");

            Thread.sleep(2000);
            password.sendKeys("admin");

            Thread.sleep(2000);
            WebElement loginButton = driver.findElement(By.id("btn-lgn-email"));
            loginButton.click();

            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
