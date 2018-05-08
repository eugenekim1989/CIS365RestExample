
package com.cis365.week5;

import java.sql.*;

public class OracleExample {
    public static void main(String args[]) {
        Connection connection = null;
        if (System.getenv("RDS_HOSTNAME") != null) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");

                String dbName = System.getenv("RDS_DB_NAME");
                String userName = System.getenv("RDS_USERNAME");
                String password = System.getenv("RDS_PASSWORD");
                String hostname = System.getenv("RDS_HOSTNAME");
                String port = System.getenv("RDS_PORT");
                String jdbcUrl = "jdbc:oracle:thin:@" + hostname + ":" + port + ":" + dbName;

                connection = DriverManager.getConnection(jdbcUrl, userName, password);

                Statement stmt = connection.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM planet");
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString("RADIUS"));
                }

            } catch (ClassNotFoundException e) {
                System.out.println(e.toString());
            } catch (SQLException e) {
                System.out.println(e.toString());
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } else {
            System.out.println("Add the System Variables first.");
        }

    }
}
