package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class FindByCssSelector {

    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findElementByCssSelector(){

        try {
            WebElement usernameTxt = driver.findElement(By.cssSelector("input#username"));
            WebElement passwordTxt = driver.findElement(By.cssSelector("input#password"));
            WebElement loginBtn = driver.findElement(By.cssSelector("button.radius"));
            System.out.println(usernameTxt.getTagName());
            System.out.println(passwordTxt.getTagName());
            System.out.println(loginBtn.getText());

        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
