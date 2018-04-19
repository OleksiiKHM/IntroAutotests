package Lesson06;

import org.hamcrest.core.StringContains;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ReallyExplicitOne {
    static WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);*/
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void close() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        String query = "Dress";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query);
        (new WebDriverWait(driver,10)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li[1]"), query));
       /* driver.findElement(By.id("search_query_top")).submit();*/



        driver.findElement(By.id("search_query_top")).clear();
        String query2 = "T-Shirt";
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(query2);

        (new WebDriverWait(driver,10)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='index']/div[2]/ul/li[1]"), query2));
    }

    //BranchOne New String

}
