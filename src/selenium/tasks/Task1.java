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

public class Task1 {
    WebDriver driver;

    @Before
    public void openPage() throws InterruptedException {

        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        Thread.sleep(500);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }


    @Test
    public void errorOnText() throws InterruptedException {
        WebElement NumberEntry = driver.findElement(By.id("numb"));
        NumberEntry.sendKeys(" No ");

        Thread.sleep(100);

        WebElement EntryButton = driver.findElement(By.className("w3-orange"));
        EntryButton.click();

        Thread.sleep(100);

        WebElement CheckText = driver.findElement(By.className("error"));
        Assert.assertEquals("Please enter a number" , "Please enter a number");

//        TODO
//        enter a text instead of a number, check that correct error is seen
    }

    @Test
    public void errorOnNumberTooSmall() throws InterruptedException {

        WebElement NumberEntry = driver.findElement(By.id("numb"));
        NumberEntry.sendKeys(" 48 ");

        Thread.sleep(100);

        WebElement EntryButton = driver.findElement(By.className("w3-orange"));
        EntryButton.click();

        Thread.sleep(100);

        WebElement CheckText = driver.findElement(By.className("error"));
        Assert.assertEquals("Number is too small" , "Number is too small");

//        TODO
//        enter number which is too small (below 50), check that correct error is seen
    }

    @Test
    public void errorOnNumberTooBig() throws InterruptedException {

        WebElement NumberEntry = driver.findElement(By.id("numb"));
        NumberEntry.sendKeys(" 123 ");

        Thread.sleep(100);

        WebElement EntryButton = driver.findElement(By.className("w3-orange"));
        EntryButton.click();

        Thread.sleep(100);

        WebElement CheckText = driver.findElement(By.className("error"));
        Assert.assertEquals("Number is too big" , "Number is too big");

        Thread.sleep(100);

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen
    }

    @Test
    public void correctSquareRootWithoutRemainder() throws InterruptedException {

        WebElement NumberEntry = driver.findElement(By.id("numb"));
        NumberEntry.sendKeys(" 81 ");

        Thread.sleep(100);

        WebElement EntryButton = driver.findElement(By.className("w3-orange"));
        EntryButton.click();

        Thread.sleep(200);

        Alert alertX = driver.switchTo().alert();
        assertEquals("Square root of 81 is 9.00", alertX.getText());
        alertX.accept();



        Thread.sleep(200);

//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly
    }

    @Test
    public void correctSquareRootWithRemainder() throws InterruptedException {

        WebElement NumberEntry = driver.findElement(By.id("numb"));
        NumberEntry.sendKeys(" 80 ");

        Thread.sleep(100);

        WebElement EntryButton = driver.findElement(By.className("w3-orange"));
        EntryButton.click();

        Thread.sleep(200);

        Alert alertX = driver.switchTo().alert();
        assertEquals("Square root of 81 is 8.94", alertX.getText());
        alertX.accept();


//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly
    }
}
