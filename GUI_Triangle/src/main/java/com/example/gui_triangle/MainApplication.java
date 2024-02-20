// Author: Tikhonov Dmitry
package com.example.gui_triangle;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;



import java.io.IOException;


// Главный класс программы
public class MainApplication extends Application {
    // Переопределённый метод  Start для создания и запуска окна
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 450);
        stage.setTitle("Решение треугольника");
        stage.setScene(scene);
        stage.show();
        //Triangle MainTriangle = new Triangle();


    }
    // Главный метод программы
    public static void main(String[] args) {

        launch();

    }
}