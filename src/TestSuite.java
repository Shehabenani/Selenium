import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite  {
    @Test
    public void testingSearchAndAdvancedSearch() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //navigate to website
        webDriver.navigate().to("https://www.imdb.com/");

        //search for specific movie
        webDriver.findElement(By.xpath("//*[@id=\"suggestion-search\"]")).sendKeys("The shawshank redemption");
        Thread.sleep(2000);


        //clicking on the search button
        webDriver.findElement(By.id("suggestion-search-button")).click();
        Thread.sleep(2000);

        //checking the movies diplayed --> should be related to the search query
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]")).isDisplayed());

        //checking the first movie matches the searched movie or not
        String actualval = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]/ul/li[1]/div[2]/div/a")).getText();
        String expectedval = "The Shawshank Redemption";
        Assert.assertEquals(expectedval, actualval);

        webDriver.findElement(By.xpath("//*[@id=\"nav-search-form\"]/div[1]/div/label")).click();
        //Thread.sleep(2000);

        //user clicks on [Advanced search] Button
        webDriver.findElement(By.xpath("//*[@id=\"navbar-search-category-select-contents\"]/ul/a")).click();
        //Thread.sleep(2000);

        //check that user is redirected to advanced search page
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/section/div/section")).isDisplayed());

        //click on the title type toggle
        webDriver.findElement(By.xpath("//*[@id=\"titleTypeAccordion\"]/div[1]/label")).click();
        Thread.sleep(2000);

        //clicks on the movie type button
        webDriver.findElement(By.xpath("//*[@id=\"accordion-item-titleTypeAccordion\"]/div/section/button[1]")).click();
        //Thread.sleep(2000);

        //click on the genre toggle
        WebElement genreToggle = webDriver.findElement(By.xpath("//*[@id=\"genreAccordion\"]/div[1]/label"));
        Thread.sleep(2000);
        genreToggle.click();

        //choose action genre
        webDriver.findElement(By.xpath("//*[@id=\"accordion-item-genreAccordion\"]/div/section/button[1]")).click();
        //Thread.sleep(2000);

        //click on the release date toggle
        webDriver.findElement(By.xpath("//*[@id=\"releaseDateAccordion\"]/div[1]/label")).click();
        //Thread.sleep(3000);


        webDriver.findElement(By.name("release-yearmonth-start-input")).sendKeys("2010");
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(""))).
        Thread.sleep(1000);


        //enter 2020 in the second box
        webDriver.findElement(By.name("release-yearmonth-end-input")).sendKeys("2020");;
        Thread.sleep(1000);

        //click see result button
        webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[1]/button")).click();
        Thread.sleep(2000);
        //webDriver.close();

        //check the list of movies listed between 2010 - 2020 & Sorted in popularity
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[2]/div[2]/ul")).isDisplayed());
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/section/div/section/section/div[2]/div/section/div[2]/div[2]/div[1]/div[2]/div/span/span")).isDisplayed());

    }

    @Test
    public void testSearchWith250() throws Exception{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //navigate to website
        webDriver.navigate().to("https://www.imdb.com/");

        webDriver.findElement(By.xpath("//*[@id=\"imdbHeader-navDrawerOpen\"]/span")).click();
        Thread.sleep(2000);

        //user then clicks on the top250 movies
        webDriver.findElement(By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside[1]/div/div[2]/div/div[1]/span/div/div/ul/a[2]/span")).click();

        //checks that user redirected to the top250 movies page
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main")).isDisplayed());

        //checks that 250 movies list is listed
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul")).isDisplayed());

        webDriver.findElement(By.xpath("//*[@id=\"suggestion-search\"]")).sendKeys("The Dark Knight");
        Thread.sleep(2000);

        //clicking on the search button
        webDriver.findElement(By.id("suggestion-search-button")).click();
        Thread.sleep(2000);

        //checking the movies diplayed --> should be related to the search query
        Assert.assertTrue(webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]")).isDisplayed());

        //checking the first movie matches the searched movie or not
        String actualval = webDriver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/div[3]/section/div/div[1]/section[2]/div[2]/ul/li[1]/div[2]/div/a")).getText();
        String expectedval = "The Dark Knight";
        Assert.assertEquals(expectedval,actualval);

    }
}