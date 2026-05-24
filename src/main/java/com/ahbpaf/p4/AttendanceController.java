package com.ahbpaf.p4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AttendanceController {

    // ================= TABLE =================

    @FXML
    private TableView<Officer> officersTable;

    @FXML
    private TableColumn<Officer, String> matriculeColumn;

    @FXML
    private TableColumn<Officer, String> firstNameColumn;

    @FXML
    private TableColumn<Officer, String> lastNameColumn;

    @FXML
    private TableColumn<Officer, String> gradeColumn;

    @FXML
    private TableColumn<Officer, String> gunIdColumn;

    @FXML
    private TableColumn<Officer, Integer> bulletsColumn;

    @FXML
    private TableColumn<Officer, String> badgeColumn;

    @FXML
    private TableColumn<Officer, String> statusColumn;

    // ================= SEARCH =================

    @FXML
    private TextField searchField;

    // ================= DATA =================

    private final ObservableList<Officer> officers =
            FXCollections.observableArrayList();

    // ================= INITIALIZE =================

    @FXML
    public void initialize() {

        loadDummyData();

        officersTable.setItems(officers);
    }

    // ================= BUTTONS =================

    @FXML
    private void handleAddOfficer() {

        System.out.println("Add Officer clicked");
    }

    @FXML
    private void handleSearch() {

        String keyword = searchField.getText();

        System.out.println("Searching for: " + keyword);
    }

    // ================= SAMPLE DATA =================

    private void loadDummyData() {

        officers.add(new Officer(
                "POL-1001",
                "Hamza",
                "Ali",
                "Inspector",
                "GUN-551",
                30,
                "BDG-771",
                "Active"
        ));

        officers.add(new Officer(
                "POL-1002",
                "John",
                "Smith",
                "Officer",
                "GUN-552",
                24,
                "BDG-772",
                "On Duty"
        ));

        officers.add(new Officer(
                "POL-1003",
                "Michael",
                "Brown",
                "Chief",
                "GUN-553",
                40,
                "BDG-773",
                "Holiday"
        ));
    }

    // ================= OFFICER MODEL =================

    public static class Officer {

        private final String matricule;
        private final String firstName;
        private final String lastName;
        private final String grade;
        private final String gunId;
        private final Integer bullets;
        private final String badge;
        private final String status;

        public Officer(
                String matricule,
                String firstName,
                String lastName,
                String grade,
                String gunId,
                Integer bullets,
                String badge,
                String status
        ) {

            this.matricule = matricule;
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
            this.gunId = gunId;
            this.bullets = bullets;
            this.badge = badge;
            this.status = status;
        }

        public String getMatricule() {
            return matricule;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getGrade() {
            return grade;
        }

        public String getGunId() {
            return gunId;
        }

        public Integer getBullets() {
            return bullets;
        }

        public String getBadge() {
            return badge;
        }

        public String getStatus() {
            return status;
        }
    }
}