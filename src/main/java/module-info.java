module org.example.lab_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.lab_1 to javafx.fxml;
    exports org.example.lab_1;
}