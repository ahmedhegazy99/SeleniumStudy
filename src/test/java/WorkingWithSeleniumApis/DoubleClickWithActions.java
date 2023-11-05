package WorkingWithSeleniumApis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClickWithActions {
    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://cookbook.seleniumacademy.com/DoubleClickDemo.html");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void DoubleCLickTest(){
        WebElement msg = driver.findElement(By.id("message"));

        System.out.println(msg.getCssValue("background-color"));

        Actions builder = new Actions(driver);

        builder.doubleClick(msg).perform();

        System.out.println(msg.getCssValue("background-color"));

        Assert.assertEquals("rgb(255, 255, 0, 1)", msg.getCssValue("background-color"));
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
