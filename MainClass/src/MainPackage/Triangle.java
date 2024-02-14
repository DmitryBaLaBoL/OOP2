package MainPackage;

public class Triangle {

    // Перечисления для отслеживания координат
    private enum Vertex {A, B, C}

    ;
    // Ax - Координата вершины A по x,Ay - Координата вершины A по y
    // Bx - Координата вершины B по x,By - Координата вершины B по y
    // Cx - Координата вершины C по x,Cy - Координата вершины C по y
    private double Ax, Ay, Bx, By, Cx, Cy;

    // Проверка есть ли уже вершина с такими координатами
    private boolean Is_Coordinate(double newX, double newY, Vertex Top) {
        switch (Top) {
            case A:
                return (newX == Bx && newY == By) || (newX == Cx && newY == Cy);
            case B:
                return (newX == Ax && newY == Ay) || (newX == Cx && newY == Cy);
            case C:
                return (newX == Ax && newY == Ay) || (newX == Bx && newY == By);
        }
        return false;
    }

    // Конструктор по умолчанию
    public Triangle() {
        Ax = 0;
        Ay = 0;
        Bx = 1;
        By = 0;
        Cx = 0;
        Cy = 1;
    }

    // Конструктор с указанием параметров
    public Triangle(double a_x, double a_y, double b_x, double b_y, double c_x, double c_y) {
        Ax = 0;
        Ay = 0;
        Bx = 1;
        By = 0;
        Cx = 0;
        Cy = 1;
        Set_AllCoordinate(a_x, a_y, b_x, b_y, c_x, c_y);
    }

    // Сеттер всех вершин треугольника
    public void Set_AllCoordinate(double a_x, double a_y, double b_x, double b_y, double c_x, double c_y) {
        double oldxA = Ax, oldyA = Ay, oldxB = Bx, oldyB = By, oldxC = Cx, oldyC = Cy;
        if (!Is_Coordinate(a_x, a_y, Vertex.A)) {
            Ax = a_x;
            Ay = a_y;
        } else {
            Ax = oldxA;
            Ay = oldyA;
            Bx = oldxB;
            By = oldyB;
            Cx = oldxC;
            Cy = oldyC;
            return;
        }
        ;
        if (!Is_Coordinate(b_x, b_y, Vertex.B)) {
            Bx = b_x;
            By = b_y;
        } else {
            Bx = oldxB;
            By = oldyB;
            Cx = oldxC;
            Cy = oldyC;
            return;
        }
        ;
        if (!Is_Coordinate(c_x, c_y, Vertex.C)) {
            Cx = c_x;
            Cy = c_y;
        } else {
            Cx = oldxC;
            Cy = oldyC;
            return;
        }
        ;
    }

    // Сеттер вершины A
    public void Set_CoordinateA(double NewCoorginateX, double NewCoorginateY) {
        if (!Is_Coordinate(NewCoorginateX, NewCoorginateY, Vertex.A)) {
            Ax = NewCoorginateX;
            Ay = NewCoorginateY;
        }
    }

    // Сеттер вершины B
    public void Set_CoordinateB(double NewCoorginateX, double NewCoorginateY) {
        if (!Is_Coordinate(NewCoorginateX, NewCoorginateY, Vertex.B)) {
            Bx = NewCoorginateX;
            By = NewCoorginateY;
        }
    }

    // Сеттер вершины C
    public void Set_CoordinateC(double NewCoorginateX, double NewCoorginateY) {
        if (!Is_Coordinate(NewCoorginateX, NewCoorginateY, Vertex.C)) {
            Cx = NewCoorginateX;
            Cy = NewCoorginateY;
        }
    }

    // Геттер координаты x вершины A
    public double Get_X_A() {
        return Ax;
    }

    // Геттер координаты x вершины B
    public double Get_X_B() {
        return Bx;
    }

    // Геттер координаты x вершины C
    public double Get_X_C() {
        return Cx;
    }

    // Геттер координаты y вершины A
    public double Get_Y_A() {
        return Ay;
    }

    // Геттер координаты y вершины B
    public double Get_Y_B() {
        return By;
    }

    // Геттер координаты y вершины C
    public double Get_Y_C() {
        return Cy;
    }

    // Получение длины стороны напротив вершины A
    public double Length_A() {
        return Math.pow(Math.pow(Cx - Bx, 2) + Math.pow(Cy - By, 2), 0.5);
    }

    // Получение длины стороны напротив вершины B
    public double Length_B() {
        return Math.pow(Math.pow(Ax - Cx, 2) + Math.pow(Ay - Cy, 2), 0.5);
    }

    // Получение длины стороны напротив вершины C
    public double Length_C() {
        return Math.pow(Math.pow(Ax - Bx, 2) + Math.pow(Ay - By, 2), 0.5);
    }

    // Площадь треугольника
    public double Square() {
        double p = Perimetr() / 2;
        return Math.pow(p * (p - Length_A()) * (p - Length_B()) * (p - Length_C()), 0.5);
    }

    //Периметр треугольника
    public double Perimetr() {
        return Length_A() + Length_B() + Length_C();
    }

    // Угол у вершины A, в градусах
    public double Angle_A() {
        return Math.acos((Math.pow(Length_B(), 2) + Math.pow(Length_C(), 2) - Math.pow(Length_A(), 2)) / (2 * Length_B() * Length_C())) * 180 / Math.PI;
    }

    // Угол у вершины B, в градусах
    public double Angle_B() {
        return Math.acos((Math.pow(Length_A(), 2) + Math.pow(Length_C(), 2) - Math.pow(Length_B(), 2)) / (2 * Length_A() * Length_C())) * 180 / Math.PI;
    }

    // Угол у вершины C, в градусах
    public double Angle_C() {
        return Math.acos((Math.pow(Length_A(), 2) + Math.pow(Length_B(), 2) - Math.pow(Length_C(), 2)) / (2 * Length_A() * Length_B())) * 180 / Math.PI;
    }

    // Получение данных о треугольнике
    public String To_String() {
        return "Координаты треугольника: A(" + Double.toString(Ax) + ":" + Double.toString(Ay) + ") " +
                "B(" + Double.toString(Bx) + ":" + Double.toString(By) + ") " +
                "C(" + Double.toString(Cx) + ":" + Double.toString(Cy) + ")";
        }
    }


