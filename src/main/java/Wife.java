import java.util.ArrayList;

public class Wife extends Human implements ProductListMakable {

    @Override
    public String[] makeProductList(){
        String[] productList = {"Potato","Milk","Samsung"};
        return productList;
    }

    @Override
    public void showList(ArrayList<Product> productList){
        for(int i = 0; i < productList.size(); i++){
            System.out.println(productList.get(i).getProduckName());
        }
    }

    @Override
    public void showList(int totalPrice){
        System.out.println(totalPrice);
    }
}
