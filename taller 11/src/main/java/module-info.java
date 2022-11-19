module com.example.taller11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taller11 to javafx.fxml;
    exports com.example.taller11;
}