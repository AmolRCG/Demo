package stepdefinitions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.cucumberexpressions.CucumberExpressionGenerator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.An;
import locator.CartLocator;
import locator.ProductsLocator;
import locator.RegisterLocators;
import org.junit.Assert;
import pages.RegisterPage;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class RegisterSteps {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;
    private static RegisterPage registerPage;
    private String email = "amol@test3335.com";
    private String password = "Test@123";
    private Map<String, String> storedAddressDetails;

    private Map<String,String> dataTable;
    @Given("user launches the browser and opens the home page")
    public void launchBrowser() {
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        page = browser.newPage();
//        registerPage = new RegisterPage(page);
//        registerPage.openHomePage();
            playwright = Playwright.create();
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(Arrays.asList("--start-maximized")));
            // Create context with null viewport for maximum size
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setViewportSize(null));

            page = context.newPage();
            registerPage = new RegisterPage(page);
            registerPage.openHomePage();
    }

    @Then("user verifies that home page is visible successfully")
    public void verifyHomePage() {
        assertTrue(registerPage.isHomePageVisible());
    }

    @When("user clicks on Signup_Login button")
    public void clickSignupLogin() {
        registerPage.clickSignupLogin();
    }

    @Then("user verifies 'New User Signup' is visible")
    public void verifyNewUserSignup() throws InterruptedException {
        assertTrue(registerPage.isNewUserSignupVisible());
    }

    @When("user enters name and email address")
    public void enterNameAndEmail() {
        registerPage.enterNameAndEmail("Amol", email);
    }

    @And("user clicks 'Signup' button")
    public void clickSignup() throws InterruptedException {
        registerPage.clickSignupButton();
    }

    @Then("user verifies that 'ENTER ACCOUNT INFORMATION' is visible")
    public void verifyEnterAccountInfo() throws InterruptedException {
        assertTrue(registerPage.isEnterAccountInfoVisible());
    }

    @When("user fills account information")
    public void fillAccountInfo() {
        registerPage.fillAccountInfo("Test@123", "10", "5", "1995");
    }

    @And("user selects newsletter and special offers checkboxes")
    public void selectCheckboxes() {
        registerPage.selectCheckboxes();
    }

    @And("user fills address details")
    public void fillAddressDetails(DataTable dataTable) {
        storedAddressDetails = dataTable.asMap(String.class, String.class);

        registerPage.enterFirstName(storedAddressDetails.get("First Name"));
        registerPage.enterLastName(storedAddressDetails.get("Last Name"));
        registerPage.enterCompany(storedAddressDetails.get("Company"));
        registerPage.enterAddress1(storedAddressDetails.get("Address1"));
        registerPage.enterAddress2(storedAddressDetails.get("Address2"));
        registerPage.selectCountry(storedAddressDetails.get("Country"));
        registerPage.enterState(storedAddressDetails.get("State"));
        registerPage.enterCity(storedAddressDetails.get("City"));
        registerPage.enterZipcode(storedAddressDetails.get("Zipcode"));
        registerPage.enterMobileNumber(storedAddressDetails.get("Mobile Number"));
        System.out.println("Address details filled successfully: " + dataTable);

    }

    @And("user clicks 'Create Account' button")
    public void clickCreateAccount() {
        registerPage.clickCreateAccount();
    }

    @Then("user verifies that 'ACCOUNT CREATED' is visible")
    public void verifyAccountCreated() throws InterruptedException {
        assertTrue(registerPage.isAccountCreatedVisible());
    }

    @When("user clicks 'Continue' button")
    public void clickContinue() throws InterruptedException {
        registerPage.clickContinue();
    }


    @Then("user verifies that Logged in as username is visible")
    public void verifyLoggedIn() throws InterruptedException {
        registerPage.isLoggedInVisible();
    }

    @When("user clicks 'Delete Account' button")
    public void clickDeleteAccount() {
        registerPage.clickDeleteAccount();
    }

    @Then("user verifies that 'ACCOUNT DELETED' is visible")
    public void verifyAccountDeleted() throws InterruptedException {
        assertTrue(registerPage.isAccountDeletedVisible());
    }

    @Then("user verifies Login to your account is visible")
    public void verifyLoginToYourAccount() {
        assertTrue(registerPage.isLoginToYourAccountVisible());
    }

    @When("user enters valid email address and password")
    public void user_enters_Valid_Email_Password() throws InterruptedException {
        registerPage.enterValidEmailAndPassword("Tester99@gmail.com", "Tester@123");
    }

    @And("user clicks login button")
    public void clickLogin() throws InterruptedException {
       Thread.sleep(1000); // Wait for the input to be filled
        page.click("//a[@href='/login']");
        System.out.println("Login button clicked successfully");
        Thread.sleep(1000);
    }

    @And("user clicks on Logout button")
    public void clickLogout() throws InterruptedException {
        registerPage.clickLogoutButton();
    }

    @When("user clicks on Products button")
    public void userClicksOnProductsButton() throws InterruptedException {
        registerPage.clickProductsButton();
    }

    @When("the user hovers over the first product and clicks Add to cart")
    public void userAddsFirstProductToCart() throws InterruptedException {
        registerPage.hoverTheProduct(1);
    }

    @Then("the user verifies that Product added to cart message is visible")
    public void userVerifiesProductAddedToCart() throws InterruptedException {
       registerPage.verifyProductAddedToCart();
    }

    @Then("the user clicks View Cart button")
    public void userClicksViewCart() {
        registerPage.viewCart();

    }

    @Then("the user should be navigated to the Cart page successfully")
    public void navigatedToCart() {
        registerPage.navigatedToCart();
    }

    @Then("the product should be listed in the cart with correct details")
    public void verify_Product_Details_In_Cart() {
     registerPage.verifyProductDetailsInCart("Blue Top", "1", "500", "500"); // Adjust the expected values as needed

    }


