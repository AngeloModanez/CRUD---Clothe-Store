package main;

import java.util.Scanner;
import menu.ClothesMenu;
import menu.ListMenu;
import menu.SaveMenu;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			ClothesMenu.show();
			int option = in.nextInt();

			switch (option) {
				case 1:
					SaveMenu.show();
					break;
				case 2:
				case 3:
				case 4:
					ListMenu.show();
					break;
				case 5:
					System.out.println("\nExiting...");
					in.close();
					return;
				default:
					System.out.println("\nEnter a valid Option");
					break;
			}
		}
	}
}
