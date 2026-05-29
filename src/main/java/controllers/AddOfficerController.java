package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.AppUser;
import security.AdminOverrideDialog;
import security.PermissionGuard;

public class AddOfficerController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField rankField;

    @FXML
    private TextField badgeNumberField;

    @FXML
    private TextField departmentField;

    @FXML
    private Label messageLabel;

    public void handleSaveOfficer(ActionEvent event) {

        if (fullNameField.getText().trim().isEmpty()
                || rankField.getText().trim().isEmpty()
                || badgeNumberField.getText().trim().isEmpty()
                || departmentField.getText().trim().isEmpty()) {

            messageLabel.setText("Please fill all fields.");
            return;
        }

        AppUser overrideAdmin = null;

        if (PermissionGuard.canWriteDirectly()) {

            saveOfficer();
            messageLabel.setText("Officer saved by ADMIN.");

        } else if (PermissionGuard.requiresAdminOverrideForWrite()) {

            overrideAdmin = AdminOverrideDialog.requestAdminAuthorization();

            if (overrideAdmin == null) {
                messageLabel.setText("Save cancelled. Admin authorization failed.");
                return;
            }

            saveOfficer();
            messageLabel.setText("Officer saved with Admin Override by: " + overrideAdmin.getUsername());

        } else {

            messageLabel.setText("You do not have permission to save.");
        }
    }

    private void saveOfficer() {

        String fullName = fullNameField.getText().trim();
        String rank = rankField.getText().trim();
        String badgeNumber = badgeNumberField.getText().trim();
        String department = departmentField.getText().trim();

        System.out.println("Saving officer...");
        System.out.println("Full name: " + fullName);
        System.out.println("Rank: " + rank);
        System.out.println("Badge number: " + badgeNumber);
        System.out.println("Department: " + department);

        // هنا لاحقًا نضع:
        // OfficerDAO.createOfficer(...)
    }
}