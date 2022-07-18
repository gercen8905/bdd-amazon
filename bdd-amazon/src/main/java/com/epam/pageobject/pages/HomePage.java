package com.epam.pageobject.pages;


import com.epam.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    WebDriver driver;
    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open() {
        this.driver.get("https://www.amazon.com");
    }

    public SearchResultPage search(String input) {
        WebElement searchField = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchField.clear();
        searchField.sendKeys(input);
        searchButton.click();
        return new SearchResultPage(driver);

    }
}
