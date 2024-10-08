package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private By productItems = By.cssSelector(".s-main-slot .s-result-item");
    
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getProductItems() {
        return driver.findElements(productItems);
    }
}
