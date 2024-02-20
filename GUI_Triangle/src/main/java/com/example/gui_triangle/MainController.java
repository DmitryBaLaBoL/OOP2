// Author: Tikhonov Dmitry
package com.example.gui_triangle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import TriangleClass.Triangle;

// Класс с обработчиками главного окна
public class MainController {

    // Создаём ссылку на обьект, с которым будем работать
    Triangle MainTriangle = new Triangle();
    // Переменные для считывания координат с формы
    double ax = 0,ay = 0,bx = 1,by = 0,cx = 0,cy = 1;
    // Главное окно программы
    public VBox MainWindow;

    /** Элемент для считывания координаты X вершины C*/
    public TextField Text_C_X;

    /** Элемент для считывания координаты X вершины B*/
    public TextField Text_B_X;

    /** Элемент для считывания координаты X вершины A*/
    public TextField Text_A_X;

    /** Элемент для считывания координаты Y вершины C*/
    public TextField Text_C_Y;

    /** Элемент для считывания координаты Y вершины B*/
    public TextField Text_B_Y;

    /** Элемент для считывания координаты Y вершины A*/
    public TextField Text_A_Y;

    /** Надпись для вывода длины стороны AB*/
    public Label Label_Length_AB;

    /** Надпись для вывода длины стороны AC*/
    public Label Label_Length_AC;

    /** Надпись для вывода длины стороны BC*/
    public Label Label_Length_BC;

    /** Надпись для вывода угла A*/
    public Label Label_Angle_A;

    /** Надпись для вывода угла B*/
    public Label Label_Angle_B;

    /** Надпись для вывода угла C*/
    public Label Label_Angle_C;

    /** Надпись для вывода периметра треугольника*/
    public Label Label_Perimeter;

    /** Надпись для вывода площади треугольника*/
    public Label Label_Square;

    /** Кнопка для создания треугольника
     * (Активирует ввод координат, и создаёт треугольник по-умолчанию)*/
    public Button Button_CreateTriangle;

    /** Кнопка для рассчёта треугольника*/
    public Button ButtonCalculate;
    @FXML
    private Label welcomeText;

    /** Округляет число до целого, если до целого меньше 0.00001*/
    private double RoundNumberDouble(double num){
        double Rnum = Math.round(num);
        if (Math.abs(num - Rnum) < 0.00001){
            return Rnum;
        }
        else{
            return num;
        }
    }

    /**  Проверка можно ли преобразовать string в double*/
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /** Обработчик события для кнопки Button_CreateTriangle
     * Вводит координаты по умолчанию, и открывает доступ к изменению координат*/
    public void onButtonCreateClick() {
        //Triangle MainTriangle = new Triangle();
        ButtonCalculate.setDisable(false);
        Text_A_X.setDisable(false);
        Text_A_X.setText("0");
        Text_A_Y.setDisable(false);
        Text_A_Y.setText("0");
        Text_B_X.setDisable(false);
        Text_B_X.setText("1");
        Text_B_Y.setDisable(false);
        Text_B_Y.setText("0");
        Text_C_X.setDisable(false);
        Text_C_X.setText("0");
        Text_C_Y.setDisable(false);
        Text_C_Y.setText("1");
        Button_CreateTriangle.setDisable(true);
    }

    /** Обработчик события для кнопки ButtonCalculate
     * РАссчитывает треугольник и выводит необходимые данные*/
    public void onCalculateButtonClick(ActionEvent actionEvent) {
        // Проверка введённых данных на корректность
        if (isDouble(Text_A_X.getText())) {ax = Double.parseDouble(Text_A_X.getText()); }
        else{Text_A_X.setText(Double.toString(ax));}

        if (isDouble(Text_A_Y.getText())) {ay = Double.parseDouble(Text_A_Y.getText()); }
        else{Text_A_Y.setText(Double.toString(ay));}

        if (isDouble(Text_B_X.getText())) {bx = Double.parseDouble(Text_B_X.getText()); }
        else{Text_B_X.setText(Double.toString(bx));}

        if (isDouble(Text_B_Y.getText())) {by = Double.parseDouble(Text_B_Y.getText()); }
        else{Text_B_Y.setText(Double.toString(by));}

        if (isDouble(Text_C_X.getText())) {cx = Double.parseDouble(Text_C_X.getText()); }
        else{Text_C_X.setText(Double.toString(cx));}

        if (isDouble(Text_C_Y.getText())) {cy = Double.parseDouble(Text_C_Y.getText()); }
        else{Text_C_Y.setText(Double.toString(cy));}


        // Устанавливаем новые даннеы в треугольник
        MainTriangle.Set_AllCoordinate(ax,ay,bx,by,cx,cy);
        // Выводим снова данные, если координаты треугольника не поменялись
        Text_A_X.setText(Double.toString(MainTriangle.Get_X_A()));
        Text_B_X.setText(Double.toString(MainTriangle.Get_X_B()));
        Text_C_X.setText(Double.toString(MainTriangle.Get_X_C()));
        Text_A_Y.setText(Double.toString(MainTriangle.Get_Y_A()));
        Text_B_Y.setText(Double.toString(MainTriangle.Get_Y_B()));
        Text_C_Y.setText(Double.toString(MainTriangle.Get_Y_C()));


        // Выводим все необходимые данные в соответствующие поля
        Label_Length_AB.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Length_C())));
        Label_Length_AC.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Length_B())));
        Label_Length_BC.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Length_A())));

        Label_Angle_A.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Angle_A())));
        Label_Angle_B.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Angle_B())));
        Label_Angle_C.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Angle_C())));

        Label_Perimeter.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Perimetr())));

        Label_Square.setText(String.format("%.2f",RoundNumberDouble(MainTriangle.Square())));

    }
}