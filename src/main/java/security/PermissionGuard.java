package security;

public class PermissionGuard {

    private PermissionGuard() {
    }

    public static boolean canRead() {
        return SessionManager.isLoggedIn();
    }

    public static boolean canWriteDirectly() {
        return SessionManager.isAdmin();
    }

    public static boolean requiresAdminOverrideForWrite() {
        return SessionManager.isManager();
    }

    public static boolean canManageUsers() {
        return SessionManager.isAdmin();
    }
}