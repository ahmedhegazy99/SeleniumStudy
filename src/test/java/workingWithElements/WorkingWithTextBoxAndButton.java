package workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithTextBoxAndButton {

    ChromeDriver driver;
    @BeforeTest
    public void openURL(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void LoginScreen(){
        WebElement txtUserName = driver.findElement(By.id("username"));
        WebElement txtPassword = driver.findElement(By.id("password"));
        WebElement btnLogin = driver.findElement(By.className("radius"));

        txtUserName.clear();
        txtUserName.sendKeys("tomsmith");

        txtPassword.clear();
        txtPassword.sendKeys("SuperSecretPassword!");

        btnLogin.click();

        WebElement successNotification = driver.findElement(By.id("flash"));

        System.out.println(successNotification.getText());

        Assert.assertTrue(successNotification.getText().contains("You logged into a secure area!"));
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
