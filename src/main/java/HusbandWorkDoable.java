import java.util.ArrayList;

public interface HusbandWorkDoable {

    void getProductList(String[] productList);
    ArrayList<Product> getAllProducts ();
    ArrayList<Product> getBoughtedProducts();
    int getTotalPrice();
}

