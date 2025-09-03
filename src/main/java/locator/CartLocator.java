package locator;

public class CartLocator {
    public static final String CART_ITEM_LIST = "(//table//tbody//tr)";
    public static final String CART_ITEM_NAME = "(//table[@id='cart_info_table']//tr//td[@class='cart_description']//h4)";
    public static final String CART_ITEM_PRICE = "(//table[@id='cart_info_table']//tr//td[@class='cart_price'])";
    public static final String CART_ITEM_QUANTITY = "(//table[@id='cart_info_table']//tr//td[@class='cart_quantity'])";
    public static final String CHECKOUT_BUTTON = "//button[contains(text(), 'Checkout')]";
    public static final String EMPTY_CART_MESSAGE = "//b[normalize-space()='Cart is empty!']";
    public static final String CONTINUE_SHOPPING_BUTTON = "//button[contains(text(), 'Continue Shopping')]";
    public static final String VIEW_CART_BUTTON = "//div[@id='cartModal']//u[contains(text(),'View Cart')]";
    public static final String PROCEED_TO_CHECKOUT_BUTTON = "//a[contains(text(),'Proceed To Checkout')]";

}
