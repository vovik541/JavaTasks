import java.util.ArrayList;

public class ShopManager {

    public ShopManager(){}

    public static ArrayList<Shop> getAllShops(){
        ArrayList<Shop> shops = new ArrayList<>();

        shops.add(new Shop_1("Shops.Shop_1"));
        shops.add(new Shop_2("Shops.Shop_2"));

        return shops;
    }

    public ArrayList<Product> getAllProducts(){
        ArrayList<Product> allProducts = new ArrayList<>();
        ArrayList<Shop> shops = getAllShops();

        for (Shop shop:shops){
            for (Product product:shop.getProductsFromDB()){
                allProducts.add(product);
            }
        }

        System.out.println(allProducts);

        return allProducts;
    }
}
