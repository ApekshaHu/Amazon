package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private By totalPrice = By.cssSelector(".sc-subtotal-price .a-size-medium");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTotalPrice() {
        return driver.findElement(totalPrice).getText();
    }
}
