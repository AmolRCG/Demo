package locator;

public class ProductsLocator {
    public static final String PRODUCT_LIST = "(//div[@class='features_items']//div[@class='productinfo text-center'])";
    public static final String PRODUCT_NAME = "//div[@class='productinfo text-center']//p";
    public static final String PRODUCT_PRICE = "//div[@class='productinfo text-center']//h2";
    public static final String ADD_TO_CART_BUTTON = "(//div[@class='productinfo text-center']//a[contains(text(), 'Add to cart')])";
    public static final String CART_BUTTON = "//a[contains(text(), 'Cart')]";
    public static final String CONTINUE_SHOPPING_BUTTON = "//button[contains(text(), 'Continue Shopping')]";
    public static final String PRODUCT_ADDED_MESSAGE = "//div[@id='cartModal']//p[contains(text(), 'Your product has been added to cart.')]";
    public static final String VIEW_PRODUCTS_BUTTON = "(//a[contains(text(), 'View Product')])";



}
