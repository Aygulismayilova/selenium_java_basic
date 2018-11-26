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
        WebElement numberArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        String text = "number";

        assertEquals(numberArea.getText(), "");
        assertEquals(numberArea.getAttribute("value"), "");

        numberArea.clear();
        numberArea.sendKeys(text);

        assertEquals(text, numberArea.getAttribute("value"));

        submitButton.click();

        assertTrue(error.isDisplayed());
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement numberArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        String text = "7";

        assertEquals(numberArea.getText(), "");
        assertEquals(numberArea.getAttribute("value"), "");

        numberArea.clear();
        numberArea.sendKeys(text);

        assertEquals(text, numberArea.getAttribute("value"));

        submitButton.click();

        assertTrue(error.isDisplayed());
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement numberArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        String text = "123";

        assertEquals(numberArea.getText(), "");
        assertEquals(numberArea.getAttribute("value"), "");

        numberArea.clear();
        numberArea.sendKeys(text);

        assertEquals(text, numberArea.getAttribute("value"));

        submitButton.click();

        assertTrue(error.isDisplayed());
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement numberArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        String text = "49";

        assertEquals(numberArea.getText(), "");
        assertEquals(numberArea.getAttribute("value"), "");

        numberArea.clear();
        numberArea.sendKeys(text);

        assertEquals(text, numberArea.getAttribute("value"));

        submitButton.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 49 is 7.00", alert.getText());

        alert.accept();

        assertFalse(error.isDisplayed());
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement numberArea = driver.findElement(By.id("numb"));
        WebElement submitButton = driver.findElement(By.className("w3-orange"));
        WebElement error = driver.findElement(By.id("ch1_error"));
        String text = "59.29";

        assertEquals(numberArea.getText(), "");
        assertEquals(numberArea.getAttribute("value"), "");

        numberArea.clear();
        numberArea.sendKeys(text);

        assertEquals(text, numberArea.getAttribute("value"));

        submitButton.click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 59.29 is 7.70", alert.getText());

        alert.accept();

        assertFalse(error.isDisplayed());
    }
}
