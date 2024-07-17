package recipes;

import dao.DbConnection;

import java.sql.Connection;

public class Recipes {
    public static void main(String[] args) {
        DbConnection.getConnection();
    }
}
