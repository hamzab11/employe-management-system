package database;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTableUsers {

    public static void createTable() {

        String sql = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL,
                role TEXT NOT NULL
            );
            """;

        try (
                Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement()
        ) {

            stmt.execute(sql);
            System.out.println("Users table created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}