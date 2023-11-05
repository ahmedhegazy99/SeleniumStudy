package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWIthCheckboxes {
    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        System.out.println(driver.getCurrentUrl());
    }

    @Test(enabled = false)
    public void testCheckbox() throws InterruptedException {
        WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        check1.click();

        Thread.sleep(2000);

        WebElement check2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        if (check2.isSelected()){
            check2.click();
        }
        Assert.assertTrue(!check2.isSelected() && check1.isSelected());

        Thread.sleep(4000);
    }

    @Test
    public void testIfElementPresent(){
        if(isElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))){
            WebElement check1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
            if(!check1.isSelected()){
                check1.click();
            }
        }else {
            Assert.fail("checkbox 1 doesn't exist");
        }
    }
    private boolean isElementPresent(By by){
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
