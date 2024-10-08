package testCase;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class AmazonTest extends BaseClass {

    @Test
    public void testAddToCartAndValidatePrice() {
        // Step 1: Navigate to Amazon
        driver.get("https://www.amazon.com/");

        // Step 2: Search for "toys"
        HomePage homePage = new HomePage(driver);
        homePage.searchFor("toys");

        // Step 3: Select any 2 products and add to cart
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        List<WebElement> products = searchResultsPage.getProductItems();
        List<String> selectedPrices = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            products.get(i).click();

            // Get price from Product Details page
            ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
            String productPrice = productDetailsPage.getProductPrice();
            selectedPrices.add(productPrice);

            // Add to cart
            productDetailsPage.addToCart();

            // Validate price in the cart
            CartPage cartPage = new CartPage(driver);
            Assert.assertTrue(cartPage.getTotalPrice().contains(productPrice), 
                              "Price mismatch in cart: Expected " + productPrice + " but found " + cartPage.getTotalPrice());

            // Navigate back to search results
            driver.navigate().back();
            products = searchResultsPage.getProductItems();
        }

        // Validate prices on Search Results page
        for (String price : selectedPrices) {
            Assert.assertTrue(products.stream().anyMatch(product -> product.getText().contains(price)),
                              "Price " + price + " not found on Search Results page.");
        }
    }
}