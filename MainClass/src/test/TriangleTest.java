package test;
// Подключении статических функций для тестов
import static org.junit.jupiter.api.Assertions.*;
// Подключение аннотации
import org.junit.jupiter.api.Test;
// Подключаем тестируемый класс
import MainPackage.Triangle;


class TriangleTest {
    @Test
    public void TestClass(){
        // Создание объета класса по умолчанию
        Triangle Test1 = new Triangle();

        // Проверка задания координат по умолчанию
        assertEquals(Test1.Get_X_A(),0);// Ax
        assertEquals(Test1.Get_Y_A(),0);// Ay
        assertEquals(Test1.Get_X_B(),1);// Bx
        assertEquals(Test1.Get_Y_B(),0);// By
        assertEquals(Test1.Get_X_C(),0);// Cx
        assertEquals(Test1.Get_Y_C(),1);// Cy

        // Проверка конструктора с заданием координат
        Triangle Test2 = new Triangle(2,1,4,3,2,5);
        assertEquals(Test2.Get_X_A(),2);// Ax
        assertEquals(Test2.Get_Y_A(),1);// Ay
        assertEquals(Test2.Get_X_B(),4);// Bx
        assertEquals(Test2.Get_Y_B(),3);// By
        assertEquals(Test2.Get_X_C(),2);// Cx
        assertEquals(Test2.Get_Y_C(),5);// Cy

        // Проверка сеттера всех вершин
        // Вершины координаты B не должны измениться
        double oldxb = Test2.Get_X_B();
        double oldyb = Test2.Get_Y_B();
        Test2.Set_AllCoordinate(3,2,4,3,1,4);
        // Вершины координаты B не должны измениться
        assertEquals(Test2.Get_X_A(),3);// Ax
        assertEquals(Test2.Get_Y_A(),2);// Ay
        assertEquals(Test2.Get_X_B(),oldxb);// Bx
        assertEquals(Test2.Get_Y_B(),oldyb);// By
        assertEquals(Test2.Get_X_C(),1);// Cx
        assertEquals(Test2.Get_Y_C(),4);// Cy

        // Проверка сеттера вершины A
        Test2.Set_CoordinateA(5,5);
        assertEquals(Test2.Get_X_A(),5);// Ax
        assertEquals(Test2.Get_Y_A(),5);// Ay

        // Проверка сеттера вершины B
        // Координаты не должны поменяться так как есть уже векршина с такими координатами
        oldxb = Test2.Get_X_B();
        oldyb = Test2.Get_Y_B();
        Test2.Set_CoordinateB(5,5);
        assertEquals(Test2.Get_X_B(),oldxb);// Bx
        assertEquals(Test2.Get_Y_B(),oldyb);// By

        // Проверка сеттера вершины C
        Test2.Set_CoordinateC(0,0);
        assertEquals(Test2.Get_X_C(),0);// Cx
        assertEquals(Test2.Get_Y_C(),0);// Cy

        // Проверка вычисления длин сторон
        assertTrue(Math.abs(Test2.Length_A() - 5) < 0.001); // BC = 5
        assertTrue(Math.abs(Test2.Length_B() - 7.07106) < 0.001); // AC = 7.07106
        assertTrue(Math.abs(Test2.Length_C() - 2.236) < 0.001); // AB = 2.236

        // Проверка вычисления палощади треугольника
        assertTrue(Math.abs(Test2.Square() - 2.5) < 0.001); // Squere = 2.5

        // Проверка вычисления периметра треугольника
        assertTrue(Math.abs(Test2.Perimetr() - 14.307) < 0.001); // Perimetr = 14.307

        // Проверка вычисления углов треугольника
        assertTrue(Math.abs(Test2.Angle_A() - 18.435) < 0.001); // A = 18.435
        assertTrue(Math.abs(Test2.Angle_B() - 153.435) < 0.001); // B = 153.435
        assertTrue(Math.abs(Test2.Angle_C() - 8.13) < 0.001); // C = 8.13

        // Проверка метода To_String
        String s = "Координаты треугольника: A(5.0:5.0) B(4.0:3.0) C(0.0:0.0)";
        assertEquals(Test2.To_String(),s);

        // Изменим координаты и проверим To_String ещё раз
        Test2.Set_AllCoordinate(1.3,2.1,5.6,2.3,3.3,5.9);
        s = "Координаты треугольника: A(1.3:2.1) B(5.6:2.3) C(3.3:5.9)";
        assertEquals(Test2.To_String(),s);

        // Все методы класса протестированы

    }
}