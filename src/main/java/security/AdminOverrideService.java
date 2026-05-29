package security;

import database.UserDAO;
import model.AppUser;

public class AdminOverrideService {

    private AdminOverrideService() {
    }

    public static AppUser verifyAdmin(String username, String password) {

        AppUser admin = UserDAO.login(username, password);

        if (admin == null) {
            return null;
        }

        if (!"ADMIN".equalsIgnoreCase(admin.getRole())) {
            return null;
        }

        return admin;
    }
}