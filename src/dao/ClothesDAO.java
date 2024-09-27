package dao;

import entity.Clothes;
import config.DatabaseConection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class ClothesDAO {
    public static void Create(Clothes clothes) {
        String sql = "INSERT INTO clothes (quantity, sku, description, price, max_discount) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConection.gConnection();
                PreparedStatement state = conn.prepareStatement(sql)) {

            state.setInt(1, clothes.getQuantity());
            state.setString(2, clothes.getSku());
            state.setString(3, clothes.getDescription());
            state.setFloat(4, clothes.getPrice());
            state.setFloat(5, clothes.getMaxDiscount());
            
            state.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public static List<Clothes> List() {
        List<Clothes> clothes = new ArrayList<>();
        String sql = "SELECT * FROM clothes";

        try (Connection conn = DatabaseConection.gConnection();
                Statement state = conn.createStatement();
                ResultSet result = state.executeQuery(sql)) {

            while (result.next()) {
                Clothes clothe = new Clothes();
                clothe.setId(result.getInt("id"));
                clothe.setQuantity(result.getInt("quantity"));
                clothe.setSku(result.getString("sku"));
                clothe.setDescription(result.getString("description"));
                clothe.setPrice(result.getFloat("price"));
                clothe.setMaxDiscount(result.getFloat("max_discount"));
                clothes.add(clothe);
            }

        } catch (SQLException error) {
            error.printStackTrace();
        }

        return clothes;
    }
}
