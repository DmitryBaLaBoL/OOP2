package TriangleClass;

// Подключение аннотации
import org.junit.jupiter.api.Test;
// Подключении статических функций для тестов
import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    @Test
    public void TestClass() {
        Triangle Test1 = new Triangle();
        assertEquals(Test1.Get_X_A(), 0.0);
        assertEquals(Test1.Get_Y_A(), 0.0);
        assertEquals(Test1.Get_X_B(), 1.0);
        assertEquals(Test1.Get_Y_B(), 0.0);
        assertEquals(Test1.Get_X_C(), 0.0);
        assertEquals(Test1.Get_Y_C(), 1.0);
        Triangle Test2 = new Triangle(2.0, 1.0, 4.0, 3.0, 2.0, 5.0);
        assertEquals(Test2.Get_X_A(), 2.0);
        assertEquals(Test2.Get_Y_A(), 1.0);
        assertEquals(Test2.Get_X_B(), 4.0);
        assertEquals(Test2.Get_Y_B(), 3.0);
        assertEquals(Test2.Get_X_C(), 2.0);
        assertEquals(Test2.Get_Y_C(), 5.0);
        double oldxb = Test2.Get_X_B();
        double oldyb = Test2.Get_Y_B();
        Test2.Set_AllCoordinate(3.0, 2.0, 4.0, 3.0, 1.0, 4.0);
        assertEquals(Test2.Get_X_A(), 3.0);
        assertEquals(Test2.Get_Y_A(), 2.0);
        assertEquals(Test2.Get_X_B(), oldxb);
        assertEquals(Test2.Get_Y_B(), oldyb);
        assertEquals(Test2.Get_X_C(), 1.0);
        assertEquals(Test2.Get_Y_C(), 4.0);
        Test2.Set_CoordinateA(5.0, 5.0);
        assertEquals(Test2.Get_X_A(), 5.0);
        assertEquals(Test2.Get_Y_A(), 5.0);
        oldxb = Test2.Get_X_B();
        oldyb = Test2.Get_Y_B();
        Test2.Set_CoordinateB(5.0, 5.0);
        assertEquals(Test2.Get_X_B(), oldxb);
        assertEquals(Test2.Get_Y_B(), oldyb);
        Test2.Set_CoordinateC(0.0, 0.0);
        assertEquals(Test2.Get_X_C(), 0.0);
        assertEquals(Test2.Get_Y_C(), 0.0);
        assertTrue(Math.abs(Test2.Length_A() - 5.0) < 0.001);
        assertTrue(Math.abs(Test2.Length_B() - 7.07106) < 0.001);
        assertTrue(Math.abs(Test2.Length_C() - 2.236) < 0.001);
        assertTrue(Math.abs(Test2.Square() - 2.5) < 0.001);
        assertTrue(Math.abs(Test2.Perimetr() - 14.307) < 0.001);
        assertTrue(Math.abs(Test2.Angle_A() - 18.435) < 0.001);
        assertTrue(Math.abs(Test2.Angle_B() - 153.435) < 0.001);
        assertTrue(Math.abs(Test2.Angle_C() - 8.13) < 0.001);
        String s = "Координаты треугольника: A(5.0:5.0) B(4.0:3.0) C(0.0:0.0)";
        assertEquals(Test2.To_String(), s);
        Test2.Set_AllCoordinate(1.3, 2.1, 5.6, 2.3, 3.3, 5.9);
        s = "Координаты треугольника: A(1.3:2.1) B(5.6:2.3) C(3.3:5.9)";
        assertEquals(Test2.To_String(), s);
    }
}