package com.wikia.webdriver.pageobjectsfactory.pageobject;

import com.wikia.webdriver.common.core.configuration.Configuration;

import org.openqa.selenium.By;

public class HomePage extends WikiBasePageObject {

  public HomePage open() {
    return open(Configuration.getWikiName());
  }

  public HomePage open(String wikiName) {
    getUrl(urlBuilder.getUrlForWiki(wikiName));
    wait.forElementVisible(By.cssSelector("#WikiaBarWrapper"));

    return this;
  }
}
