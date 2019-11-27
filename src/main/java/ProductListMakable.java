import java.util.ArrayList;

public interface ProductListMakable {
    public String[] makeProductList();
    public void showList(ArrayList<Product> productList);
    public void showList(int totalPrice);
}
