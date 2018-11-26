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
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() throws InterruptedException {
//        TODO
//        enter a text instead of a number, check that correct error is seen
        WebElement numberInput = driver.findElement(By.id("numb"));
        String newText = "abcd";

        numberInput.clear();
        numberInput.sendKeys(newText);
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooSmall() throws InterruptedException {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        WebElement numberInput = driver.findElement(By.id("numb"));
        String smallNumber = "5";

        numberInput.clear();
        numberInput.sendKeys(smallNumber);
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() throws InterruptedException {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement numberInput = driver.findElement(By.id("numb"));
        String bigNumber = "222";

        numberInput.clear();
        numberInput.sendKeys(bigNumber);
        driver.findElement(By.className("w3-orange")).click();
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void correctSquareRootWithoutRemainder() throws InterruptedException {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement numberInput = driver.findElement(By.id("numb"));
        String correctNumberOne = "81";

        numberInput.clear();
        numberInput.sendKeys (correctNumberOne);
        driver.findElement(By.className("w3-orange")).click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alert.getText());
        alert.accept();

        WebElement error = driver.findElement(By.id("ch1_error"));
        assertFalse(error.isDisplayed());
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement numberInput = driver.findElement(By.id("numb"));
        String correctNumberTwo = "90";

        numberInput.clear();
        numberInput.sendKeys (correctNumberTwo);
        driver.findElement(By.className("w3-orange")).click();

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 90 is 9.49", alert.getText());
        alert.accept();

        WebElement error = driver.findElement(By.id("ch1_error"));
        assertFalse(error.isDisplayed());
    }
}
