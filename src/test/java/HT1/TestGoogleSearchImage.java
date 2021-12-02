package HT1;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.IOException;
import java.util.List;



public class TestGoogleSearchImage {
    WebDriver driver;

    @BeforeTest
    public void setupUrl() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/");
    }
    @Test
    public void test1() {

        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("cheese" + Keys.ENTER);
        driver.findElement(By.xpath("//a[contains(text(), 'Картинки')]")).click();
        List<WebElement> webElements = driver.findElements(By.xpath("//*[@id=\"islrg\"]//img"));
        driver.findElement(By.xpath("//*[@id=\"islrg\"]//img")).click();
        Assert.assertTrue(webElements.size()>1);

    }
@AfterTest
        public void takeScreenshot() {
            File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             try {
                 File DestFile=new File("C:\\Users\\alfav\\Desktop\\EPAM course\\Lab EPAM\\Test1.jpeg");
                 FileUtils.copyFile(src, DestFile);
             } catch (IOException e) {
                 e.printStackTrace();
             }
             driver.quit();
        }

    }




