/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package q_3;

/**
 *
 * @author root
 */
import java.util.Scanner;
import java.util.Hashtable;

public class Q_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataTable myTable = null;

        try {
            System.out.print("Enter initial rows and columns (e.g., 3 3): ");
            int r = sc.nextInt();
            int c = sc.nextInt();
            myTable = new DataTable(r, c);

            boolean running = true;
            while (running) {
                System.out.println("\n1. Set Cell  \n2. Insert Row \n3. Set Font  \n4. Populate (Hash)   \n5. Display  \n6. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Row Col Value: ");
                        myTable.setCellValue(sc.nextInt(), sc.nextInt(), sc.next());
                        break;
                    case 2:
                        System.out.print("Index to insert: ");
                        myTable.insertRow(sc.nextInt());
                        break;
                    case 3:
                        System.out.print("FontName Size: ");
                        myTable.setFont(sc.next(), sc.nextInt());
                        break;
                    case 4:
                        Hashtable<String, String> dynamicHash = new Hashtable<>();
                        System.out.print("how many data u want to add: ");
                        int num = sc.nextInt();

                        for (int i = 0; i < num; i++) {
                            System.out.print("enter Key(id): Value(name): ");
                            String k = sc.next();
                            String v = sc.next();
                            dynamicHash.put(k, v);
                        }

                        myTable.populateFromHashtable(dynamicHash);
                        System.out.println("fill the table ");
                        break;
                    case 5:
                        myTable.display();
                        break;
                    case 6:
                        running = false;
                        break;
                }
            }
        } catch (TableException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Input Error: " + e.getMessage());
        }
    }
}
