import java.util.Scanner;

import org.junit.Test;

//mport java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\t************************************************");
        System.out.println("\t             WELCOME TO JAVA DRINKS!            ");
        System.out.println("\t************************************************");
        
        Item[][] items = new Item[][] {
             { new Item("Pepsi", 1.99, 3) , new Item("Fresca", 1.49, 3), new Item("Brisk", 2.49, 2) },
             { new Item("Fanta", 1.99, 2) , new Item("Barq's", 1.49, 2), new Item("A & W", 2.49, 3) },
             { new Item("Crush", 1.99, 2) , new Item("C-Cola", 1.49, 2), new Item("Berry", 2.49, 1) }
        };

        // FOR SETTING ITEM DETAILS INTO MACHINE ARRAY.
        Machine machineObject = new Machine();
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                machineObject.setItems(items[i][j], i, j);
            }
        }

        System.out.println(machineObject);

        Scanner scan = new Scanner(System.in);

        int check = 1;
        int row = 4;
        int spot = 10;
        while(true){
            if(check==1){
                System.out.print("Pick a row: ");
                row = scan.nextInt();
                System.out.print("Pick a spot in the row: ");
                spot = scan.nextInt();
                
                if(machineObject.dispense(row, spot)){
                    System.out.println(machineObject);
                    System.out.println("\nEnjoy your drink! Press 1 to purchase another: ");
                    check = scan.nextInt();
                }
                else{
                    System.out.println("\nSorry, we're out of this item. Press 1 to purchase another: ");
                    check = scan.nextInt();
                }
            }
            else{
                scan.close();
                break;
            }
        }

        System.out.println("THANK YOU FOR VENDING !");

    }
}
