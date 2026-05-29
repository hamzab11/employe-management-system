module com.ahbpaf.p4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.ahbpaf.p4 to javafx.fxml;
    exports com.ahbpaf.p4;
    exports database;
    opens database to javafx.fxml;
    exports controllers;
    opens controllers to javafx.fxml;
    exports utils;
    opens utils to javafx.fxml;
}