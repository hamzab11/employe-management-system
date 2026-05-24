package com.ahbpaf.p4;

import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.AppUser;

public class LoginController {
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public CheckBox checkBox;
    @FXML
    public Hyperlink hyperLink;
    @FXML
    public Button loginButton;
    @FXML
    public Label loginScreen;


    public void initialize(){
        AnimationManager.nodeHover(usernameField);
        AnimationManager.nodeHover(passwordField);
        AnimationManager.nodeHover(checkBox);
        AnimationManager.nodeHover(hyperLink);
        AnimationManager.nodeHover(loginButton);


    }


    public void rememberUser(ActionEvent actionEvent) {
    }

    public void restPassword(ActionEvent actionEvent) {
    }

    public void handleLogin(ActionEvent actionEvent) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        AppUser user = UserDAO.login(username, password);
        try {

        if (user != null) {
             switch (user.getRole()) {
                 case "ADMIN":
                     SceneManager.switchScene(actionEvent, "/fxml/attendance-admin.fxml");
                     break;
                     case "MANAGER":
                         SceneManager.switchScene(actionEvent, "/fxml/attendance-manager.fxml");
                         break;
                         case "USER":
                             SceneManager.switchScene(actionEvent, "/fxml/attendance-user.fxml");
                             break;
                             default:
                                 loginScreen.setText("Unkown Role" + user.getRole());
             }

        }else {
            loginScreen.setText("Wrong username or password");
            AnimationManager.shake(loginScreen,10,-10,10,6,true);
        }
        }catch(Exception e){
            loginScreen.setText(e.getMessage());
            AnimationManager.shake(loginScreen,10,-10,10,6,true);

        }
    }
}
