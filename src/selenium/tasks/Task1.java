package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen

        //enter text
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("test text");

        // click submit button
        driver.findElement(By.className("w3-orange")).click();

        // get error text
        String errortext = driver.findElement(By.id("ch1_error")).getText();

        //assert result
        assertEquals("Please enter a number",errortext);
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen

        //enter number less than 50
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("45");

        // click submit button
        driver.findElement(By.className("w3-orange")).click();

        // get error text
        String errortext = driver.findElement(By.id("ch1_error")).getText();

        //assert result
        assertEquals("Number is too small",errortext);
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen

        //enter number more than 100
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("115");

        // click submit button
        driver.findElement(By.className("w3-orange")).click();

        // get error text
        String errortext = driver.findElement(By.id("ch1_error")).getText();

        //assert result
        assertEquals("Number is too big",errortext);
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        //enter a number between 50 and 100 digit (square root of which doesn't have a remainder)
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("81");

        // click submit button
        driver.findElement(By.className("w3-orange")).click();

        // get alert text
        Alert alert = driver.switchTo().alert();

        //assert result
        assertEquals("Square root of 81 is 9.00",alert.getText());
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        //enter a number between 50 and 100 digit (square root of which have a remainder)
        WebElement textbox = driver.findElement(By.id("numb"));
        textbox.sendKeys("82");

        // click submit button
        driver.findElement(By.className("w3-orange")).click();

        // get alert text
        Alert alert = driver.switchTo().alert();

        //assert result
        assertEquals("Square root of 82 is 9.06",alert.getText());
    }
}
