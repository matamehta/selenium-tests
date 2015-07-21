package com.wikia.webdriver.pageobjectsfactory.pageobject.mercury;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @ownership: Content X-Wing
 */
public class CuratedMainPagePageObject extends BasePageObject {

  @FindBy(css = ".mobile-top-leaderboard")
  private WebElement mobileTopLeaderboard;
  @FindBy(css = ".article-title")
  private WebElement articleTitle;
  @FindBy(css = ".wikia-stats-container")
  private WebElement wikiaStatsContainer;
  @FindBy(css = ".featured-content")
  private WebElement featuredContent;
  @FindBy(css = ".curated-content")
  private WebElement curatedContent;
  @FindBy(css = ".mobile-in-content")
  private WebElement mobileInContent;
  @FindBy(css = ".trending-articles")
  private WebElement trendingArticles;
  @FindBy(css = ".trending-videos")
  private WebElement trendingVideos;
  @FindBy(css = ".mobile-prefooter")
  private WebElement mobilePrefooter;

  private enum Settings {
    TIME_OUT_IN_SEC(5),
    CHECK_OUT_IN_MILLI_SEC(1000);

    private int value;

    Settings(int value) {
      this.value = value;
    }
  }

  public CuratedMainPagePageObject(WebDriver driver) {
    super(driver);
  }

  public int getElementOffsetTop(String element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return Integer
        .parseInt(js.executeScript("return $(arguments[0]).offset().top", element).toString());
  }

  public boolean isMobileTopLeaderboardVisible() {
    try {
      waitForElementVisibleByElement(mobileTopLeaderboard, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isArticleTitleVisible() {
    try {
      waitForElementVisibleByElement(articleTitle, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isWikiaStatsContainerVisible() {
    try {
      waitForElementVisibleByElement(wikiaStatsContainer, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isFeaturedContentVisible() {
    try {
      waitForElementVisibleByElement(featuredContent, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isCuratedContentVisible() {
    try {
      waitForElementVisibleByElement(curatedContent, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isMobileInContentVisible() {
    try {
      waitForElementVisibleByElement(mobileInContent, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isTrendingArticlesVisible() {
    try {
      waitForElementVisibleByElement(trendingArticles, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isTrendingVideosVisible() {
    try {
      waitForElementVisibleByElement(trendingVideos, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  public boolean isMobilePrefooterVisible() {
    try {
      waitForElementVisibleByElement(mobilePrefooter, Settings.TIME_OUT_IN_SEC.value,
                                     Settings.CHECK_OUT_IN_MILLI_SEC.value);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }
}