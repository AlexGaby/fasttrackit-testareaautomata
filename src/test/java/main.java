public class main {

    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
       /* Login login = new Login();
        login.login();
         login.invalidEmailLogin();
        login.invalidPassLogin();


        WishlistTest wishlist = new WishlistTest();
        wishlist.firstSaleItem();
     */
       // RegisterTest register = new RegisterTest();
        //register.signUp();
        //register.invalidsignUp();
       // register.notCompleteaMandatoryfield();

        Cart cart = new Cart();
         //cart.addToCart();
         //cart.addInvalidNumberToCart();
        cart.addStringToQuantity();
    }

}
