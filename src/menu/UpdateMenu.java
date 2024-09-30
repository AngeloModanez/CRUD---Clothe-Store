package menu;

import java.util.Scanner;

import dao.ClothesDAO;
import entity.Clothes;

public class UpdateMenu {
    public static void show(Scanner in) {
        System.out.print("\nEnter the Id of the product to be updated: ");
        int id = in.nextInt();

        System.out.print("\nEnter the quantity: ");
        int quantity = in.nextInt();

        System.out.print("\nEnter the SKU: ");
        String sku = in.next();

        System.out.print("\nEnter the description: ");
        String description = in.next();

        System.out.print("\nEnter the price: ");
        float price = in.nextFloat();

        System.out.print("\nEnter the max discount: ");
        float maxDiscount = in.nextFloat();

        Clothes clothes = new Clothes(id, quantity, sku, description, price, maxDiscount);
        ClothesDAO.updateClothes(clothes);
    }

}
