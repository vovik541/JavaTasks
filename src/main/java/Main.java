import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        Wife wife = new Wife();
        Husband husband = new Husband();

        System.out.println("Total:");

        husband.getProductList(wife.makeProductList());
        wife.showList(husband.getAllProducts());
        System.out.println("\nBought:");
        wife.showList(husband.getBoughtedProducts());
        System.out.print("Total price: ");
        wife.showTotalPrice(husband.getTotalPrice());
    }
}
