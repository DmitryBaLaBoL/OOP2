module com.example.gui_triangle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui_triangle to javafx.fxml;
    exports com.example.gui_triangle;
}