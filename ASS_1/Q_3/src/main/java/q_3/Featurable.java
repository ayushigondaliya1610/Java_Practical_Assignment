/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package q_3;

/**
 *
 * @author root
 */
public interface Featurable {

    void setForeground(String color);
    void setBackground(String color);
    void setFont(String fontName, int size);
    String getTableFeatures();
}

class TableException extends Exception {
    public TableException(String message) {
        super(message);
    }
}
