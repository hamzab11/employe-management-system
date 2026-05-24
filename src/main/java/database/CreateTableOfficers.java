package database;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTableOfficers {

    public static void createTableOfficers() {

        String sql = """
                
            CREATE TABLE IF NOT EXISTS officers (
            
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                
                matricule TEXT NOT NULL,
                first_name TEXT NOT NULL,
                last_name TEXT NOT NULL,
                gun_matricule TEXT,
                
                grade TEXT,
                return_date TEXT,
                
                
                bullets INTEGER,
                magazines INTEGER,
                
                badge_number TEXT
                
            );
                
            """;

        try (
                Connection conn =
                        DatabaseConnection.connect();

                Statement stmt =
                        conn.createStatement()
        ) {

            stmt.execute(sql);

            System.out.println("تم إنشاء الجدول");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}