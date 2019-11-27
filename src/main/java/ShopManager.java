import java.util.ArrayList;

public class ShopManager {
    public static ArrayList<Shop> getAllShops(){
        ArrayList<Shop> shops = new ArrayList<>();
        shops.add(new Shop_1("Shops.Shop_1"));
        shops.add(new Shop_2("Shops.Shop_2"));

//        shops.get(0).getProducts();
//        shops.get(1).getProducts();

        return shops;
    }
}
