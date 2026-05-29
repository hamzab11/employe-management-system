package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.AppUser;
import security.AdminOverrideService;
import utils.AnimationManager;

public class AdminOverrideDialogController {
    @FXML
    public Pane rightBluePane;
    @FXML
    public VBox mainCard;
    @FXML
    public Label authorityGateLabel;
    @FXML
    public Label titleLabel;
    @FXML
    public Label subtitleLabel;
    @FXML
    public Button authorizeButton;
    @FXML
    private TextField adminUsernameField;

    @FXML
    private PasswordField adminPasswordField;

    @FXML
    private Label messageLabel;

    public void initialize() {
        AnimationManager.applyButtonAnimations(authorizeButton,adminPasswordField,adminUsernameField);
        AnimationManager.slideFromOnXaxis(rightBluePane,40,700);
        AnimationManager.fade(rightBluePane,0.9,0,1,false);
        AnimationManager.fade(mainCard,0.5,0,1,false);
        AnimationManager.greenButtonHover(authorizeButton);

    }

    private boolean authorized = false;
    private AppUser adminUser;

    public void handleAuthorize() {

        String username = adminUsernameField.getText().trim();
        String password = adminPasswordField.getText().trim();

        AppUser admin = AdminOverrideService.verifyAdmin(username, password);

        if (admin == null) {
            AnimationManager.shake(messageLabel,50,-8,8,6,true);
            messageLabel.setText("Invalid admin credentials");
            return;
        }

        authorized = true;
        adminUser = admin;

        Stage stage = (Stage) adminUsernameField.getScene().getWindow();
        stage.close();
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public AppUser getAdminUser() {
        return adminUser;
    }
}