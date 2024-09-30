package main;

import java.util.Scanner;
import menu.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			ClothesMenu.show();
			int option = in.nextInt();

			switch (option) {
				case 1:
					AddMenu.show(in);
					break;
				case 2:
					UpdateMenu.show(in);
					break;
				case 3:
					DeleteMenu.show(in);
					break;
				case 4:
					ListMenu.show();
					break;
				case 5:
					System.out.println("\nExiting...");
					in.close();
					return;
				default:
					System.out.println("\nEnter a valid Option!");
					break;
			}
		}
	}
}
