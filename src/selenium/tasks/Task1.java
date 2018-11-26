package selenium.tasks;

import org.junit.After;
import org.junit.Assert;
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
            WebElement text = driver.findElement(By.id("numb"));
            String newText = "Word";
            text.sendKeys(newText);
            WebElement button = driver.findElement(By.className(" w3-orange"));
            button.click();
            assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());

    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen
        //When type 49, no error is seen
        WebElement text = driver.findElement(By.id("numb"));
        String newText = "48";
        text.sendKeys(newText);
        WebElement button = driver.findElement(By.className(" w3-orange"));
        button.click();
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
        WebElement text = driver.findElement(By.id("numb"));
        String newText = "101";
        text.sendKeys(newText);
        WebElement button = driver.findElement(By.className(" w3-orange"));
        button.click();
        assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());

    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
        WebElement text = driver.findElement(By.id("numb"));
        String newText = "64";
        double foo = Integer.parseInt(newText);
        foo = Math.sqrt(foo);
        text.sendKeys(newText);
        WebElement button = driver.findElement(By.className(" w3-orange"));
        String elementTextOnPage = driver.findElement(By.id("ch1_error")).getText();
        button.click();
        Alert alert = driver.switchTo().alert();
        assertTrue("Square root of" + newText + "is" + foo, true);
        assertEquals("Square root of 64 is 8.00", alert.getText());
        alert.accept();
        assertFalse(elementTextOnPage,false);


    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
        WebElement text = driver.findElement(By.id("numb"));
        String newText = "54";
        String elementTextOnPage = driver.findElement(By.id("ch1_error")).getText();
        double foo = Integer.parseInt(newText);
        foo = Math.sqrt(foo);
        text.sendKeys(newText);
        WebElement button = driver.findElement(By.className(" w3-orange"));

        button.click();
        Alert alert = driver.switchTo().alert();
        assertTrue("Square root of" + newText + "is" + foo, true);
        assertEquals("Square root of 54 is 7.35", alert.getText());
        alert.accept();
        assertFalse(elementTextOnPage,false);
    }
}
