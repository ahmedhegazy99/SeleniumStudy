package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElemenyByName {

    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findElementByName(){

        try {
            WebElement usernameTxt = driver.findElement(By.name("username"));
            WebElement paswordTxt = driver.findElement(By.name("password"));

            System.out.println(usernameTxt.getTagName());
            System.out.println(paswordTxt.getTagName());
        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
