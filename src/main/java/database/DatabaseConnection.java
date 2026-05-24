package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {


        private static final String URL =
                "jdbc:sqlite:police.db";

        public static Connection connect() {

            try {

                Connection connection =
                        DriverManager.getConnection(URL);

                System.out.println("تم الاتصال بقاعدة البيانات");

                return connection;

            } catch (Exception e) {

                e.printStackTrace();
                return null;
            }
        }
    }

