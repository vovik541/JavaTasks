import java.util.ArrayList;

public interface ProductListMakable {
    public String[] makeProductList();
    public void showList(ArrayList<Product> productList);
    public void showTotalPrice(int totalPrice);
}
