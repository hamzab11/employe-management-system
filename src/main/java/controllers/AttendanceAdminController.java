package controllers;

import utils.AnimationManager;
import utils.SceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import security.SessionManager;

public class AttendanceAdminController {

    @FXML
    public TextField searchOfficers;
    @FXML
    public Button btnWeapons;
    @FXML
    public Button addOfficer;
    @FXML
    public Button btnHolidays;
    @FXML
    public Button btnPatrols;
    @FXML
    public Button btnReports;
    @FXML
    public Button btnSettings;
    @FXML
    public Button btnOfficers;
    @FXML
    public VBox totalOfficers;
    @FXML
    public VBox activeWeapons;
    @FXML
    public VBox presentToday;
    @FXML
    public VBox onHoliday;



    public void initialize(){
        AnimationManager.applyButtonAnimations(searchOfficers,btnOfficers,btnHolidays,btnPatrols,btnReports,btnSettings,btnWeapons);

    }

    public void handleWeaponsView(ActionEvent actionEvent) {
        try {
        SceneManager.switchScene(actionEvent,"/fxml/weapons-view.fxml");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void handleAddOfficer(ActionEvent event) {
        try {
            SceneManager.switchScene(event, "/fxml/add-officer.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void handleCreateUserPage(ActionEvent event) {
        try {
            SceneManager.switchScene(event, "/fxml/create-user.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}