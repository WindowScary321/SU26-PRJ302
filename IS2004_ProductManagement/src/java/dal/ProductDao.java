package dal;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductDao extends DBContext{
    
    public List<Product> getAllProducts(){
        List<Product> prdList = new ArrayList<>();
        String sql = "SELECT * FROM tbProduct";
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String id = rs.getString(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date impDate = rs.getDate(5);
                String catId = rs.getString(6);
                Product x = new Product(id, name, qty, price, impDate, catId);
                prdList.add(x);
            }
            return prdList;                    
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
