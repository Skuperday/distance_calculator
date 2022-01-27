package calculator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/distance_calculator";
        String username = "root";
        String password = "root";
        try {
            System.out.println("Connecting.");
            Thread.sleep(300);
            System.out.println("Connecting..");
            Thread.sleep(300);
            System.out.println("Connecting...");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Failed");
            e.printStackTrace();
        }
    }
}
