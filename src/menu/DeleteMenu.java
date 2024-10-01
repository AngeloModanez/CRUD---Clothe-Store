package menu;

import java.util.List;
import java.util.Scanner;

import dao.ClothesDAO;
import entity.Clothes;

public class DeleteMenu {
    public static void show(Scanner in) {
        List<Clothes> clothes = ClothesDAO.getAllClothes();
        if (clothes.isEmpty()) {
            System.out.print("\nThe List is Empty!");
            return;
        }

        System.out.print("\nEnter the Id of the product to be deleted: ");
        int id = in.nextInt();

        ClothesDAO.deleteClothes(id);
    }

}
