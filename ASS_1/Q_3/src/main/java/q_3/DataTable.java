/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q_3;

/**
 *
 * @author root
 */
import java.util.*;
public class DataTable implements Featurable {
    private String[][] data;
    private int rows;
    private int cols;
    private String foreground = "Black";
    private String background = "White";
    private String font = "Arial 12pt";

    public DataTable(int r, int c) throws TableException {
        if (r > 200 || c > 200) {
            throw new TableException("Error: Table dimensions cannot exceed 200x200.");
        }
        this.rows = r;
        this.cols = c;
        this.data = new String[r][c];
        for (int i = 0; i < r; i++) Arrays.fill(data[i], "-");
    }

    public void setForeground(String color) { this.foreground = color; }
    public void setBackground(String color) { this.background = color; }
    public void setFont(String fontName, int size) { this.font = fontName + " " + size + "pt"; }
    
    public String getTableFeatures() {
        return String.format("[Font: %s, FG: %s, BG: %s]", font, foreground, background);
    }

    public void setCellValue(int r, int c, String value) {
        if (r < rows && c < cols) data[r][c] = value;
    }

    public void insertRow(int index) {
        String[][] newData = new String[rows + 1][cols];
        for (int i = 0, newI = 0; i < rows; i++, newI++) {
            if (newI == index) newI++; 
            newData[newI] = data[i];
        }
        newData[index] = new String[cols];
        Arrays.fill(newData[index], "NEW");
        data = newData;
        rows++;
    }

    public void populateFromHashtable(Hashtable<String, String> source) {
        int r = 0;
        for (String key : source.keySet()) {
            if (r < rows) {
                data[r][0] = key;
                if (cols > 1) data[r][1] = source.get(key);
                r++;
            }
        }
    }

    public void display() {
        System.out.println("\n--- Current Table " + getTableFeatures() + " ---");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
