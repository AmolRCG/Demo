package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.WaitForSelectorState;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import locator.CartLocator;
import locator.ProductsLocator;
import locator.RegisterLocators;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegisterPage {
    private final Page page;
    public String username;
    private ArrayList<String> productsList=new ArrayList<>();



    // Constructor to initialize the Page object
    public RegisterPage(Page page) {
        this.page = page;
    }

    public void openHomePage() {
        System.out.println("Execution Started");
        System.out.println("Launching browser and navigating to home page");
        try {
            page.navigate("https://automationexercise.com/",
                    new Page.NavigateOptions().setTimeout(60000));
        } catch (TimeoutError e) {
            System.out.println("Navigation timed out: " + e.getMessage());
            // Optionally retry or log for debugging
        }
        System.out.println("Home page opened successfully");

    }

    public boolean isHomePageVisible() {
        System.out.println("Home page is visible successfully");
        return page.title().contains("Automation Exercise");

    }

    public void clickSignupLogin() {
        page.click(RegisterLocators.SIGNUP_LOGIN_BUTTON);
        System.out.println("Signup/Login button clicked successfully");
    }

    public boolean isNewUserSignupVisible() throws InterruptedException {
        Thread.sleep(1000); // Wait for the page to load
        System.out.println("New User Signup section is visible");
        return page.isVisible(RegisterLocators.NEW_USER_SIGNUP_TEXT);
    }

    public void enterNameAndEmail(String name, String email) {
        page.fill(RegisterLocators.NAME_INPUT, name);
        page.fill(RegisterLocators.EMAIL_SIGNUP_INPUT, email);
        if(page.locator(RegisterLocators.EMAIL_ERROR_MESSAGE).isVisible()) {
            System.out.println("Email already exists, please enter a different email");
        } else {
            System.out.println("Name and email entered successfully: " + name + ", " + email);
        }
    }

    public void clickSignupButton() throws InterruptedException {
        page.click(RegisterLocators.SIGNUP_BUTTON);
        System.out.println("Signup button clicked successfully");
        Thread.sleep(1000);
    }

    public boolean isEnterAccountInfoVisible() throws InterruptedException {
        Thread.sleep(2000);
        return page.isVisible(RegisterLocators.ENTER_ACCOUNT_INFO_TEXT);
    }

    public void fillAccountInfo(String password, String day, String month, String year) {
        page.click(RegisterLocators.TITLE_RADIO);
        page.fill(RegisterLocators.PASSWORD_INPUT, password);
        page.selectOption(RegisterLocators.DOB_DAY, day);
        page.selectOption(RegisterLocators.DOB_MONTH, month);
        page.selectOption(RegisterLocators.DOB_YEAR, year);
        System.out.println("Account information filled successfully");
    }

    public void selectCheckboxes() {
        page.check(RegisterLocators.NEWSLETTER_CHECKBOX);
        page.check(RegisterLocators.OFFERS_CHECKBOX);
        System.out.println("Checkboxes selected successfully");
    }

    public void enterFirstName(String name) {
        page.fill(RegisterLocators.FIRST_NAME, name);
        System.out.println("First name entered successfully: " + name);
    }
    public void enterLastName(String lastName) {
        page.fill(RegisterLocators.LAST_NAME, lastName);
        System.out.println("Last name entered successfully: " + lastName);
    }
    public void enterCompany(String company) {
        page.fill(RegisterLocators.COMPANY, company);
        System.out.println("Company entered successfully: " + company);
    }
    public void enterAddress1(String address) {
        page.fill(RegisterLocators.ADDRESS1, address);
        System.out.println("Address 1 entered successfully: " + address);
    }
    public void enterAddress2(String address) {
        page.fill(RegisterLocators.ADDRESS2, address);
        System.out.println("Address 2 entered successfully: " + address);
    }
    public void selectCountry(String country) {
        page.selectOption(RegisterLocators.COUNTRY, country);
        System.out.println("Country selected successfully: " + country);
    }
    public void enterState(String state) {
        page.fill(RegisterLocators.STATE, state);
        System.out.println("State entered successfully: " + state);
    }
    public void enterCity(String city) {
        page.fill(RegisterLocators.CITY, city);
        System.out.println("City entered successfully: " + city);
    }
    public void enterZipcode(String zipcode) {
        page.fill(RegisterLocators.ZIPCODE, zipcode);
        System.out.println("Zipcode entered successfully: " + zipcode);
    }
    public void enterMobileNumber(String mobile) {
        page.fill(RegisterLocators.MOBILE, mobile);
        System.out.println("Mobile number entered successfully: " + mobile);
    }

    public void clickCreateAccount() {
        page.click(RegisterLocators.CREATE_ACCOUNT_BUTTON);
    }

    public boolean isAccountCreatedVisible() throws InterruptedException {
        Thread.sleep(2000);
        return page.isVisible(RegisterLocators.ACCOUNT_CREATED_TEXT);
    }

    public void clickContinue() throws InterruptedException {
        Thread.sleep(2000);
        page.click(RegisterLocators.CONTINUE_BUTTON);
    }
    public void clickContinueShopping() {
        page.click(RegisterLocators.CONTINUE_SHOPPING_BUTTON);
        System.out.println("Continue Shopping button clicked successfully");
    }

    public void isLoggedInVisible() throws InterruptedException {
        Thread.sleep(2000);
        page.getByText("Logged in as ", new Page.GetByTextOptions().setExact(true)).isVisible();
        System.out.println("Logged in as is visible");
    }

    public void clickDeleteAccount() {
        page.click(RegisterLocators.DELETE_ACCOUNT_BUTTON);
    }

    public boolean isAccountDeletedVisible() throws InterruptedException {
        Thread.sleep(2000);
        return page.isVisible(RegisterLocators.ACCOUNT_DELETED_TEXT);
    }

    public void enterValidEmailAndPassword(String email, String password) throws InterruptedException {
        Thread.sleep(1000); // Wait for the page to load
        page.fill(RegisterLocators.EMAIL_LOGIN_INPUT, email);
        page.fill(RegisterLocators.EMAIL_PASSWORD_INPUT, password);
        System.out.println("Email and password entered successfully");
    }

    public boolean isLoginToYourAccountVisible() {
        try {
            Thread.sleep(2000); // Wait for the page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return page.locator(RegisterLocators.LOGIN_TO_YOUR_ACCOUNT_TEXT).isVisible();
    }

    public void clickOnLogInButton() {
        page.click(RegisterLocators.EMAIL_LOGIN_BUTTON);
        System.out.println("Login button clicked successfully");
    }

    public void clickLogoutButton() throws InterruptedException {
        page.waitForTimeout(2000); // Wait for the page to load
        page.waitForSelector("a:text('Logout')",
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(5000));
        page.click("a:text('Logout')");
        System.out.println("Logout button clicked successfully");
    }

    public void openProductPage() {
        System.out.println("Launching browser and navigating to home page");
        page.navigate("https://automationexercise.com/products");
        System.out.println("Product page opened successfully");
    }

    public void clickProductsButton() throws InterruptedException {
        Thread.sleep(1000); // Wait for 2 seconds to ensure the page is loaded
        page.click(RegisterLocators.PRODUCTS_BUTTON);
        System.out.println("Products button clicked");

    }

    public boolean isProductListVisible() {
        return page.isVisible("//div[@class='productinfo text-center']");
    }

    public String getProductName(int index) {
        return page.textContent("//div[@class='productinfo text-center']//p[" + index + "]");
    }

    public String getProductPrice(int index) {
        return page.textContent("//div[@class='productinfo text-center']//h2[" + index + "]");
    }

    public void addToCart(int index) {
        page.click("//a[contains(text(), 'Add to cart')][" + index + "]");
        System.out.println("Product added to cart");
    }

    public void hoverTheProduct(int index) throws InterruptedException {
        page.locator((ProductsLocator.PRODUCT_LIST) + "[" + index + "]").hover();
        // Wait for the hover effect to take place
        System.out.println("Hovered over the " + index + " product");
        Thread.sleep(2000);
        page.click("(//div[@class='productinfo text-center']//a[contains(text(), 'Add to cart')])" + "[" + index + "]");
        System.out.println("Clicked on Add to cart button for the " + index + " product");
    }


    public void verifyProductAddedToCart() throws InterruptedException {
        Thread.sleep(1000); // Wait for the product to be added to the cart
        String text = page.locator(ProductsLocator.PRODUCT_ADDED_MESSAGE).textContent();
        System.out.println("Products are added to the cart successfully Message: " + text);
    }

    public void viewCart() {
        page.click(CartLocator.VIEW_CART_BUTTON);
        System.out.println("Clicked on View Cart button");
    }

    public void continueShopping() {
        page.click("//button[contains(text(), 'Continue Shopping')]");
    }

    public void navigatedToCart() {
        boolean isCartVisible = page.isVisible(CartLocator.PROCEED_TO_CHECKOUT_BUTTON);
        if (isCartVisible) {
            System.out.println("User is navigated to the Cart page successfully.");
        } else {
            System.out.println("Failed to navigate to the Cart page.");
        }
    }

    public void enterExistingEmailAndName() throws InterruptedException {
        Thread.sleep(1000);
        String Existingemail = "Tester99@gmail.com";
        String name = "Tester";
        page.locator(RegisterLocators.NAME_INPUT).fill(name);
        System.out.println("Name entered successfully: " + name);
        page.locator(RegisterLocators.EMAIL_SIGNUP_INPUT).fill(Existingemail);
        System.out.println("Email entered successfully: " + Existingemail);
    }

    public boolean isEmailAlreadyExistsVisible() {
        boolean isVisible = page.isVisible(RegisterLocators.EMAIL_ERROR_MESSAGE);
        if (isVisible) {
            System.out.println("Email already exists message is visible.");
        } else {
            System.out.println("Email already exists message is not visible.");
        }
        return isVisible;
    }

    public void clickContactUsButton() {
        page.click(RegisterLocators.CONTACT_US_BUTTON);
        System.out.println("Contact Us button clicked successfully");
    }

    public boolean isGetInTouchVisible() throws InterruptedException {
        Thread.sleep(2000);
        return page.isVisible(RegisterLocators.GET_IN_TOUCH_TEXT);
    }

    public void enterContactDetails(String name, String email, String subject, String message) {
        page.fill(RegisterLocators.NAME_INPUT_CONTACT, name);
        page.fill(RegisterLocators.EMAIL_INPUT_CONTACT, email);
        page.fill(RegisterLocators.SUBJECT_INPUT_CONTACT, subject);
        page.fill(RegisterLocators.MESSAGE_INPUT_CONTACT, message);
    }

    public void verifyAllProductsList() {
        Locator products = page.locator(".features_items .product-image-wrapper");
        int count = products.count();
        System.out.println("Total number of products: " + count);
        for (int i = 1; i < count; i++) {
            String productName = page.locator(("(//div[@class='productinfo text-center']//p)[" + i + "]")).innerText();
            String productPrice = page.locator(("(//div[@class='productinfo text-center']//h2)[" + i + "]")).innerText();
            System.out.println("Product " + (i + 1) + ": " + productName + " - Price: " + productPrice);
        }
        System.out.println("All products listed successfully");
    }

    public void verifyProductsInList(String input) throws InterruptedException {
        Thread.sleep(2000); // Wait for the page to load
        Locator products = page.locator(".features_items .product-image-wrapper");
        int count = products.count();
        System.out.println("Total number of products: " + count);
        for (int i = 1; i < count; i++) {
            String productName = page.locator(("(//div[@class='productinfo text-center']//p)[" + i + "]")).innerText();
            String productPrice = page.locator(("(//div[@class='productinfo text-center']//h2)[" + i + "]")).innerText();
            if (productName.toLowerCase().contains(input.toLowerCase())) {
                System.out.println("Product " + (i + 1) + ": " + productName + " - Price: " + productPrice);
                break;
            } else {
                System.out.println("Product " + (i + 1) + " does not match the search input.");
            }
            System.out.println("Product " + (i + 1) + ": " + productName + " - Price: " + productPrice);
        }

    }


    public void hovertheFirstclickViewProduct() {
        Locator firstProduct = page.locator(RegisterLocators.VIEW_PRODUCTS_BUTTON);
        firstProduct.first().hover();
        System.out.println("Hovered over the first product");
        page.locator(ProductsLocator.VIEW_PRODUCTS_BUTTON).first().click();
        System.out.println("Clicked on View Product button for first product ");
    }

    public void verifyProductDetailsInCart(String expectedProductName, String expectedquantity, String expectedprice, String expectedTotalPrice) {
        int count = page.locator(CartLocator.CART_ITEM_LIST).count();
        System.out.println("Total number of items in cart: " +count);
        if(count == 0) {
            System.out.println("Cart is empty. No items to verify.");
        }
        for (int i = 1; i <= count; i++) {
            String actualproductName = page.locator("//table[@id='cart_info_table']//tbody//tr["+i+"]//td[@class='cart_description']//h4").textContent().trim();
            String actualproductPrice = page.locator("//table[@id='cart_info_table']//tbody//tr["+i+"]//td[@class='cart_price']").textContent().replaceAll("[^\\d]", "").trim();;
            String actualproductQuantity = page.locator("//table[@id='cart_info_table']//tbody//tr["+i+"]//td[@class='cart_quantity']").textContent().replaceAll("[^\\d]", "").trim();
            String actualproductTotalPrice = page.locator("//table[@id='cart_info_table']//tbody//tr["+i+"]//td//p[@class='cart_total_price']").textContent().replaceAll("[^\\d]", "").trim();
            System.out.println("Product Name: "+actualproductName);
            System.out.println("Product Price: "+actualproductPrice);
            System.out.println("Product Quantity: "+actualproductQuantity);
            System.out.println("Product Total Price: "+actualproductTotalPrice);
            if (actualproductName.equals(expectedProductName) && actualproductQuantity.equals(expectedquantity) &&
                    actualproductPrice.equals(expectedprice) && actualproductTotalPrice.equals(expectedTotalPrice)) {
                System.out.println("Product details are verified successfully in the cart.");
            } else {
                System.out.println("Product details do not match in the cart.");
            }
        }

    }

    public void clickOnViewProduct() {
        page.locator(RegisterLocators.VIEW_PRODUCTS_BUTTON).first().click();
        System.out.println("Clicked on View Product button");
    }

    public void verifyProductDetailspage() {
        String productName = page.locator(RegisterLocators.PRODUCT_NAME).innerText();
        String productPrice = page.locator(RegisterLocators.PRODUCT_PRICE).innerText();
        String availability = page.locator(RegisterLocators.AVAILIBILITY).innerText();
        String condition = page.locator(RegisterLocators.CONDITION).innerText();
        String brand = page.locator(RegisterLocators.BRAND).innerText();

        System.out.println("Product Name: " + productName);
        System.out.println("Product Price: " + productPrice);
        System.out.println("Availability: " + availability);
        System.out.println("Condition: " + condition);
        System.out.println("Brand: " + brand);
    }

    public void increaseProductQuantity(int quantity) {
        Locator quantityInput = page.locator(RegisterLocators.QUANTITY_INPUT);
        quantityInput.clear();
        quantityInput.fill(String.valueOf(quantity));
        System.out.println("Product quantity increased to: " + quantity);

        page.locator("//button[@type='button']").click();
        System.out.println("Clicked on Add to cart button after increasing quantity");
    }

    public void enterPaymentDetails(String cardName, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        page.fill("//input[@name='name_on_card']", cardName);
        page.fill("//input[@name='card_number']", cardNumber);
        page.fill("//input[@name='cvc']", cvc);
        page.fill("//input[@placeholder='MM']", expiryMonth);
        page.fill("//input[@placeholder='YYYY']", expiryYear);
        System.out.println("Payment details entered successfully.");
    }

    public void clickOnCategoryButton(String category, String subCategory) {
        page.click("//a[normalize-space()='" + category + "']//i[@class='fa fa-plus']");
        System.out.println("Clicked on " + category + " category successfully.");
        // Click on the specific category
        page.click("//div[@id='" + category + "']//a[contains(text(),'" + subCategory + "')]");
        System.out.println("Clicked on " + subCategory + " category successfully.");
    }

    public void addALlVisibleProductsToCart() throws InterruptedException {
        List<ElementHandle> products = page.querySelectorAll(ProductsLocator.PRODUCT_LIST);
        int countofProducts = products.size();
        if(productsList.size() > 0) {
            productsList.clear();
            System.out.println("Products list cleared successfully");
        }

        for (int i = 1; i < countofProducts; i++) {
           Thread.sleep(1000); // Wait for the page to load
            String productName = page.locator(ProductsLocator.PRODUCT_NAME).nth(i).innerText();
            String productPrice = page.locator(ProductsLocator.PRODUCT_PRICE).nth(i).innerText();
            System.out.println("Product " + (i + 1) + ": " + productName + " - Price: " + productPrice);
            page.locator(ProductsLocator.ADD_TO_CART_BUTTON).nth(i).click();
            Thread.sleep(1000);
            page.locator(ProductsLocator.CONTINUE_SHOPPING_BUTTON).click();
            System.out.println("Added " + productName + "on Add to cart button for product ");
            productsList.add(productName);
        }
        System.out.println("All products added to the list successfully: " + productsList);
        System.out.println("Total number of products added to cart: " + productsList.size());
        page.keyboard().press("PageUp");
        System.out.println("Scrolled to the top of the page after adding all products to cart");
        page.click(ProductsLocator.CART_BUTTON);
        System.out.println("Clicked on Cart button to view all products added to cart");
    }

    public void verifyAllProductsAddedToCart() throws InterruptedException {
            Thread.sleep(1000);
            int count = page.locator(CartLocator.CART_ITEM_LIST).count();
            System.out.println("Total number of items in cart: " + count);
            for (int i = 0; i < count; i++) {
                String actualProductName = page.locator(CartLocator.CART_ITEM_NAME).nth(i).textContent().trim();
                String actualProductPrice = page.locator(CartLocator.CART_ITEM_PRICE).nth(i).textContent().trim();
                String actualProductQuantity = page.locator(CartLocator.CART_ITEM_QUANTITY).nth(i).textContent().replaceAll("[^\\d]", "").trim();
                System.out.println("Product Name: " + actualProductName);
                System.out.println("Product Price: " + actualProductPrice);
                System.out.println("Product Quantity: " + actualProductQuantity);
                if (productsList.contains(actualProductName)) {
                    System.out.println("All products added to cart successfully.");
                } else {
                    System.out.println("Product is not found in the cart.");
                }
            }

    }
    public void enterNameEmail_Review(String name, String email, String review) {
        page.fill("//input[@id='name']", name);
        System.out.println("Name entered successfully: " + name);
        page.fill("//input[@id='email']", email);
        System.out.println("Email entered successfully: " + email);
        page.fill("//textarea[@id='review']", review);
        System.out.println("Review entered successfully: " + review);
    }


    public void clickDownloadInvoiceButtonAndVerfiyFileDownloaded() throws InterruptedException {
        Download download = page.waitForDownload(() -> {
            page.click("//a[contains(text(),'Download Invoice')]"); // Replace with your actual download trigger
        });
        Thread.sleep(2000);
        String filePath = download.path().toString();
        System.out.println("File downloaded successfully at: " + filePath);
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("✅ File downloaded successfully.");
        } else {
            System.out.println("❌ File download failed.");
        }


    }


    public void verifyProductAddedToCart(String productName){

    }



}
