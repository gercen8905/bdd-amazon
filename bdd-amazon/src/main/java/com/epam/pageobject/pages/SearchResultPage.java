package com.epam.pageobject.pages;
/* 
@author
Marat Lagun
created on 3/16/22   
*/

import com.epam.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//*[@class='a-color-state a-text-bold']")
    private WebElement result;

    @FindBy(xpath = "//*[contains(@aria-label,'Go to next page')]")
    private WebElement nextPageButton;

    @FindBy(xpath = "//*[@class='a-row']/descendant::span[1]")
    private WebElement noResults;

    @FindBy(xpath = "//*[@class='a-row']/descendant::span[2]")
    private WebElement actualWithDot;

    protected SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getActualWithDot() {
        return actualWithDot.getText() + ".";
    }

    public String getNoResultsText() {
        return noResults.getText();
    }

    public String getResult() {
        return result.getText().replace("\"", "");
    }

    public void goToNextPageOfResults() {
        nextPageButton.click();
    }
}
