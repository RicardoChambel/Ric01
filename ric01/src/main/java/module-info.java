module ric {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ric1 to javafx.fxml;
    exports ric1;
}