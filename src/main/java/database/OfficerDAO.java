package database;

import model.Officer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class OfficerDAO {

    public static void insertOfficer(
            Officer officer
    ) {

        String sql = """
                
            INSERT INTO officers (
            
                matricule,
                first_name,
                last_name,
                grade,
                return_date,
                gun_matricule,
                bullets,
                magazines,
                badge_number
                
            )
            
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                
            """;

        try (
                Connection conn =
                        DatabaseConnection.connect();

                PreparedStatement pstmt =
                        conn.prepareStatement(sql)
        ) {

            pstmt.setString(1,
                    officer.getMatricule());

            pstmt.setString(2,
                    officer.getFirstName());

            pstmt.setString(3,
                    officer.getLastName());

            pstmt.setString(4,
                    officer.getGrade());

            pstmt.setString(5,
                    officer.getReturnDate());

            pstmt.setString(6,
                    officer.getGunMatricule());

            pstmt.setInt(7,
                    officer.getBullets());

            pstmt.setInt(8,
                    officer.getMagazines());

            pstmt.setString(9,
                    officer.getBadgeNumber());

            pstmt.executeUpdate();

            System.out.println("تمت إضافة الشرطي");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}