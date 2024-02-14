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

    Triangle MainTriangle = new Triangle();
    double ax,ay,bx,by,cx,cy;
    public VBox MainWindow;
    public TextField Text_C_X;
    public TextField Text_B_X;
    public TextField Text_A_X;
    public TextField Text_C_Y;
    public TextField Text_B_Y;
    public TextField Text_A_Y;
    public Label Label_Length_AB;
    public Label Label_Length_AC;
    public Label Label_Length_BC;
    public Label Label_Angle_A;
    public Label Label_Angle_B;
    public Label Label_Angle_C;
    public Label Label_Perimeter;
    public Label Label_Square;
    public Button Button_CreateTriangle;
    public Button ButtonCalculate;
    @FXML
    private Label welcomeText;

    // Округляет число до целого, если до целого меньше 0.00001
    private double RoundNumberDouble(double num){
        double Rnum = Math.round(num);
        if (Math.abs(num - Rnum) < 0.00001){
            return Rnum;
        }
        else{
            return num;
        }
    }
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
        //Button_CreateTriangle.setDisable(true);
    }

    public void onCalculateButtonClick(ActionEvent actionEvent) {
        ax = Double.parseDouble(Text_A_X.getText());
        ay = Double.parseDouble(Text_A_Y.getText());
        bx = Double.parseDouble(Text_B_X.getText());
        by = Double.parseDouble(Text_B_Y.getText());
        cx = Double.parseDouble(Text_C_X.getText());
        cy = Double.parseDouble(Text_C_Y.getText());

        MainTriangle.Set_AllCoordinate(ax,ay,bx,by,cx,cy);

        Label_Length_AB.setText(Double.toString(RoundNumberDouble(MainTriangle.Length_C())));
        Label_Length_AC.setText(Double.toString(RoundNumberDouble(MainTriangle.Length_B())));
        Label_Length_BC.setText(Double.toString(RoundNumberDouble(MainTriangle.Length_A())));

        Label_Angle_A.setText(Double.toString(RoundNumberDouble(MainTriangle.Angle_A())));
        Label_Angle_B.setText(Double.toString(RoundNumberDouble(MainTriangle.Angle_B())));
        Label_Angle_C.setText(Double.toString(RoundNumberDouble(MainTriangle.Angle_C())));

        Label_Perimeter.setText(Double.toString(RoundNumberDouble(MainTriangle.Perimetr())));

        Label_Square.setText(Double.toString(RoundNumberDouble(MainTriangle.Square())));

    }
}