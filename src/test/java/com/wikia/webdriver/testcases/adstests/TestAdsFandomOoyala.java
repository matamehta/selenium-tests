package com.wikia.webdriver.testcases.adstests;

import com.wikia.webdriver.common.core.CommonExpectedConditions;
import com.wikia.webdriver.common.core.annotations.InBrowser;
import com.wikia.webdriver.common.core.drivers.Browser;
import com.wikia.webdriver.common.core.elemnt.Wait;
import com.wikia.webdriver.common.core.helpers.Emulator;
import com.wikia.webdriver.common.templates.fandom.AdsFandomTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.helpers.AdsComparison;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestAdsFandomOoyala extends AdsFandomTestTemplate {
  private static final String PLAY_BUTTON_SELECTOR = ".ooyala-video .oo-action-icon";
  private static final String PLAYER_SELECTOR = ".ooyala-video .oo-player";
  private static final String AUTOPLAY_PLAYER_SELECTOR = ".ooyala-video[data-autoplay]";
  private static final Color BLUE = new Color(0, 1, 253);
  private static final int AD_DURATION_SEC = 30;

  @Test(
      groups = {"AdsFandomOoyalaClickToPlayPrerollDesktop"}
  )
  public void adsFandomOoyalaPrerollClickToPlayDesktop() {
    testOoyalaClickToPlayPreroll();
  }

  @Test(
      groups = {"AdsFandomOoyalaAutoplayPrerollDesktop"}
  )
  public void adsFandomOoyalaAutoplayPrerollDesktop() {
    testOoyalaAutoplayPreroll();
  }

  @InBrowser(
      browser = Browser.CHROME,
      emulator = Emulator.GOOGLE_NEXUS_5
  )
  @Test(
      groups = {"AdsFandomOoyalaClickToPlayPrerollMobile"}
  )
  public void adsFandomOoyalaPrerollClickToPlayMobile() {
    testOoyalaClickToPlayPreroll();
  }

  @InBrowser(
      browser = Browser.CHROME,
      emulator = Emulator.GOOGLE_NEXUS_5
  )
  @Test(
      groups = {"AdsFandomOoyalaAutoplayPrerollMobile"}
  )
  public void adsFandomOoyalaAutoplayPrerollMobile() {
    testOoyalaAutoplayPreroll();
  }

  public void testOoyalaClickToPlayPreroll() {
    loadPage("the-best-movies-of-2017-so-far");
    Wait wait = new Wait(driver);
    WebElement playButton = driver.findElement(By.cssSelector(PLAY_BUTTON_SELECTOR));

    wait.forElementVisible(playButton);
    playButton.click();

    verifyColorAd(driver.findElement(By.cssSelector(PLAYER_SELECTOR)), BLUE, AD_DURATION_SEC);
  }

  public void testOoyalaAutoplayPreroll() {
    loadPage("orphan-black-clones-names");
    verifyColorAd(
        driver.findElement(By.cssSelector(AUTOPLAY_PLAYER_SELECTOR)),
        BLUE,
        AD_DURATION_SEC
    );
  }

  private void verifyColorAd(WebElement element, Color color, int durationSec) {
    AdsComparison adsComparison = new AdsComparison();
    waitForColorAds(element, color);
    adsComparison.verifyColorAd(element, color, durationSec, driver);
  }

  private void waitForColorAds(WebElement element, Color color) {
    WebDriverWait waitFor = new WebDriverWait(driver, 15);
    driver.manage().timeouts().implicitlyWait(500, TimeUnit.MICROSECONDS);

    try {
      waitFor.until(CommonExpectedConditions
                        .elementToHaveColor(element, color,
                                            AdsComparison.IMAGES_THRESHOLD_PERCENT));
    } finally {
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
  }
}
