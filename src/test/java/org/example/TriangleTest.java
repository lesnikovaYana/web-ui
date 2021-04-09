package org.example;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


public class TriangleTest
{
    TriangleFunction function = new TriangleFunction();

    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }

    @Test
    @DisplayName("Позитивный тест - это треугольник")
    public void isThisTriangleTest() {
        Assertions.assertTrue(function.checkSidesOfTriangle(4.00,5.00,6.00));
    }


    @Test
    @DisplayName("Негативный тест - это не треугольник")
    public void isThisNotTriangleTest() {
        Assertions.assertFalse(function.checkSidesOfTriangle(13.00,18.00,31.00));
    }

    @Test
    @DisplayName("Негативный тест - стороны треугольника не должны быть отрицательными")
    public void isNegativeSideTriangleTest() {
        Assertions.assertFalse(function.checkSidesOfTriangle(-3.00,-5.00,1.00));
    }

    @Test
    @DisplayName("Негативный тест - площадь треугольника не равна нулю")
    public void isAreaNegativeTest() {
        Assertions.assertFalse(function.checkSidesOfTriangle(0.00,0.00,0.00));
    }

    @AfterAll
    static void afterAllTests() {
        logger.info("After all tests");
    }

    //возможно придется использовать лямбды для написания тестов
    //или сначала попробовать сделать попроще без них
    //не забыть заменить pom.xml
}
