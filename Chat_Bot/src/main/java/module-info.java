module org.example.chat_bot {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens org.example.chat_bot to javafx.fxml;
    exports org.example.chat_bot;
}