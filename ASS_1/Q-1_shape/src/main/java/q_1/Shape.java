/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q_1;

/**
 *
 * @author root
 */
public class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public double getArea() {
        System.out.println("Shape area is undefined.");
        return 0;
    }

    @Override
    public String toString() {
        return "Color: " + color;
    }
}
