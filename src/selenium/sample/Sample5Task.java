package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/al_and_pu");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {


//
// TODO:
        driver.findElement(By.className("w3-blue")).click();
        Alert alert = driver.switchTo().alert();

        assertEquals("Want to see an alerted page?!", alert.getText());
        alert.accept();

        assertEquals("Booooooooo!", alert.getText());
        alert.accept();
        assertEquals("https://kristinek.github.io/site/examples/alerted_page",driver.getCurrentUrl());

        Thread.sleep(15000);


//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click ok
//        switch to second alert
//        verify alert text
//        click ok on second alert
//        verify that the correct page is opened
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();
//        switch to alert
        Alert alert = driver.switchTo().alert();

        assertEquals("Want to see an alerted page?!", alert.getText());
//        click cancel
        alert.dismiss();
//        verify the text on page
        assertEquals("So you desided to say? Good!",driver.findElement(By.id("textForAlerts")).getText());
       // assertEquals("https://kristinek.github.io/site/examples/alerts_popups",driver.getCurrentUrl());
    }
}
