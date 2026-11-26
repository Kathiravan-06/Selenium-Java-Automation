package com.selenium;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class App {
    private static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String[] args) {
        String wikiUsername = "Mr-Stack-2k";
        String wikiPassword = "Password@123";
        String searchQuery = "T-Rex";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            driver.get("https://www.wikipedia.org/");
            pause(1);
            WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("searchInput"))
            );
            searchBox.clear();
            searchBox.sendKeys(searchQuery);
            pause(1);
            searchBox.sendKeys(Keys.ENTER);
            pause(2);
            driver.get("https://en.wikipedia.org/w/index.php?title=Special:UserLogin");
            pause(1);
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#wpName1, input[name='wpName'], input[name='username']")));
            userField.clear();
            userField.sendKeys(wikiUsername);
            pause(1);
            WebElement passField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("#wpPassword1, input[name='wpPassword'], input[type='password']")
                )
            );
            passField.clear();
            passField.sendKeys(wikiPassword);
            pause(1);
            WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.cssSelector("#wpLoginAttempt, button[name='wploginattempt'], button[type='submit'], input[type='submit']")
                )
            );
            loginButton.click();
            pause(3);
            System.out.println("Page title after login attempt: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
