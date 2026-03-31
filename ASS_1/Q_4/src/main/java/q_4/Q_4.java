/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package q_4;


import java.sql.*;

/**
 *
 * @author root
 */
public class Q_4 {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded Successfully!");

          
            String url = "jdbc:mysql://localhost:3306/Clothcategory_db";
            Connection con = DriverManager.getConnection(url, "root", "root");

            System.out.println("Database Connected!");
            System.out.println("\n--- Category Tree ---");
             printTree(con, 0, 0);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void printTree(Connection con, int parentId, int level) throws SQLException {
        String query;
        if (parentId == 0) {
            query = "select * from Category_Master WHERE parent_category_id IS NULL";
        } else {
            query = "select * from Category_Master WHERE parent_category_id = " + parentId;
        }

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            for (int i = 0; i < level; i++) {
                System.out.print("    "); 
            }
            int currentId = rs.getInt("category_id");
            String name = rs.getString("Category_name");

            System.out.println("|-- " + name);
            printTree(con, currentId, level + 1);
        }
    }
}
