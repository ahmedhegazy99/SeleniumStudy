package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElemenyByID {

    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findElementByID(){
        WebElement usernameTxt = driver.findElement(By.id("username"));
        WebElement paswordTxt = driver.findElement(By.id("password"));

        System.out.println(usernameTxt.getLocation());
        System.out.println(paswordTxt.getLocation());
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
