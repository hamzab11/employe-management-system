package controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import utils.SceneManager;

public class AttendanceManagerController {
    public Button btnOfficers;
    public Button btnWeapons;
    public Button btnHolidays;
    public Button btnPatrols;
    public Button btnReports;
    public Button btnSettings;
    public TextField searchOfficers;
    public VBox totalOfficers;
    public VBox activeWeapons;
    public VBox presentToday;
    public VBox onHoliday;
    public TableView officersTable;
    public TableColumn colMatricule;
    public TableColumn colFirstName;
    public TableColumn colLastName;
    public TableColumn colGrade;
    public TableColumn colGunId;
    public TableColumn colBullets;
    public TableColumn colBadge;
    public TableColumn colStatus;

    public void handleWeaponsView(ActionEvent actionEvent) {
        try {
            SceneManager.switchScene(actionEvent,"/fxml/weapons-view.fxml");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
