package HT1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class TestGoogleSearchImage {

    @Test
    public void test() {

         System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
         WebDriver driver = new ChromeDriver();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         try {
            driver.get("https://www.google.com.ua/");
             WebElement webElement = driver.findElement(By.name("q"));
             webElement.sendKeys("cheese"+ Keys.ENTER);
             WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3")));
             Assert.assertFalse(firstResult.getAttribute("text  content").isEmpty());
         }
        finally {
             driver.quit();
         }
    }
}
