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
//         TODO:

        driver.findElement(By.className("w3-blue")).click();

//        click on "To go to alerted page press Ok. Or stay here" button
        Alert alert = driver.switchTo().alert();
        assertEquals("Want to see an alerted page?!", alert.getText());
//        switch to alert
        alert.accept();
//        click ok
        Alert alertsecond = driver.switchTo().alert();
        assertEquals("Booooooooo!", alertsecond.getText());
        alertsecond.accept();
//        switch to second alert
        ;
//        verify alert text
        assertEquals("This page is alerted", driver.findElement(By.id("heading")).getText());
    // click ok on second alert
        assertEquals("https://kristinek.github.io/site/examples/alerted_page", driver.getCurrentUrl());
//        verify that the correct page is opened
    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
        driver.findElement(By.className("w3-blue")).click();
//        click on "To go to alerted page press Ok. Or stay here" button
        Alert alert = driver.switchTo().alert();
//        switch to alert
        alert.dismiss();
//        click cancel
        assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());
//        verify the text on page
    }
}
