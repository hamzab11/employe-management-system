package security;
import model.AppUser;
public class SessionManager {



        private static AppUser currentUser;

        private SessionManager() {
            // منع إنشاء object من هذا الكلاس
        }

        public static void startSession(AppUser user) {
            currentUser = user;
        }

        public static AppUser getCurrentUser() {
            return currentUser;
        }

        public static boolean isLoggedIn() {
            return currentUser != null;
        }

        public static String getCurrentUsername() {
            if (currentUser == null) {
                return null;
            }
            return currentUser.getUsername();
        }

        public static String getCurrentRole() {
            if (currentUser == null) {
                return null;
            }
            return currentUser.getRole();
        }

        public static boolean isAdmin() {
            return currentUser != null
                    && "ADMIN".equalsIgnoreCase(currentUser.getRole());
        }

        public static boolean isManager() {
            return currentUser != null
                    && "MANAGER".equalsIgnoreCase(currentUser.getRole());
        }

        public static boolean isUser() {
            return currentUser != null
                    && "USER".equalsIgnoreCase(currentUser.getRole());
        }

        public static void endSession() {
            currentUser = null;
        }
    }

