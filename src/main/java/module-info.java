module org.example.lab_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab_1 to javafx.fxml;
    exports org.example.lab_1;
}