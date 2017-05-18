package com.makingdevs.functional;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleGoogleSearchFunctionalTests {
  
  WebDriver driver;

  @Test
  public void testSimpleSearchInGoogle() {
    driver = new FirefoxDriver();
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("MakingDevs");
    element.submit();
    Assert.assertTrue(driver.getTitle().equals("Google"));
    driver.quit();
  }

  @Test
  public void testSimpleSearchInGoogleWithSuggestions() {
    driver = new FirefoxDriver();
    driver.get("http://www.google.com/webhp?complete=1&hl=en");
    WebElement query = driver.findElement(By.name("q"));
    query.sendKeys("MakingDe");
    WebElement listOfSuggestions = findDynamicElement(By.className("sbsb_b"), 5);
    List<WebElement> allSuggestions = listOfSuggestions.findElements(By.className("sbqs_c"));
    Assert.assertFalse(allSuggestions.isEmpty());
    for (WebElement suggestion : allSuggestions) {
      Assert.assertTrue(suggestion.getText().contains("making"));
    }
    driver.quit();
  }

  private WebElement findDynamicElement(By by, int timeOut) {
    WebDriverWait wait = new WebDriverWait(driver, timeOut);
    WebElement element = wait.until(ExpectedConditions
        .visibilityOfElementLocated(by));
    return element;
  }
}
