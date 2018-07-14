package com.playlocal.app;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, MalformedURLException
    {
        System.out.println( "Hello World!" );
        
        System.out.println("Hello working");
        DesiredCapabilities cap = new DesiredCapabilities().chrome();
        //DesiredCapabilities cap = new DesiredCapabilities().firefox();
        //cap.setPlatform(Platform.MAC);
        //cap.setPlatform(Platform.LINUX);
        URL a = new URL("http://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(a,cap);
        /*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sameer\\IdeaProjects\\playLocal\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/
        driver.manage().window().maximize();
        driver.get("https://www.playlocal.com/");

        Date sysDate = new Date();
        int abc = sysDate.getDate();
        int dateToSelect = abc + 14;
        System.out.println(abc);

        WebElement signOn = driver.findElement(By.linkText("Sign in"));
        signOn.click();

        WebElement user =  driver.findElement(By.id("session_email"));
        user.click();
        user.sendKeys("anything4tennis@gmail.com");

        WebElement password = driver.findElement(By.id("session_password"));
        password.click();
        password.sendKeys("tennis@123");

        WebElement login = driver.findElement(By.name("commit"));
        login.click();

        WebElement date = driver.findElement(By.id("search_friendly_date"));
        date.click();

        WebElement datePicker = driver.findElement(By.linkText(String.valueOf(dateToSelect)));
        datePicker.click();

        WebElement findCourts = driver.findElement(By.xpath("/html/body/div[1]/section/section[1]/article/div/div[1]/div[2]/form/input[4]"));
        findCourts.click();

        WebElement selectTime = driver.findElement(By.xpath("/html/body/div[1]/section[2]/ul/li[1]/ul/li[4]"));
        selectTime.click();

        WebElement reserve = driver.findElement(By.linkText("Reserve"));
        reserve.click();

        WebElement acceptTerms = driver.findElement(By.id("reservation_accepted_terms_of_service"));
        acceptTerms.click();

        WebElement confirm = driver.findElement(By.xpath("//*[@id=\"new_reservation\"]/section/article/span[2]/input"));
        confirm.click();

        WebElement skip = driver.findElement(By.linkText("skip this step"));
        skip.click();

        driver.close();
    }
}
