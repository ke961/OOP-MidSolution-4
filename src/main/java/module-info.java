module com.example.solution4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.solution4 to javafx.fxml;
    exports com.example.solution4;
}