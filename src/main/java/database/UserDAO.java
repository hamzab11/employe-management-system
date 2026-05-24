package database;

import model.AppUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // إضافة مستخدم جديد
    public static boolean createUser(AppUser user) {

        String sql =
                "INSERT INTO users(username, password, role) VALUES(?, ?, ?)";

        try (
                Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());

            pstmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // البحث عن مستخدم بالاسم
    public static AppUser findByUsername(String username) {

        String sql =
                "SELECT * FROM users WHERE username = ?";

        try (
                Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                AppUser user = new AppUser();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // تسجيل الدخول
    public static AppUser login(String username,
                                String password) {

        String sql =
                "SELECT * FROM users WHERE username = ? AND password = ?";

        try (
                Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                AppUser user = new AppUser();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void createDefaultAdmin() {

        AppUser admin = findByUsername("admin");

        if (admin == null) {

            AppUser user = new AppUser();

            user.setUsername("admin");
            user.setPassword("Dgsn2026");
            user.setRole("ADMIN");

            createUser(user);

            System.out.println("Default admin created.");
        } else {
            System.out.println("Default admin already exists.");
        }
    }
}