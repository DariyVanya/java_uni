package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    @Test(dataProvider = "integerProvider")
    public void integerTest(int p1, int p2, int p3) {
        assertEquals(new Main().int5(p1, p2), p3, "for " + p1 + " " + p2);
    }

    @DataProvider
    public Object[][] integerProvider() {
        return new Object[][] { { 100, 10, 0 } };
    }
//=======================================================
    @Test(dataProvider = "ifProvider")
    public void ifTest(int p1, int p2, int p3, int[] p4) {
        assertEquals(new Main().if5(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] ifProvider() {
        int[] output1 = {2, 1};
        int[] output2 = {3, 0};
        int[] output3 = {1, 2};

        return new Object[][] { { 2, 3, -1, output1 }, { 0, 0, 0, output2 }, { -3, -3, 1, output3 } };
    }
//=======================================================
    @Test(dataProvider = "booleanProvider")
    public void booleanTask(int p1, int p2, boolean p3) {
        assertEquals(new Main().boolean5(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][] { { 0, -3, true }, { 0, 0, true }, { -3, 3, false } };
    }
//=======================================================
    @Test(dataProvider = "switchProvider")
    public void switchTest(int p1, float p2, float p3, float p4) {
        assertEquals(new Main().case5(p1, p2, p3), p4);
    }

    @DataProvider
    public Object[][] switchProvider() {
        return new Object[][] { { 1, 1, 1, 2 }, { 2, 3, 2, 1 }, { 3, 1, 2, 2 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeSwitchProvider")
    public void negativeSwitchTest(int p1, float p2, float p3) {
        new Main().case5(p1, p2, p3);
    }

    @DataProvider
    public Object[][] negativeSwitchProvider() {
        return new Object[][] { { 0, 1, 2 }, { 5, 1, 2 } };
    }


//=======================================================
    @Test(dataProvider = "forProvider")
    public void forTest(int n, float[] p2) {
        assertEquals(new Main().for5(n), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        float[] output1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        float[] output2 = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
        return new Object[][] { { 10, output1 }, { 1000, output2 } };
    }
//=======================================================
    @Test(dataProvider = "whileProvider")
    public void whileTest(int n, int c) {
        assertEquals(new Main().while5(n), c);
    }

    @DataProvider
    public Object[][] whileProvider() {
        return new Object[][] { { 8, 3 }, { 4, 2 }, { 16, 4 } };
    }

    @Test(expectedExceptions = AssertionError.class, dataProvider = "negativeWhileProvider")
    public void negativeWhileTest(int n) {
        new Main().while5(n);
    }

    @DataProvider
    public Object[][] negativeWhileProvider() {
        return new Object[][] { { -1 }, { -2 } };
    }
//=======================================================
    @Test(dataProvider = "arrayProvider")
    public void arrayTest(int n, int[] result) {
        assertEquals(new Main().array5(n), result);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] { { 10, new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34} },
                { 3, new int[] { 0, 1, 1 } } };
    }
//=======================================================
    @Test(dataProvider = "matrixProvider")
    public void twoDimensionArrayTest(int n, int d, int[] m, int[][] output) {
        assertEquals(new Main().matrix5(n, d, m), output);
    }

    @DataProvider
    public Object[][] matrixProvider() {

        int[] input = { 1, 2, 3, 4 };
        return new Object[][] { { 3, 5,  input, new int[][] { {1, 6, 11}, {2, 7, 12}, {3, 8, 13}, {4, 9, 14} } } };
    }

}