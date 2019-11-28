import java.util.ArrayList;

public class Husband extends Human implements HusbandWorkDoable {

    private String[] productList;
    private ArrayList<Product> allProducts = new ShopManager().getAllProducts();

    public Husband(){

    }

    @Override
    public void getProductList(String[] productList){
        this.productList = productList;
    }

    @Override
    public ArrayList<Product> getAllProducts (){
        return this.allProducts;
    }

    @Override
    public ArrayList<Product> getBoughtedProducts(){

        ArrayList<Product> boughtedProducts = new ArrayList<>();

        for (Product product:allProducts){
            for (String neededProductName:productList){
                if (neededProductName.equals(product.getProduckName())){
                    boughtedProducts.add(product);
                }
            }
        }

        return boughtedProducts;
    }
    @Override
    public int getTotalPrice(){

        int totalPrice = 0;

        for (Product product:allProducts){
            for (String neededProductName:productList){
                if (neededProductName.equals(product.getProduckName())){
                    totalPrice += product.getProduckPrice();
                }
            }
        }

        return totalPrice;
    }


}
