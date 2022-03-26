package steps;
/*
@author
Marat Lagun
created on 3/25/22
*/

import com.epam.pageobject.pages.HomePage;
import com.epam.pageobject.pages.SearchResultPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SearchSteps {
    private final SingleDriver instanceOfDriver = SingleDriver.getInstanceOfDriver();
    WebDriver driver;
    private HomePage homePage;
    private SearchResultPage resultPage;
    private String input;

    @Before
    public void setUp() {
        driver = instanceOfDriver.openChrome();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("user opens the amazon site")
    public void user_opens_the_amazon_site() {
        homePage = new HomePage(driver);
        homePage.open();
    }

    @When("user enters {string}")
    public void user_enters(String input) {
        this.input = input;
        resultPage = homePage.search(input);
    }

    @Then("searched product should be displayed in search results")
    public void searched_product_should_be_displayed_in_search_results() {
        Assert.assertEquals(resultPage.getResult(), input,
                "Name of product is not displayed correctly");
        resultPage.takeScreenshot();

    }

    @Then("incorrect input should return no results")
    public void incorrect_input_should_return_no_results() {
        resultPage.takeScreenshot();
        Assert.assertEquals(resultPage.getNoResultsText() + " "
                        + resultPage.getActualWithDot(),
                "No results for " + input + ".",
                "Nevertheless something was found");
    }

    @And("found products should contain input")
    public void foundProductsShouldContainInput() {
        List<WebElement> searchResult =
                driver.findElements(with(By.xpath("//*[contains(@class,'normal')]"))
                        .above(By.xpath("//i[contains(@class,'a-icon-star-small')]")));
        Assert.assertTrue(searchResult.size() > 0,
                "There is no name of product in the results of search");
    }

    @And("user navigates to the next page of results")
    public void userNavigatesToTheNextPageOfResults() {
        resultPage.goToNextPageOfResults();

    }
}
