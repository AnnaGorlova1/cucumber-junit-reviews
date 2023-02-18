package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {


    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driver;
    }

    /*
      Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
       */
    public static void closeDriver(){
        if (driver!=null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            driver.quit();
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
            driver = null;
        }
    }



}
