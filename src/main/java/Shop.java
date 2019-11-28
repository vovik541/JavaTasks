import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class Shop implements DBConnectable{
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "root";
    protected static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    protected String query = "select * from ";
    protected ArrayList<Product> allProducts;

    @Override
    public ArrayList<Product> getProductsFromDB(){
        ArrayList<Product> Products = new ArrayList<>();

        try {
            DBConnection db = new DBConnection();
            Connection connection = db.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resSet = statement.executeQuery(query);

            while (resSet.next()){
                String productName;
                int productPrice;
                productName = resSet.getString("product_name");
                productPrice = resSet.getInt("product_price");
                Product product = new Product(productName , productPrice);
//                System.out.println("1 "+product.toString());
                Products.add(product);
            }

            statement.close();
            connection.close();

            return Products;
        }
        catch (SQLException ex) {
            System.out.println("SQLEXCEPTION!!!");
            return null;
        } finally{ return Products;}
    }
}
