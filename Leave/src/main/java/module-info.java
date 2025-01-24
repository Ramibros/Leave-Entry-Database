module com.example.leave {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.leave to javafx.fxml;
    exports com.example.leave;
}