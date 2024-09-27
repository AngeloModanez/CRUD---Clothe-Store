package menu;

import java.util.List;

import dao.ClothesDAO;
import entity.Clothes;

public class ListMenu {
    public static void show() {
        List<Clothes> clothes = ClothesDAO.List();
        if (clothes.isEmpty()) {
            System.out.println("The List is Empty");
            return;
        }

        System.out.println("\nClothes List:");
        for (Clothes c : clothes) {
            System.out.println("ID: " + c.getId() + ", Quantity: " + c.getQuantity() + ", SKU: " + c.getSku()
                    + ", Description: "
                    + c.getDescription() + ", Price: R$" + c.getPrice() + ", MAX_Discount: R$" + c.getMaxDiscount());
        }
    }

}
