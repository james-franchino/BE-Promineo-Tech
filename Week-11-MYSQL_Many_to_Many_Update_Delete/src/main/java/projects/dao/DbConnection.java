package projects.dao;

import projects.exception.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String SCHEMA = "projects";
    private static final String USER = "projects";
    private static final String PASSWORD = "projects";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;

    public static Connection getConnection() {
        String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&allowPublicKeyRetrieval=true&useSSL=false", HOST, PORT, SCHEMA, USER,
                PASSWORD);
        System.out.println("Connecting to database" + uri);
        try {
            Connection conn = DriverManager.getConnection(uri);
            System.out.println("Successfully connected to database");
            return conn;
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }
}
