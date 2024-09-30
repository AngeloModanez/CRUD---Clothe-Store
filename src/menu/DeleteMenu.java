package menu;

import java.util.Scanner;

import dao.ClothesDAO;

public class DeleteMenu {
    public static void show(Scanner in) {
        System.out.print("\nEnter the Id of the product to be deleted: ");
        int id = in.nextInt();

        ClothesDAO.deleteClothes(id);
    }
}
