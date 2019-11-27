public class Product {
    private String prName;
    private int price;

    Product(){}
    Product(String productName, int productPrice){
        this.prName = productName;
        this.price = productPrice;
    }

    public String getProduckName(){
        return prName;
    }

    public int getProduckPrice(){
        return price;
    }

    @Override
    public String toString(){
        return ""+ prName + "-" + price;
    }
}
