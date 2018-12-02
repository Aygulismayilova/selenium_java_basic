package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class Task2 {
    WebDriver driver;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
        // check that all field are empty and no tick are clicked
        // "Don't know" is selected in "Genre"
        // "Choose your option" in "How do you like us?"
        // check that the button send is blue with white letters

        // check that all field are empty
        WebElement name = driver.findElement(By.id("fb_name"));
        assertEquals("", name.getText());

        WebElement age = driver.findElement(By.id("fb_age"));
        assertEquals("", age.getText());

        WebElement comment = driver.findElement(By.cssSelector("textarea[name='comment']"));
        assertEquals("", comment.getText());

        // and no tick are clicked
        List<WebElement> languageList = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        for (WebElement language : languageList) {
            assertFalse(language.isSelected());
        }

        // "Don't know" is selected in "Genre"
        List<WebElement> genreList = driver.findElements(By.cssSelector(".w3-radio[type='radio'"));
        assertTrue(genreList.get(2).isSelected());

        // "Choose your option" in "How do you like us?"
        Select like_us = new Select(driver.findElement(By.id("like_us")));
        assertEquals("Choose your option", like_us.getFirstSelectedOption().getText());


        WebElement send = driver.findElement(By.cssSelector("button[type='submit']"));
        assertEquals("rgba(33, 150, 243, 1)", send.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", send.getCssValue("color"));
    }

    @Test
    public void emptyFeedbackPage() throws Exception {
        // click "Send" without entering any data
        // check fields are empty or null
        // check button colors
        // (green with white letter and red with white letters)

        // click "Send" without entering any data
        WebElement send = driver.findElement(By.cssSelector("button[type='submit']"));
        send.click();

        // check fields are empty or null
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("age")).getText());
        assertEquals("", driver.findElement(By.id("language")).getText());
        assertEquals("null", driver.findElement(By.id("gender")).getText());
        assertEquals("null", driver.findElement(By.id("option")).getText());
        assertEquals("", driver.findElement(By.id("comment")).getText());

        // check button colors (green with white letter)
        WebElement yes = driver.findElement(By.cssSelector(".w3-green"));
        assertEquals("rgba(76, 175, 80, 1)", yes.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yes.getCssValue("color"));

        // check button colors (red with white letters)
        WebElement no = driver.findElement(By.cssSelector(".w3-red"));
        assertEquals("rgba(244, 67, 54, 1)", no.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", no.getCssValue("color"));
    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
        // fill the whole form, click "Send"
        // check fields are filled correctly
        // check button colors
        // (green with white letter and red with white letters)

        // fill the whole form
        WebElement name = driver.findElement(By.id("fb_name"));
        name.sendKeys("Aygul");

        WebElement age = driver.findElement(By.id("fb_age"));
        age.sendKeys("28");

        WebElement languageEnglish = driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='English']"));
        languageEnglish.click();

        WebElement genderFemale = driver.findElement(By.cssSelector(".w3-radio[type='radio'][value='female']"));
        genderFemale.click();

        Select like_us = new Select(driver.findElement(By.id("like_us")));
        like_us.selectByVisibleText("Good");

        WebElement comment = driver.findElement(By.cssSelector("textarea[name='comment']"));
        comment.sendKeys("I like Test automation");

        // click "Send"
        WebElement send = driver.findElement(By.cssSelector("button[type='submit']"));
        send.click();

        // check fields are empty or null
        assertEquals("Aygul", driver.findElement(By.id("name")).getText());
        assertEquals("28", driver.findElement(By.id("age")).getText());
        assertEquals("English", driver.findElement(By.id("language")).getText());
        assertEquals("female", driver.findElement(By.id("gender")).getText());
        assertEquals("Good", driver.findElement(By.id("option")).getText());
        assertEquals("I like Test automation", driver.findElement(By.id("comment")).getText());

        // check button colors (green with white letter)
        WebElement yes = driver.findElement(By.cssSelector(".w3-green"));
        assertEquals("rgba(76, 175, 80, 1)", yes.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yes.getCssValue("color"));

        // check button colors (red with white letters)
        WebElement no = driver.findElement(By.cssSelector(".w3-red"));
        assertEquals("rgba(244, 67, 54, 1)", no.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", no.getCssValue("color"));
    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
        // enter only name
        // click "Send"
        // click "Yes"
        // check message text: "Thank you, NAME, for your feedback!"
        // color of text is white with green on the background

        // enter only name
        WebElement name = driver.findElement(By.id("fb_name"));
        name.sendKeys("Aygul");

        // click "Send"
        WebElement send = driver.findElement(By.cssSelector("button[type='submit']"));
        send.click();

        // click "Yes"
        WebElement yes = driver.findElement(By.cssSelector(".w3-green"));
        yes.click();

        // check message text: "Thank you, NAME, for your feedback!"
        WebElement message = driver.findElement(By.id("message"));
        assertEquals("Thank you, Aygul, for your feedback!",message.getText());

        // color of text is white with green on the background
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.className("w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-green")).getCssValue("color"));
    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
        // click "Send" (without entering anything
        // click "Yes"
        // check message text: "Thank you for your feedback!"
        // color of text is white with green on the background

        // click "Send"
        WebElement send = driver.findElement(By.cssSelector("button[type='submit']"));
        send.click();

        // click "Yes"
        WebElement yes = driver.findElement(By.cssSelector(".w3-green"));
        yes.click();

        // check message text: "Thank you, NAME, for your feedback!"
        WebElement message = driver.findElement(By.id("message"));
        assertEquals("Thank you for your feedback!",message.getText());

        // color of text is white with green on the background
        assertEquals("rgba(76, 175, 80, 1)", driver.findElement(By.className("w3-green")).getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", driver.findElement(By.className("w3-green")).getCssValue("color"));
    }

    @Test
    public void noOnFeedbackPage() throws Exception {
        // fill the whole form
        // click "Send"
        // check fields are filled correctly

        // fill the whole form
        WebElement name = driver.findElement(By.id("fb_name"));
        name.sendKeys("Aygul");

        WebElement age = driver.findElement(By.id("fb_age"));
        age.sendKeys("28");

        WebElement languageEnglish = driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='English']"));
        languageEnglish.click();

        WebElement genderFemale = driver.findElement(By.cssSelector(".w3-radio[type='radio'][value='female']"));
        genderFemale.click();

        Select like_us = new Select(driver.findElement(By.id("like_us")));
        like_us.selectByVisibleText("Good");

        WebElement comment = driver.findElement(By.cssSelector("textarea[name='comment']"));
        comment.sendKeys("I like Test automation");

        // click "Send"
        WebElement send = driver.findElement(By.cssSelector("button[type='submit']"));
        send.click();

        // click "No"
        WebElement no = driver.findElement(By.cssSelector(".w3-red"));
        no.click();
        Thread.sleep(200);

        // check fields are filled correctly
        WebElement nameOnReturn = driver.findElement(By.id("fb_name"));
        assertEquals("Aygul", nameOnReturn.getAttribute("value"));

        WebElement ageOnReturn = driver.findElement(By.id("fb_age"));
        assertEquals("28", ageOnReturn.getAttribute("value"));

        WebElement languageEnglishOnReturn = driver.findElement(By.cssSelector(".w3-check[type='checkbox'][value='English']"));
        assertTrue(languageEnglishOnReturn.isSelected());

        WebElement genderFemaleOnReturn = driver.findElement(By.cssSelector(".w3-radio[type='radio'][value='female']"));
        assertTrue(genderFemaleOnReturn.isSelected());

        Select like_usOnReturn = new Select(driver.findElement(By.id("like_us")));
        assertEquals("Good", like_usOnReturn.getFirstSelectedOption().getText());

        WebElement commentOnReturn = driver.findElement(By.cssSelector("textarea[name='comment']"));
        assertEquals("I like Test automation", commentOnReturn.getAttribute("value"));
    }
}
