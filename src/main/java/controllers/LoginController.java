package controllers;

import utils.AnimationManager;
import utils.SceneManager;
import database.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import model.AppUser;
import security.SessionManager;

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
    @FXML
    public Pane loginCard;
    @FXML
    public StackPane rootLoginPage;
    @FXML
    public ImageView appLogo;
    @FXML
    public Label appTitle;
    @FXML
    public VBox loginForm;
    @FXML
    public VBox loginHeader;
    @FXML
    public Label loginSubtitle;
    @FXML
    public Label loginTitle;
    @FXML
    public VBox usernameBox;
    @FXML
    public VBox passwordBox;
    @FXML
    public HBox loginOptions;
    @FXML
    public Pane rightPanel;
    @FXML
    public Circle circleOne;
    @FXML
    public Circle circleTwo;
    @FXML
    public Circle circleThree;
    @FXML
    public StackPane dgsnImageCard;
    @FXML
    public ImageView dgsnImage;


    public void initialize(){
        AnimationManager.applyButtonAnimations();
        AnimationManager.fade(rootLoginPage,0.5,0,1,false);
        //AnimationManager.fade(loginCard,1.2,0,1);
        AnimationManager.pageEntrance(loginCard);
        AnimationManager.pageEntrance(appLogo);
        AnimationManager.slideFromOnXaxis(appTitle,-40,700);
        AnimationManager.slideFromOnXaxis(loginForm,-40,700);
        AnimationManager.pageEntrance(loginHeader);
        AnimationManager.searchFocus(usernameBox);
        AnimationManager.searchFocus(usernameField);
        AnimationManager.searchFocus(passwordBox);
        AnimationManager.searchFocus(passwordField);
        AnimationManager.pageEntrance(loginOptions);
        AnimationManager.nodeHover(checkBox);
        AnimationManager.blueButtonHover(hyperLink);
        AnimationManager.blueButtonHover(loginButton);
        AnimationManager.pageEntrance(rightPanel);
        AnimationManager.floating(circleOne);
        AnimationManager.floating(circleTwo);
        AnimationManager.floating(circleThree);
        AnimationManager.cardHover(dgsnImageCard);
        AnimationManager.floating(dgsnImage);






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
            SessionManager.startSession(user);
            System.out.println("i called from login controller"+SessionManager.getCurrentUsername());
            System.out.println("i called from login controller"+SessionManager.getCurrentRole());

             switch (user.getRole()) {
                 case "ADMIN":
                     SceneManager.switchScene(actionEvent, "/fxml/attendance-admin.fxml");
                     break;
                     case "MANAGER":
                         SceneManager.switchScene(actionEvent, "/fxml/attendance-manager.fxml");

                         break;
                         case "USER":

                             break;
                             default:
                                 loginScreen.setText("Unkown Role" + user.getRole());
             }

        }else {
            loginScreen.setText("Wrong username or password");
            //AnimationManager.shake(loginScreen,10,-10,10,6,true);
            AnimationManager.shake(loginScreen,50,-8,8,6,true);
        }
        }catch(Exception e){
            loginScreen.setText(e.getMessage());
            //AnimationManager.shake(loginScreen,10,-10,10,6,true);
            AnimationManager.shake(loginScreen,50,-8,8,6,true);

        }
    }
}
