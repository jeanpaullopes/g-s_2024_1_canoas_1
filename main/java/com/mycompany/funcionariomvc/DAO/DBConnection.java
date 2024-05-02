package com.mycompany.funcionariomvc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafaelamoreira
 */
public class DBConnection {

    private static DBConnection instance = null;
    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbName = "empresa";
    private String driver = "com.mysql.jdbc.Driver";
    private DriverManager driverManager = null;

    private DBConnection() {
        try {
            conn = DriverManager.getConnection(url + dbName, "root", "senhaDoRoot");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados");
            System.out.println(e.getMessage());
        }

    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }
}
