/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package q_1;

/**
 *
 * @author root
 */
import java.util.Scanner;
public class Q1_shape {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        System.out.println("--- Rectangle  ---");
        System.out.print("Color: ");
        String rColor = sc.next();
        System.out.print("Length: ");
        int rLength = sc.nextInt();
        System.out.print("Width: ");
        int rWidth = sc.nextInt();

        Shape s1 = new Rectangle(rColor, rLength, rWidth); 

        System.out.println("\n--- Triangle ---");
        System.out.print("Color: ");
        String tColor = sc.next();
        System.out.print("Base  ");
        int tBase = sc.nextInt();
        System.out.print("Height  ");
        int tHeight = sc.nextInt();

        Shape s2 = new Triangle(tColor, tBase, tHeight);

        System.out.println("\n--- Result---");
        System.out.println(s1.toString() + " | Area: " + s1.getArea());
        System.out.println(s2.toString() + " | Area: " + s2.getArea());

        if (s1 instanceof Rectangle) {
            Rectangle rect = (Rectangle) s1; 
            System.out.println("Downcasting successful! s1 is a Rectangle.");
        }
        
        if (s2 instanceof Triangle) {
            Triangle tri = (Triangle) s2; 
            System.out.println("Downcasting successful! s2 is a Triangle.");
        }
        
        sc.close(); 
    }
}