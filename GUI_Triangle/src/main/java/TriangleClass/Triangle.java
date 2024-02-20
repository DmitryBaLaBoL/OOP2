// Author: Tikhonov Dmitry
package TriangleClass;

// Класс треугольника
public class Triangle {
    // Описание полей класса

    /** Координата вершины A по x*/
    private double Ax = 0.0;
    /**Координата вершины A по y*/
    private double Ay = 0.0;
    /**Координата вершины B по x*/
    private double Bx = 1.0;
    /**Координата вершины B по y*/
    private double By = 0.0;
    /**Координата вершины C по x*/
    private double Cx = 0.0;
    /**Координата вершины C по y*/
    private double Cy = 1.0;

    /** Перечисления для поиска вершины*/
    private static enum Vertex {
        A,B,C;

        private Vertex() {
        }
    }

    /** Проверка есть ли уже вершина с такими координатами*/
    private boolean Is_Coordinate(double newX, double newY, Vertex Top) {
        switch (Top) {
            case A:
                return newX == this.Bx && newY == this.By || newX == this.Cx && newY == this.Cy;
            case B:
                return newX == this.Ax && newY == this.Ay || newX == this.Cx && newY == this.Cy;
            case C:
                return newX == this.Ax && newY == this.Ay || newX == this.Bx && newY == this.By;
            default:
                return false;
        }
    }
    /** Конструктор по умолчанию*/
    public Triangle() {
        Ax = 0;
        Ay = 0;
        Bx = 1;
        By = 0;
        Cx = 0;
        Cy = 1;
    }

    /** Конструктор с указанием параметров*/
    public Triangle(double a_x, double a_y, double b_x, double b_y, double c_x, double c_y) {
        this.Set_AllCoordinate(a_x, a_y, b_x, b_y, c_x, c_y);
    }

    /** Сеттер всех вершин треугольника*/
    public void Set_AllCoordinate(double a_x, double a_y, double b_x, double b_y, double c_x, double c_y) {
        double oldxA = this.Ax;
        double oldyA = this.Ay;
        double oldxB = this.Bx;
        double oldyB = this.By;
        double oldxC = this.Cx;
        double oldyC = this.Cy;
        if (!this.Is_Coordinate(a_x, a_y, Triangle.Vertex.A)) {
            this.Ax = a_x;
            this.Ay = a_y;
            if (!this.Is_Coordinate(b_x, b_y, Triangle.Vertex.B)) {
                this.Bx = b_x;
                this.By = b_y;
                if (!this.Is_Coordinate(c_x, c_y, Triangle.Vertex.C)) {
                    this.Cx = c_x;
                    this.Cy = c_y;
                } else {
                    this.Cx = oldxC;
                    this.Cy = oldyC;
                }
            } else {
                this.Bx = oldxB;
                this.By = oldyB;
                this.Cx = oldxC;
                this.Cy = oldyC;
            }
        } else {
            this.Ax = oldxA;
            this.Ay = oldyA;
            this.Bx = oldxB;
            this.By = oldyB;
            this.Cx = oldxC;
            this.Cy = oldyC;
        }
    }

    /** Сеттер вершины A*/
    public void Set_CoordinateA(double NewCoorginateX, double NewCoorginateY) {
        if (!this.Is_Coordinate(NewCoorginateX, NewCoorginateY, Triangle.Vertex.A)) {
            this.Ax = NewCoorginateX;
            this.Ay = NewCoorginateY;
        }

    }

    /** Сеттер вершины B*/
    public void Set_CoordinateB(double NewCoorginateX, double NewCoorginateY) {
        if (!this.Is_Coordinate(NewCoorginateX, NewCoorginateY, Triangle.Vertex.B)) {
            this.Bx = NewCoorginateX;
            this.By = NewCoorginateY;
        }

    }

    /** Сеттер вершины C*/
    public void Set_CoordinateC(double NewCoorginateX, double NewCoorginateY) {
        if (!this.Is_Coordinate(NewCoorginateX, NewCoorginateY, Triangle.Vertex.C)) {
            this.Cx = NewCoorginateX;
            this.Cy = NewCoorginateY;
        }

    }

    /** Геттер координаты x вершины A*/
    public double Get_X_A() {
        return this.Ax;
    }

    /** Геттер координаты x вершины B*/
    public double Get_X_B() {
        return this.Bx;
    }

    /** Геттер координаты x вершины C*/
    public double Get_X_C() {
        return this.Cx;
    }

    /** Геттер координаты y вершины A*/
    public double Get_Y_A() {
        return this.Ay;
    }

    /** Геттер координаты y вершины B*/
    public double Get_Y_B() {
        return this.By;
    }

    /** Геттер координаты y вершины C*/
    public double Get_Y_C() {
        return this.Cy;
    }

    /** Получение длины стороны напротив вершины A*/
    public double Length_A() {
        return Math.pow(Math.pow(this.Cx - this.Bx, 2.0) + Math.pow(this.Cy - this.By, 2.0), 0.5);
    }

    /** Получение длины стороны напротив вершины B*/
    public double Length_B() {
        return Math.pow(Math.pow(this.Ax - this.Cx, 2.0) + Math.pow(this.Ay - this.Cy, 2.0), 0.5);
    }

    /** Получение длины стороны напротив вершины C*/
    public double Length_C() {
        return Math.pow(Math.pow(this.Ax - this.Bx, 2.0) + Math.pow(this.Ay - this.By, 2.0), 0.5);
    }

    /** Площадь треугольника*/
    public double Square() {
        double p = this.Perimetr() / 2.0;
        return Math.pow(p * (p - this.Length_A()) * (p - this.Length_B()) * (p - this.Length_C()), 0.5);
    }

    /**Периметр треугольника*/
    public double Perimetr() {
        return this.Length_A() + this.Length_B() + this.Length_C();
    }

    /** Угол у вершины A, в градусах*/
    public double Angle_A() {
        return Math.acos((Math.pow(this.Length_B(), 2.0) + Math.pow(this.Length_C(), 2.0) - Math.pow(this.Length_A(), 2.0)) / (2.0 * this.Length_B() * this.Length_C())) * 180.0 / Math.PI;
    }

    /** Угол у вершины B, в градусах*/
    public double Angle_B() {
        return Math.acos((Math.pow(this.Length_A(), 2.0) + Math.pow(this.Length_C(), 2.0) - Math.pow(this.Length_B(), 2.0)) / (2.0 * this.Length_A() * this.Length_C())) * 180.0 / Math.PI;
    }

    /** Угол у вершины C, в градусах*/
    public double Angle_C() {
        return Math.acos((Math.pow(this.Length_A(), 2.0) + Math.pow(this.Length_B(), 2.0) - Math.pow(this.Length_C(), 2.0)) / (2.0 * this.Length_A() * this.Length_B())) * 180.0 / Math.PI;
    }

    /** Получение данных о треугольнике
    Переопределённый метод toString*/
    @Override
    public String toString() {
        String var10000 = Double.toString(this.Ax);
        return "Координаты треугольника: A(" + var10000 + ":" + Double.toString(this.Ay) + ") B(" + Double.toString(this.Bx) + ":" + Double.toString(this.By) + ") C(" + Double.toString(this.Cx) + ":" + Double.toString(this.Cy) + ")";
    }
}
