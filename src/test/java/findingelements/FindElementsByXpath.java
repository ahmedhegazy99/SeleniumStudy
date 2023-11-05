package findingelements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class FindElementsByXpath {

    ChromeDriver driver;
    //FirefoxDriver driver;
    @BeforeTest
    public void openURL(){

        //firefox initialize
        /*
        File pathBinary = new File("/opt/firefox/firefox");
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxBinary);
        driver = new FirefoxDriver(options);
*/

        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void findByAbsoluteXpath(){

        try {

            WebElement usernameTxt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
            // from firefox //*[@id="username"]
            WebElement passwordTxt = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));

            System.out.println(usernameTxt.getTagName());
            System.out.println(passwordTxt.getTagName());
            System.out.println(loginBtn.getText());


        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @Test
    public void findByRelativeXpath(){

        try {

            WebElement usernameTxt = driver.findElement(By.xpath("//input"));
            // from firefox //*[@id="username"]
            WebElement passwordTxt = driver.findElement(By.xpath("//input"));
            WebElement loginBtn = driver.findElement(By.xpath("//button"));

            System.out.println(usernameTxt.getTagName());
            System.out.println(passwordTxt.getTagName());
            System.out.println(loginBtn.getText());


        }catch (NoSuchElementException e){
            System.out.println("the element not found please use different attribute");
        }
    }

    @Test
    public void findByXpathPredicates(){

        try {

            //with index
            WebElement usernameTxt = driver.findElement(By.xpath("//input[1]"));
            //with attributes value id
            WebElement passwordTxt = driver.findElement(By.xpath("//input[@id='password']"));
            //with attributes value class
            WebElement loginBtn = driver.findElement(By.xpath("//button[@class='radius']"));

            System.out.println(usernameTxt.getAccessibleName());
            System.out.println(passwordTxt.getAccessibleName());
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
