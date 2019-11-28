import java.util.ArrayList;

public class Wife extends Human implements ProductListMakable {

    @Override
    public String[] makeProductList(){
        String[] productList = {"Potato","Milk","Samsung"};
        return productList;
    }

    @Override
    public void showList(ArrayList<Product> productList){
        for(Product product:productList){
            System.out.println(product.getProduckName());
        }
    }

    @Override
    public void showTotalPrice(int totalPrice){
        System.out.print(totalPrice);
    }
}
