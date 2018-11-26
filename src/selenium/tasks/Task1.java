package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/task1");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }



    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen

        WebElement field = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-orange"));
        WebElement text = driver.findElement(By.id("ch1_error"));
        String newText = "hello";


      button.click(); // test without any input

      assertTrue("You haven't entered anything", text.isDisplayed());

        field.sendKeys(newText);

        button.click();

        assertTrue("Please enter a number", text.isDisplayed());



    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement field = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-orange"));
        WebElement text = driver.findElement(By.id("ch1_error"));
        String newText = "25";

        field.sendKeys(newText);

        button.click();

        assertTrue("Number is too small", text.isDisplayed());

    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen

        WebElement field = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-orange"));
        WebElement text = driver.findElement(By.id("ch1_error"));
        String newText = "225";

        field.sendKeys(newText);

        button.click();

        assertTrue("Number is too big", text.isDisplayed());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement field = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-orange"));
        WebElement text = driver.findElement(By.id("ch1_error"));
        String newText = "81";

        field.sendKeys(newText);

        button.click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 81 is 9.00", alert.getText());

        alert.accept();

        assertFalse(text.isDisplayed());

    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement field = driver.findElement(By.id("numb"));
        WebElement button = driver.findElement(By.className("w3-orange"));
        WebElement text = driver.findElement(By.id("ch1_error"));
        String newText = "79";

        field.sendKeys(newText);

        button.click();

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 79 is 8.89", alert.getText());

        alert.accept();

        assertFalse(text.isDisplayed());

    }
}
