package selenium.sample;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";

    @Test
    public void goToHomepage() throws Exception {
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // define driver
       //driver.get("https://google.com");
        driver.get("https://kristinek.github.io/site/index2.html");
        System.out.println(driver.findElement(By.xpath("/html/body/h1")).getText());

        //get title of page
        System.out.println(driver.getTitle());

        //get URL of current page
        System.out.println(driver.getCurrentUrl());

        //Sleep for 10 seconds
        Thread.sleep(5000);

        //Close browser
        driver.close();
    }
}
