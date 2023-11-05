package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWIthDropdownList {
    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void testDropdownList(){
        WebElement optionList = driver.findElement(By.id("dropdown"));
        Select selectOptions = new Select(optionList);
        Assert.assertFalse(selectOptions.isMultiple());
        Assert.assertEquals(3, selectOptions.getOptions().size());

        selectOptions.selectByVisibleText("Option 1");
        selectOptions.selectByValue("1");
        selectOptions.selectByIndex(1);

        Assert.assertEquals("Option 1", selectOptions.getFirstSelectedOption().getText());

    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
