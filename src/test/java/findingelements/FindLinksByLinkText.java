package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindLinksByLinkText {

    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findByLinkText(){

        try {

            WebElement seleniumLinks = driver.findElement(By.linkText("Elemental Selenium"));
            System.out.println(seleniumLinks.getAttribute("href"));


        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @Test
    public void findByPartialLinkText(){

        try {

            WebElement seleniumLinks = driver.findElement(By.partialLinkText("Elemental"));
            System.out.println(seleniumLinks.getAttribute("href"));


        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
