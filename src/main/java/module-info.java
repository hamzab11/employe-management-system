module com.ahbpaf.p4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ahbpaf.p4 to javafx.fxml;
    exports com.ahbpaf.p4;
}