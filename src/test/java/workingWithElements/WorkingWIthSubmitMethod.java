package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWIthSubmitMethod {
    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void testSubmit(){
        WebElement txtSearch = driver.findElement(By.className("gLFyf"));

        txtSearch.clear();
        txtSearch.sendKeys("Selenium webDriver");
        txtSearch.submit();
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
