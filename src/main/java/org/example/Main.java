package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://alasouq.com/auth/register-user");

        Thread.sleep(1000);
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ion-input-0")));
        emailInput.sendKeys("sahin.jcb1@gmail.com");

        Thread.sleep(1000);
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ion-input-1")));
        firstNameInput.sendKeys("Yakup");

        Thread.sleep(1000);
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ion-input-2")));
        lastNameInput.sendKeys("ŞAHİN");

        Thread.sleep(1000);
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ion-input-4")));
        passwordInput.sendKeys("Yakup65100");

        Thread.sleep(1000);
        WebElement selectLanguage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-select-language")));
        selectLanguage.click();

        Thread.sleep(1000);
        WebElement selectTurkish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alert-input-4-3")));
        selectTurkish.click();

        Thread.sleep(1000);
        WebElement okButtonSelected = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='alert-button ion-focusable ion-activatable sc-ion-alert-ios']")));
        okButtonSelected.click();

        Thread.sleep(1000);
        WebElement privacyPolicyRadioButtonSelected = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-read-accept")));
        privacyPolicyRadioButtonSelected.click();

        Thread.sleep(1000);
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("btn-lgn-email")));
        submitButton.click();

         Thread.sleep(1000);
        WebElement emailAddressCorrect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-email-address-correct-continue")));
        emailAddressCorrect.click();

        Thread.sleep(1000);
        WebElement registerOk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-register-ok")));
        registerOk.click();
    }
}
