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
    public static void addClothes(Clothes clothes) {
        String sql = "INSERT INTO clothes (quantity, sku, description, price, max_discount) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConection.gConnection();
                PreparedStatement state = conn.prepareStatement(sql)) {
            state.setInt(1, clothes.getQuantity());
            state.setString(2, clothes.getSku());
            state.setString(3, clothes.getDescription());
            state.setFloat(4, clothes.getPrice());
            state.setFloat(5, clothes.getMaxDiscount());

            state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateClothes(Clothes clothes) {
        String sql = "UPDATE clothes SET quantity = ?, sku = ?, description = ?, price = ?, max_discount = ? WHERE id = ?";

        try (Connection conn = DatabaseConection.gConnection();
                PreparedStatement state = conn.prepareStatement(sql)) {

            state.setInt(1, clothes.getQuantity());
            state.setString(2, clothes.getSku());
            state.setString(3, clothes.getDescription());
            state.setFloat(4, clothes.getPrice());
            state.setFloat(5, clothes.getMaxDiscount());
            state.setInt(6, clothes.getId());

            state.executeUpdate();
            System.out.println("Clothes successfully updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteClothes(int id) {
        String sql = "DELETE FROM clothes WHERE id = ?";

        try (Connection conn = DatabaseConection.gConnection();
                PreparedStatement state = conn.prepareStatement(sql)) {
            state.setInt(1, id);

            state.executeUpdate();
            System.out.println("Clothes successfully deleted!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Clothes> getAllClothes() {
        List<Clothes> clothes = new ArrayList<>();
        String sql = "SELECT * FROM clothes";

        try (Connection conn = DatabaseConection.gConnection();
                Statement state = conn.createStatement();
                ResultSet result = state.executeQuery(sql)) {

            while (result.next()) {
                int id = result.getInt("id");
                int quantity = result.getInt("quantity");
                String sku = result.getString("sku");
                String description = result.getString("description");
                float price = result.getFloat("price");
                float max_discount = result.getFloat("max_discount");

                Clothes clothe = new Clothes(id, quantity, sku, description, price, max_discount);
                clothes.add(clothe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clothes;
    }
}
