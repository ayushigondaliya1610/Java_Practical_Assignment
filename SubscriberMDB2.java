package mdb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueue")
})
public class DBOperationMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            String text = msg.getText();

            System.out.println("Received Message: " + text);

            // Split message
            String[] parts = text.split(":");

            String operation = parts[0];  // I/U/D
            String table = parts[1];
            String columns = parts.length > 2 ? parts[2] : "";
            String values = parts.length > 3 ? parts[3] : "";
            String where = parts.length > 4 ? parts[4] : "";

            // DB Connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", ""
            );

            Statement stmt = con.createStatement();
            String query = "";

            switch (operation) {

                case "I":
                    query = "INSERT INTO " + table +
                            " (" + columns + ") VALUES (" + values + ")";
                    break;

                case "U":
                    query = "UPDATE " + table +
                            " SET " + columns + "=" + values + " " + where;
                    break;

                case "D":
                    query = "DELETE FROM " + table + " " + where;
                    break;
            }

            System.out.println("Executing: " + query);
            stmt.executeUpdate(query);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}