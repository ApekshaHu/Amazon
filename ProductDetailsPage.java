package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private WebDriver driver;
    private By price = By.id("priceblock_ourprice");
    private By addToCartButton = By.id("add-to-cart-button");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductPrice() {
        return driver.findElement(price).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}
