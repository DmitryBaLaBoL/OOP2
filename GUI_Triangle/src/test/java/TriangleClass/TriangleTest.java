// Author: Tikhonov Dmitry
package TriangleClass;

// Подключение аннотации
import org.junit.jupiter.api.Test;
// Подключении статических функций для тестов
import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    /** Проверяем методы сеттеры и геттеры*/
    @Test
    public void Test_Set_Get() {
        //Создаём треугольник по-умолчанию и проверяем координаты геттерами
        Triangle Test1 = new Triangle();
        assertEquals(Test1.Get_X_A(), 0.0);
        assertEquals(Test1.Get_Y_A(), 0.0);
        assertEquals(Test1.Get_X_B(), 1.0);
        assertEquals(Test1.Get_Y_B(), 0.0);
        assertEquals(Test1.Get_X_C(), 0.0);
        assertEquals(Test1.Get_Y_C(), 1.0);

        // Создаём треугольник, но уже конструктором с параметрами и также проверяем
        Triangle Test2 = new Triangle(2.0, 1.0, 4.0, 3.0, 2.0, 5.0);
        assertEquals(Test2.Get_X_A(), 2.0);
        assertEquals(Test2.Get_Y_A(), 1.0);
        assertEquals(Test2.Get_X_B(), 4.0);
        assertEquals(Test2.Get_Y_B(), 3.0);
        assertEquals(Test2.Get_X_C(), 2.0);
        assertEquals(Test2.Get_Y_C(), 5.0);
        // Запоминаем координаты точки B
        double oldxb = Test2.Get_X_B();
        double oldyb = Test2.Get_Y_B();

        // Задаём координаты точек и стестируем (Координаты точки B не должны были поменяться)
        Test2.Set_AllCoordinate(3.0, 2.0, 4.0, 3.0, 1.0, 4.0);
        assertEquals(Test2.Get_X_A(), 3.0);
        assertEquals(Test2.Get_Y_A(), 2.0);
        assertEquals(Test2.Get_X_B(), oldxb);
        assertEquals(Test2.Get_Y_B(), oldyb);
        assertEquals(Test2.Get_X_C(), 1.0);
        assertEquals(Test2.Get_Y_C(), 4.0);

        // Далее проверяем отдельные сеттеры координат для каждой точки
        // Точка А
        Test2.Set_CoordinateA(5.0, 5.0);
        assertEquals(Test2.Get_X_A(), 5.0);
        assertEquals(Test2.Get_Y_A(), 5.0);
        oldxb = Test2.Get_X_B();
        oldyb = Test2.Get_Y_B();

        // Точка B координаты не должны измениться
        Test2.Set_CoordinateB(5.0, 5.0);
        assertEquals(Test2.Get_X_B(), oldxb);
        assertEquals(Test2.Get_Y_B(), oldyb);

        // ТОчка С
        Test2.Set_CoordinateC(0.0, 0.0);
        assertEquals(Test2.Get_X_C(), 0.0);
        assertEquals(Test2.Get_Y_C(), 0.0);
    }

    /**Проверяем методы поиска длин сторон треугольника  */
    @Test
    public void Test_Lengths() {
        // Задаём изначальные координаты и тестируем мкетоды поиска длин сторон треугольника
        Triangle Test = new Triangle(5,5,4,3,0,0);
        assertTrue(Math.abs(Test.Length_A() - 5.0) < 0.001); // BC = 5.0
        assertTrue(Math.abs(Test.Length_B() - 7.07106) < 0.001); // AC = 7.07106
        assertTrue(Math.abs(Test.Length_C() - 2.236) < 0.001); // AB = 2.236

        // Меняем координаты и ещё раз проверяем
        Test.Set_AllCoordinate(-4.2,3.6,8.9,1.9,0,0);
        assertTrue(Math.abs(Test.Length_A() - 9.101) < 0.01);  // BC = 5.0
        assertTrue(Math.abs(Test.Length_B() - 5.532) < 0.001); // AC = 7.07106
        assertTrue(Math.abs(Test.Length_C() - 13.21) < 0.001); // AB = 2.236
    }

    /**Проверяем методы поиска углов треугольника  */
    @Test
    public void Test_Angles() {
        // Задаём изначальные координаты и тестируем методы поиска углов треугольника
        Triangle Test = new Triangle(5,5,4,3,0,0);
        assertTrue(Math.abs(Test.Angle_A() - 18.435) < 0.001); // A = 18.435
        assertTrue(Math.abs(Test.Angle_B() - 153.435) < 0.001); // B = 153.435
        assertTrue(Math.abs(Test.Angle_C() - 8.13) < 0.001); // C = 8.13

        // Меняем координаты и ещё раз проверяем
        Test.Set_AllCoordinate(-4.2,3.6,8.9,1.9,0,0);
        assertTrue(Math.abs(Test.Angle_A() - 33.207) < 0.01);  // A = 33.207
        assertTrue(Math.abs(Test.Angle_B() - 19.445) < 0.001); // B = 19.445
        assertTrue(Math.abs(Test.Angle_C() - 127.348) < 0.001); // C = 127.348

    }

    /**Проверяем методы периметра и площади треугольника  */
    @Test
    public void Test_Perimetr_Square() {
        // Задаём изначальные координаты и тестируем периметр и площадь
        Triangle Test = new Triangle(5,5,4,3,0,0);
        assertTrue(Math.abs(Test.Square() - 2.5) < 0.001);
        assertTrue(Math.abs(Test.Perimetr() - 14.307) < 0.001);

        // Меняем координаты и ещё раз проверяем
        Test.Set_AllCoordinate(-4.2,3.6,8.9,1.9,0,0);
        assertTrue(Math.abs(Test.Square() - 20.01) < 0.001);
        assertTrue(Math.abs(Test.Perimetr() - 27.842) < 0.001);
    }

    /**Проверяем метод toString  */
    @Test
    public void Test_toString() {
        Triangle Test = new Triangle(5,5,4,3,0,0);
        String s = "Координаты треугольника: A(5.0:5.0) B(4.0:3.0) C(0.0:0.0)";
        assertEquals(Test.toString(), s);
        Test.Set_AllCoordinate(1.3, 2.1, 5.6, 2.3, 3.3, 5.9);
        s = "Координаты треугольника: A(1.3:2.1) B(5.6:2.3) C(3.3:5.9)";
        assertEquals(Test.toString(), s);

    }
}