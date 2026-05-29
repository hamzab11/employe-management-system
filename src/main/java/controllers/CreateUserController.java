package controllers;

import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import model.AppUser;
import security.PermissionGuard;
import utils.AnimationManager;
import utils.SceneManager;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CreateUserController {
    @FXML
    public Pane rightBluePane;
    @FXML
    public Circle circleOne;
    @FXML
    public Circle circleTwo;
    @FXML
    public VBox mainCard;
    @FXML
    public Button createUserButton;
    @FXML
    public Button backButton;
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private Label messageLabel;

    public void initialize() {
        roleComboBox.getItems().addAll("MANAGER", "USER");
        AnimationManager.applyButtonAnimations(usernameField, passwordField, roleComboBox,backButton,createUserButton);
        AnimationManager.slideFromOnXaxis(rightBluePane,40,700);
        AnimationManager.fade(rightBluePane,0.9,0,1,false);
        AnimationManager.floating(circleOne);
        AnimationManager.floating(circleTwo);
        AnimationManager.fade(mainCard,0.5,0,1,false);
        AnimationManager.slideFromOnXaxis(mainCard,40,700);
        AnimationManager.greenButtonHover(createUserButton);
        AnimationManager.redButtonHover(backButton);



    }



    public void handleCreateUser() {

        if (!PermissionGuard.canManageUsers()) {
            messageLabel.setText("Only ADMIN can create users.");
            return;
        }

        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String role = roleComboBox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            AnimationManager.shake(messageLabel,50,-8,8,6,true);
            messageLabel.setText("Please fill all fields.");
            return;
        }

        AppUser existingUser = UserDAO.findByUsername(username);

        if (existingUser != null) {
            AnimationManager.shake(messageLabel,50,-8,8,6,true);
            messageLabel.setText("Username already exists.");
            return;
        }

        AppUser newUser = new AppUser();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        boolean created = UserDAO.createUser(newUser);

        if (created) {
            messageLabel.setText("User created successfully: " + role);
            usernameField.clear();
            passwordField.clear();
            roleComboBox.setValue(null);
        } else {
            AnimationManager.shake(messageLabel,50,-8,8,6,true);
            messageLabel.setText("Failed to create user.");
        }
    }

    public void handleBack(ActionEvent actionEvent) {
        try {

        SceneManager.switchScene(actionEvent,"/fxml/login-view.fxml");
        }catch (Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            messageLabel.setText(sw.toString());
        }
    }
}