//    @When("user enters existing Name and email address")
//    public void user_enters_existing_name_and_email_address() {
//        String Existingemail = "Tester99@gmail.com";
//        String name = "Tester";
//        page.locator(RegisterLocators.NAME_INPUT).fill(name);
//        System.out.println("Name entered successfully: " + name);
//        page.locator(RegisterLocators.EMAIL_SIGNUP_INPUT).fill(Existingemail);
//        System.out.println("Email entered successfully: " + Existingemail);
//    }

//    @Then("an error message 'Email Address already exist' should be visible")
//    public void an_error_message_should_be_visible(){
//      //  assertTrue(registerPage.isEmailAlreadyExistsVisible());
//
//        boolean isVisible = page.isVisible(RegisterLocators.EMAIL_ERROR_MESSAGE);
//        if (isVisible) {
//            System.out.println("Email already exists message is visible.");
//        } else {
//            System.out.println("Email already exists message is not visible.");
//        }
//    }

    @When("user enters existing Name and email address")
    public void user_enters_existing_name_and_email_address() {
        String Existing_email = "Tester99@gmail.com";
        String name = "Tester";

        assertTrue(page.locator(RegisterLocators.NAME_INPUT).isVisible());
        assertTrue(page.locator(RegisterLocators.EMAIL_SIGNUP_INPUT).isVisible());
        page.locator(RegisterLocators.NAME_INPUT).fill(name);
        System.out.println("Name entered successfully: " + name);
        page.locator(RegisterLocators.EMAIL_SIGNUP_INPUT).fill(Existing_email);
        System.out.println("Email entered successfully: " + Existing_email);
    }

    @Then("an error message {string} should be visible")
    public void an_error_message_should_be_visible(String expectedMessage) {
        boolean isVisible = page.isVisible(RegisterLocators.EMAIL_ERROR_MESSAGE);
        if (isVisible) {
            System.out.println("Email already exists message is visible.");
            String actualMessage = page.locator(RegisterLocators.EMAIL_ERROR_MESSAGE).textContent();
            assertEquals(expectedMessage, actualMessage);
        } else {
            System.out.println("Email already exists message is not visible.");
            fail("Email already exists message is not visible.");
        }
    }

    @When("user enters invalid email address and password")
    public void user_enters_invalid_email_address_and_password() throws InterruptedException {
        System.out.println("Entering invalid email and password...");
        registerPage.enterValidEmailAndPassword("Amol@12Gmail.com", "AAAAAA");
        Thread.sleep(1000); // Wait for the input to be filled
        System.out.println("Invalid email and password entered successfully.");
    }

    @Then("user verifies that {string} message is visible")
    public void user_verifies_your_email_or_password_is_incorrect_message_is_visible(String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        Locator ErrorMessage = page.locator(RegisterLocators.EMAIL_OR_PASSWORD_ERROR_MESSAGE);
        ErrorMessage.waitFor(new Locator.WaitForOptions().setTimeout(5000));
        String actualMessage=ErrorMessage.textContent();
        assertEquals(expectedMessage, actualMessage);
        System.out.println("Error message is visible: " + actualMessage);
    }

    @When("user clicks on Contact Us button")
    public void userClicksOnContactUsButton() {
        registerPage.clickContactUsButton();
    }

    @Then("user verifies that GET IN TOUCH is visible")
    public void userVerifiesGetInTouchIsVisible() throws InterruptedException {
        assertTrue(registerPage.isGetInTouchVisible());
    }

    @When("user enters name, email, subject, and message")
    public void userEntersNameEmailSubjectAndMessage() {
        registerPage.enterContactDetails("Tester", "Tester99@gmail.com", "Test Subject", "This is a test message.");
    }
    @When("user uploads a file")
    public void userUploadsAFile() {
         // Assuming the file path is valid and the file exists
         String filePath = "src/test/resources/Data/Tester.txt"; // Update with the actual file path
         page.setInputFiles("input[type='file']", Paths.get(filePath));
         System.out.println("File uploaded successfully: " + filePath);
     }
     @And("user clicks Submit button")
    public void userClicksSubmitButton() throws InterruptedException {
        page.click(RegisterLocators.SUBMIT_BUTTON_CONTACT);
        System.out.println("Submit button clicked successfully");
        Thread.sleep(1000); // Wait for the alert to appear
    }

    @Then("user verifies that success message {string} is visible")
    public void userVerifiesSuccessMessage(String expectedMessage) throws InterruptedException {
       Thread.sleep(2000);
        page.onDialog(dialog -> {
            System.out.println("Alert message: " + dialog.message());
            dialog.accept();
            System.out.println("Alert accepted successfully.");
        });
       Locator text = page.locator(RegisterLocators.SUCCESS_MESSAGE_CONTACT);
       Thread.sleep(1000); // Wait for the success message to appear
       String actualMessage=text.textContent();
       System.out.println("Actual message: " + actualMessage);
       assertEquals(expectedMessage, actualMessage);
       System.out.println("Success message is visible: " + actualMessage);
    }

    @Then("user verify all products list is visible")
    public void userVerifyAllProductsListIsVisible() {
        registerPage.verifyAllProductsList();

    }

    @When("user hovers the mouse and clicks first View Product button")
    public void userHoversMouseAndClicksFirstViewProductButton() {
        registerPage.hovertheFirstclickViewProduct();
    }

   @Then("user should be landed on the product detail page successfully and verify product details")
    public void verifyProductDetails() {
        page.locator(RegisterLocators.PRODUCT_NAME).isVisible();
        page.locator(RegisterLocators.PRODUCT_PRICE).isVisible();
        page.locator(RegisterLocators.AVAILIBILITY).isVisible();
        page.locator(RegisterLocators.CONDITION).isVisible();
        page.locator(RegisterLocators.BRAND).isVisible();
        System.out.println("Product details are visible successfully.");
    }

    @When("user enters the {string} in the search input and clicks the search button")
    public void user_enters_the_in_the_search_input_and_clicks_the_search_button(String productName) {
        System.out.println("Entering product name in the search input: " + productName);
        page.fill(RegisterLocators.SEARCH_PRODUCT_INPUT, productName);
        System.out.println("Product name entered successfully.");
        page.click(RegisterLocators.SEARCH_SUBMIT_BUTTON);
        System.out.println("Search button clicked successfully.");
    }
    @Then("{string} should be visible")
    public void should_be_visible(String productName) throws InterruptedException {
       registerPage.verifyProductsInList(productName);
    }

    @When("user scrolls down to footer")
    public void userScrollsDownToFooter() {
        page.keyboard().press("PageDown");
        System.out.println("Scrolled down to footer successfully.");
    }
    @And("user verifies text SUBSCRIPTION")
    public void userVerifiesTextSubscription() {
        page.locator(RegisterLocators.SUBSCRIPTION_TEXT).isVisible();
        System.out.println("Subscription text is visible.");
    }

    @And("user enters email address in input and clicks Subscribe button")
    public void userEntersEmailAndClicksSubscribe() {
        String subscriptionEmail = "amol@11gmail.com";
        page.fill(RegisterLocators.SUBSCRIPTION_EMAIL_INPUT, subscriptionEmail);
        page.locator(RegisterLocators.SUBSCRIPTION_BUTTON).click();
    }

    @Then("user verifies that You have been successfully subscribed message is visible")
    public void userVerifiesYouHaveBeenSuccessfullySubscribedMessageIsVisible() {
        String expectedMessage = "You have been successfully subscribed!";
        String actualMessage = page.locator(RegisterLocators.SUBSCRIPTION_SUCCESS_MESSAGE).textContent();
        assertEquals(expectedMessage, actualMessage);
        System.out.println("Subscription success message is visible: " + actualMessage);
    }

    @And("user clicks Continue Shopping button")
    public void userClicksContinueShoppingButton() {
        page.click(CartLocator.CONTINUE_SHOPPING_BUTTON);
        System.out.println("Continue Shopping button clicked successfully");
    }

    @And("user hovers over the second product and clicks Add to cart")
    public void userHoversOverSecondProductAndClicksAddToCart() throws InterruptedException {
      registerPage.hoverTheProduct(2);
    }

    @Then("user verifies products are added to the cart successfully")
    public void userVerifiesProductsAreAddedToCartSuccessfully() throws InterruptedException {
        registerPage.verifyProductAddedToCart();
    }


    @And("user verifies that both products are listed in the cart with correct details")
    public void userVerifyProductsAreListedInCartWithCorrectDetails(DataTable dataTable) {
        List<Map<String, String>> productDetails = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : productDetails) {
            String productName = product.get("Product Name");
            String quantity = product.get("Quantity");
            String price = product.get("Price");
            String totalPrice = product.get("Total Price");
//            System.out.println("Verifying product details in cart "+product);
//            System.out.println("Product Name: " + productName);
//            System.out.println("Quantity: " + quantity);
//            System.out.println("Price: " + price);
//            System.out.println("Total Price: " + totalPrice);
            registerPage.verifyProductDetailsInCart(productName, quantity, price, totalPrice);
        }
    }
    @And("the user click on view product for any product")
    public void userClicksOnViewProductForAnyProduct() {
        registerPage.clickOnViewProduct();
    }
    @Then("user should be landed on the product detail page successfully")
    public void userShouldBeLandedOnTheProductDetailPageSuccessfully() {
        registerPage.verifyProductDetailspage();
    }

    @And("user increases the quantity to {int} clicks on Add to cart button")
    public void userIncreasesTheQuantity(int quantity) {
        registerPage.increaseProductQuantity(4);
    }
     @Then("user verifies product is added with exact quantity in cart")
    public void userVerifiesProductIsAddedWithExactQuantityInCart() {
         String expectedQuantity = "4";
         String actualQuantity = page.locator("//tbody//tr//td[@class='cart_quantity']//button").textContent();
         assertEquals(expectedQuantity, actualQuantity);
         System.out.println("Product quantity in cart is correct: " + actualQuantity);
     }

     @Then("the user verifies that cart page is visible")
    public void userVerifiesCartPageIsVisible() {
        assertTrue(page.isVisible(CartLocator.CART_ITEM_LIST));
        System.out.println("Cart page is visible successfully.");}

    @And("user clicks on Proceed To Checkout button")
    public void userClicksOnProceedToCheckoutButton() {
        page.click(CartLocator.PROCEED_TO_CHECKOUT_BUTTON);
        page.waitForTimeout(2000);
        System.out.println("Proceed To Checkout button clicked successfully.");
    }
    @When("user clicks on Register  Login button")
    public void userClicksOnRegisterLoginButton() {
        page.locator("//u[normalize-space()='Register / Login']").click();
        System.out.println("Register / Login button clicked successfully.");
    }
    @When("the user clicks on Cart button")
    public void userClicksOnCartButton() {
        page.click("//a[contains(text(),'Cart')]");
        System.out.println("Cart button clicked successfully.");
    }

    @And("user verifies address details and order review is visible")
    public void userVerifiesAddressDetailsAndOrderReviewIsVisible() {
        assertTrue(page.isVisible("//section[@id='cart_items']//h2[contains(text(),'Address Details')]"));
        assertTrue(page.isVisible("//section[@id='cart_items']//h2[contains(text(),'Review Your Order')]"));
        System.out.println("Address details and order review are visible successfully.");
    }

    @When("user enters a description in the comment text area")
    public void userEntersDescriptionInCommentTextArea() {
        String comment = "This is a test comment.";
        page.fill("//textarea[@name='message']", comment);
        System.out.println("Comment entered successfully: " + comment);
    }

    @And("user clicks on Place Order button")
    public void userClicksOnPlaceOrderButton() {
        page.click("//section[@id='cart_items']//a[contains(text(),'Place Order')]");
        System.out.println("Place Order button clicked successfully.");
    }

    @Then("user verifies payment details is visible")
    public void userVerifiesPaymentDetailsIsVisible() {
        assertTrue(page.isVisible("//h2[contains(text(),'Payment')]"));
        System.out.println("Payment details are visible successfully.");
        assertTrue(page.isVisible("//label[normalize-space()='Name on Card']"));
        assertTrue(page.isVisible("//label[normalize-space()='Card Number']"));
        assertTrue(page.isVisible("//label[normalize-space()='CVC']"));
        assertTrue(page.isVisible("//label[normalize-space()='Expiration']"));
        System.out.println("Payment form fields are visible successfully.");
    }

    @And("user enters payment details")
    public void userEntersPaymentDetails() {
       registerPage.enterPaymentDetails("Amol", "12345678901234", "123", "12","2030");
        System.out.println("Payment details entered successfully.");
    }

    @And("user clicks on 'Pay and Confirm Order' button")
    public void userClicksOnPayAndConfirmOrderButton() {
        page.click("//button[contains(text(),'Pay and Confirm Order')]");
        System.out.println("Pay and Confirm Order button clicked successfully.");
    }

    @Then("user verifies that 'Your order has been placed successfully!' message is visible")
    public void userVerifiesOrderPlacedSuccessfully() {
        String expectedMessage = "Congratulations! Your order has been confirmed!";
        String actualMessage = page.locator("//p[contains(text(),'Congratulations! Your order has been confirmed!')]").textContent();
        assertEquals(expectedMessage, actualMessage);
        System.out.println("Order placed success message is visible: " + actualMessage);
    }

    @And("the user clicks on Remove Product button")
    public void userClicksOnRemoveProductButton() {
        page.click("//tbody//tr//td//a[@class='cart_quantity_delete']");
        System.out.println("Remove Product button clicked successfully.");
    }
    @Then("the user verifies that product is removed from cart successfully")
    public void userVerifiesProductIsRemovedFromCartSuccessfully() {
        page.locator(CartLocator.EMPTY_CART_MESSAGE).isVisible();
        System.out.println("Product removed from cart successfully.");
        String expectedMessage = "Cart is empty!";
        String actualMessage = page.locator(CartLocator.EMPTY_CART_MESSAGE).textContent();
        assertEquals(expectedMessage, actualMessage);
        System.out.println("Empty cart message is visible: " + actualMessage);
    }
    @Then("verify the {string} is visible on left side of the page")
    public void verifyCategoryIsVisible(String text) {
        assertTrue(page.isVisible("//div[@class='left-sidebar']//h2[contains(text(),'"+text+"')]"));
        System.out.println(""+text+" is visible on the left side of the page.");
    }

    @When("user clicks on {string} category button and click on {string} category")
    public void userClicksOnWomenCategoryButtonAndClickOnCategory(String category, String WomenCategory) {
      registerPage.clickOnCategoryButton(category, WomenCategory);
    }

    @When("user clicks on the {string} category button and click on {string} category")
    public void userClicksOnMenCategoryButtonAndClickOnCategory(String category, String MenCategory) {
        registerPage.clickOnCategoryButton(category, MenCategory);
    }

    @Then("user verify that category page is displayed and confirm text {string}")
    public void userVerifyCategoryPageIsDisplayedAndConfirmText(String expectedText) {
        assertTrue(page.isVisible("//h2[contains(text(),'" + expectedText + "')]"));
        System.out.println("Category page is displayed successfully with text: " + expectedText);
    }
    @Then("verify that Brands are visible on left side")
    public void verifyBrandsAreVisible() {
        assertTrue(page.isVisible("//div[@class='left-sidebar']//h2[contains(text(),'Brands')]"));
        System.out.println("Brands are visible on the left side of the page.");
    }
    @And("user clicks on {string} brand")
    public void userClicksOnBrand(String brand) {
        page.click("//a[@href='/brand_products/"+brand+"']");
        System.out.println("+"+brand+"clicked successfully.");
    }

    @Then("user verify that brand page is displayed and confirm text {string}")
    public void userVerifyBrandPageIsDisplayedAndConfirmText(String expectedText) {
        assertTrue(page.isVisible("//h2[contains(text(),'" + expectedText + "')]"));
        System.out.println("Brand page is displayed successfully with text: " + expectedText);
    }

    @And("add all visible products to cart and click on view cart button")
    public void addAllVisibleProductsToCart() throws InterruptedException {
     registerPage.addALlVisibleProductsToCart();
    }

    @Then("verify all products are added to cart successfully")
    public void userVerifiesThatAllProductsAreAddedToCartSuccessfully() throws InterruptedException {
        registerPage.verifyAllProductsAddedToCart();
    }


    @And("Verify the {string} text is visible")
    public void verifyTextIsVisible(String text) {
       page.isVisible("//span[contains(text(),'" + text + "')]");
       System.out.println(text + " is visible on the page.");
    }

    @And("user enters name, email, and review")
    public void userEntersNameEmailAndReview(){
            registerPage.enterNameEmail_Review("Amol", "amol@gmail.com","This is a test review.");
    }

    @And("the user clicks Submit button")
     public void userClicksSubmitButtonInReview() {
        page.click("//button[@id='button-review']");
        System.out.println("Submit button clicked successfully.");
    }

    @And("Verify the text 'Write Your Review' text is visible")
    public void verifyWriteYourReviewTextIsVisible() {
        page.locator("//a[normalize-space()='Write Your Review']").evaluate("el => el.scrollTop += 500");
        System.out.println("Scrolled down to Write Your Review section.");
        page.locator("//a[normalize-space()='Write Your Review']").isVisible();
        System.out.println("Write Your Review text is visible.");
    }
    @Then("user verifies the 'Recomended Items' text is visible")
    public void userVerifiesRecomendedItemsTextIsVisible() {
        page.locator("//div//h2[contains(text(),'recommended items')]").isVisible();
    }
    ArrayList productNames = new ArrayList();
    @Then("user clicks on 'Add to cart' button for the first product")
    public void userClicksOnAddToCartButtonForFirstProduct() {
       Locator product= page.locator("(//div[@class='carousel-inner']//div[@class='product-image-wrapper'])");
       int recomenedProducts=product.count();
       System.out.println("Total recommended products: " + recomenedProducts);
       for (int i = 0; i < recomenedProducts; i++) {
           if(product.isVisible()){
               page.click("(//div[@class='carousel-inner']//div[@class='product-image-wrapper'])["+i+"]//a[contains(text(),'Add to cart')]");
               String productName =page.locator("(//div[@class='carousel-inner']//div[@class='product-image-wrapper'])["+i+"]//p").textContent();
               System.out.println("Product " + (i + 1) + ": " + productName);
                productNames.add(productName);
               break;
           }
           else {
                System.out.println("No more products to add to cart.");
                break;
           }
       }

    }
    @Then("user verifies that Product added in cart sucessfully")
    public void userVerifiesProductAddedInCartSuccessfully() {
       page.click(ProductsLocator.CART_BUTTON);
        int count = page.locator(CartLocator.CART_ITEM_LIST).count();
        System.out.println("Total number of items in cart: " + count);
        for (int i = 0; i < count; i++) {
            String actualproductName = page.locator(CartLocator.CART_ITEM_NAME).nth(i).innerText();
            System.out.println("Product Name: " + actualproductName);
            if (productNames.contains(actualproductName)) {
                System.out.println("Product " + actualproductName + " is successfully added to the cart.");
            } else {
                System.out.println("Product " + actualproductName + " is not found in the cart.");
            }
      }
        assertTrue(page.isVisible(CartLocator.CART_ITEM_LIST));
        System.out.println("Cart page is visible successfully.");
    }


    @Then("User click on Download and user verifies that Invoice is downloaded successfully")
    public void userClicksOnDownloadAndVerifiesInvoiceDownloaded() throws InterruptedException {
      registerPage.clickDownloadInvoiceButtonAndVerfiyFileDownloaded();
    }

    @Then("user clicks on arrow button right side scrolls up to top of the page using arrow button")
    public void userClicksOnArrowButtonAndScrollsUp() throws InterruptedException {
        Thread.sleep(2000); // Wait for the page to load
      //  page.keyboard().press("PageUp");
        page.click("a[href='#top']");
        System.out.println("Scrolled up to the top of the page successfully.");
    }

    @Then("user scrolls up to top of the page using mouse wheel")
    public void userScrollsUpToTopOfThePageUsingMouseWheel() {
        page.mouse().wheel(0, -1000); // Scroll up by 1000 pixels
        System.out.println("Scrolled up to the top of the page using mouse wheel successfully.");
    }

  /* @Then("user verifies that {string} is same as entered during registration")
   public void userVerifiesDeliveryAddressIsSameAsEntered( String text, DataTable dataTable) {
       // Retrieve the number of address lines
       int addressLineCount = page.locator("//ul[@id='"+text+"']//li").count();
       Map<String,String> expectedAddress=dataTable.asMap(String.class, String.class);
       // Iterate through the address lines and verify each field
       for (int i = 2; i <= addressLineCount; i++) {
           String actualText = page.locator("//ul[@id='"+text+"']//li[" + i + "]").textContent().trim();
           System.out.println("Actual Text: " + actualText);

           switch (i) {
               case 2:
                   assertTrue(actualText.contains(expectedAddress.get("First Name")));
                   break;
               case 3:
                     assertTrue(actualText.contains(expectedAddress.get("Last Name")));
                     break;
               case 4:
                   assertTrue(actualText.contains(expectedAddress.get("Address1")));
                   break;
               case 5:
                   assertTrue(actualText.contains(expectedAddress.get("Address2")));
                   break;
               case 6:
                   assertTrue(actualText.contains(expectedAddress.get("City")));
                   break;
               case 7:
                   assertTrue(actualText.contains(expectedAddress.get("State")));
                   break;
               case 8:
                   assertTrue(actualText.contains(expectedAddress.get("Zipcode")));
                   break;
               case 9:
                   assertTrue(actualText.contains(expectedAddress.get("Country")));
                   break;
               case 10:
                   assertTrue(actualText.contains(expectedAddress.get("Mobile Number")));
                   break;
               default:
                   fail("Unexpected address line: " + actualText);
           }
           System.out.println("Verified "+text+" " + i + ": " + actualText);
       }
   }

  */


    @Then("user verifies that {string} is same as entered during registration")
    public void verifyAddressDetails(String addressType) {
        // Wait for address section to be visible
        page.waitForSelector("//ul[@id='" + addressType + "']");
        // Get all address lines
        List<ElementHandle> addressLines = page.querySelectorAll("//ul[@id='" + addressType + "']//li");

        // Verify each address component
        for (ElementHandle line : addressLines) {
            String actualText = line.textContent();

            if (actualText.contains(storedAddressDetails.get("First Name"))) {
                // Verify full name
                String expectedName = storedAddressDetails.get("First Name") + " " +
                        storedAddressDetails.get("Last Name");
                assertTrue(actualText.contains(expectedName));
                System.out.println("Verified full name: " + expectedName +"  : "+ actualText);
            } else if (actualText.contains(storedAddressDetails.get("Company"))) {
                // Verify company
                assertEquals(storedAddressDetails.get("Company"), actualText.trim());
                System.out.println("Verified company: " + storedAddressDetails.get("Company") + " : " + actualText);
            } else if (actualText.contains(storedAddressDetails.get("Address1"))) {
                // Verify address 1
                assertTrue(actualText.contains(storedAddressDetails.get("Address1")));
                System.out.println("Verified address 1: " + storedAddressDetails.get("Address1") + " : " + actualText);
            } else if (actualText.contains(storedAddressDetails.get("Address2"))) {
                // Verify address 2
                assertTrue(actualText.contains(storedAddressDetails.get("Address2")));
                System.out.println("Verified address 2: " + storedAddressDetails.get("Address2") + " : " + actualText);
            } else if (actualText.contains(storedAddressDetails.get("City"))) {
                // Verify city, state, zipcode
                assertTrue(actualText.contains(storedAddressDetails.get("City")));
                assertTrue(actualText.contains(storedAddressDetails.get("State")));
                assertTrue(actualText.contains(storedAddressDetails.get("Zipcode")));
                System.out.println("Verified city, state, zipcode: " + storedAddressDetails.get("City") + ", " +
                        storedAddressDetails.get("State") + ", " + storedAddressDetails.get("Zipcode") + " : " + actualText);
            } else if (actualText.contains(storedAddressDetails.get("Country"))) {
                // Verify country
                assertEquals(storedAddressDetails.get("Country"), actualText.trim());
                System.out.println("Verified country: " + storedAddressDetails.get("Country") + " : " + actualText);
            } else if (actualText.contains(storedAddressDetails.get("Mobile Number"))) {
                // Verify mobile number
                assertTrue(actualText.contains(storedAddressDetails.get("Mobile Number")));
                System.out.println("Verified mobile number: " + storedAddressDetails.get("Mobile Number") + " : " + actualText);
            }
            System.out.println(addressType + " verification completed successfully");
        }

    }


}