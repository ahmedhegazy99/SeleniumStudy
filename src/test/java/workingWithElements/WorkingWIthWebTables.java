package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WorkingWIthWebTables {
    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/tables");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void testWebTable(){
        WebElement table1 = driver.findElement(By.id("table1"));

        //get all rows
        List<WebElement> rows = table1.findElements(By.tagName("tr"));
        Assert.assertEquals(5, rows.size());

        //get cols all cells data
        for (WebElement row: rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col: cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println();
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
