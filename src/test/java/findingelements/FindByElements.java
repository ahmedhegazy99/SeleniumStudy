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

public class FindByElements {

    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com");
    }

    @Test
    public void findByElements(){

        try {
            //get all links displayed on page
            List<WebElement> links = driver.findElements(By.tagName("a"));

            //verify there are 20 links displayed on the page
            Assert.assertEquals(links.size(),46);

            for (WebElement link : links){
                System.out.println(link.getAttribute("href"));
            }

        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
