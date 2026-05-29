package security;

import controllers.AdminOverrideDialogController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.AppUser;

public class AdminOverrideDialog {

    private AdminOverrideDialog() {
    }

    public static AppUser requestAdminAuthorization() {

        try {
            FXMLLoader loader = new FXMLLoader(
                    AdminOverrideDialog.class.getResource("/fxml/admin-override-dialog.fxml")
            );

            Scene scene = new Scene(loader.load());

            Stage stage = new Stage();
            stage.setTitle("Admin Override");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            stage.showAndWait();

            AdminOverrideDialogController controller = loader.getController();

            if (controller.isAuthorized()) {
                return controller.getAdminUser();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}