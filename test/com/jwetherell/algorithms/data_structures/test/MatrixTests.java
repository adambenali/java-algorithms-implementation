package com.jwetherell.algorithms.data_structures.test;

import org.junit.Test;

import com.jwetherell.algorithms.data_structures.Matrix;


import java.math.BigDecimal;
import java.math.BigInteger;
import static org.junit.Assert.*;


public class MatrixTests {

    /**
     * Trying to add two matrices of different
     * dimensions should return an empty (null-filled)
     * matrix with dimensions equal to the matrix whose
     * add method was called.
     */
    @Test
    public void testAddBadDimensions() {
        Matrix<Double> m1 = new Matrix<>(2, 1);
        Matrix<Double> m2 = new Matrix<>(1, 2);
        m1.set(0,0, 1.0);
        m1.set(1,0, 1.0);
        m2.set(0,0, 1.0);
        m2.set(0,1, 1.0);

        Matrix<Double> res = m1.add(m2);
        assertEquals(res.getCols(), m1.getCols());
        assertEquals(res.getRows(), m1.getRows());
        assertNull(res.get(0, 0));
        assertNull(res.get(1, 0));
    }

    /**
     * Test matrix addition of BigInteger objects
     */
    @Test
    public void testAddBigInteger() {
        Matrix<BigInteger> m1 = new Matrix<>(2, 1);
        Matrix<BigInteger> m2 = new Matrix<>(2, 1);
        m1.set(0,0, BigInteger.valueOf(8));
        m2.set(0,0, BigInteger.valueOf(2));
        m1.set(1,0, BigInteger.valueOf(4));
        m2.set(1,0, BigInteger.valueOf(3));

        Matrix<BigInteger> res = m1.add(m2);
        assertEquals(BigInteger.valueOf(10), res.get(0,0));
        assertEquals(BigInteger.valueOf(7), res.get(1,0));
    }

    /**
     * Test matrix addition of BigDecimal objects
     */
    @Test
    public void testAddBigDecimal() {
        Matrix<BigDecimal> m1 = new Matrix<>(2, 1);
        Matrix<BigDecimal> m2 = new Matrix<>(2, 1);
        m1.set(0,0, BigDecimal.valueOf(8.2));
        m2.set(0,0, BigDecimal.valueOf(2.3));
        m1.set(1,0, BigDecimal.valueOf(4.8));
        m2.set(1,0, BigDecimal.valueOf(3.1));

        Matrix<BigDecimal> res = m1.add(m2);
        assertEquals(BigDecimal.valueOf(10.5), res.get(0,0));
        assertEquals(BigDecimal.valueOf(7.9), res.get(1,0));
    }

    /**
     * Test matrix addition of Long objects
     */
    @Test
    public void testAddLong() {
        Matrix<Long> m1 = new Matrix<>(2, 1);
        Matrix<Long> m2 = new Matrix<>(2, 1);
        m1.set(0,0, 8L);
        m2.set(0,0, 2L);
        m1.set(1,0, 4L);
        m2.set(1,0, 3L);

        Matrix<Long> res = m1.add(m2);
        assertEquals(10L, res.get(0,0));
        assertEquals(7L, res.get(1,0));
    }

    @Test
    public void testMatrix() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Matrix<Integer> matrix2 = new Matrix<Integer>(3, 2);
        matrix2.set(0, 0, 12);
        matrix2.set(0, 1, 25);
        matrix2.set(1, 0, 9);
        matrix2.set(1, 1, 10);
        matrix2.set(2, 0, 8);
        matrix2.set(2, 1, 5);

        // Result of multiplication
        Integer[][] array1 = new Integer[][]{{273,455},
                                             {243,235},
                                             {244,205},
                                             {102,160}};
        Matrix<Integer> result1 = new Matrix<Integer>(4,2,array1);

        Matrix<Integer> matrix3 = matrix1.multiply(matrix2);
        assertTrue("Matrix multiplication error. matrix3="+matrix3+" result1"+result1, matrix3.equals(result1));

        int rows = 2;
        int cols = 2;
        int counter = 0;
        Matrix<Integer> matrix4 = new Matrix<Integer>(rows, cols);
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix4.set(r, c, counter++);

        // Result of subtraction
        Integer[][] array2 = new Integer[][]{{0,0},
                                             {0,0}};
        Matrix<Integer> result2 = new Matrix<Integer>(2,2,array2);

        Matrix<Integer> matrix5 = matrix4.subtract(matrix4);
        assertTrue("Matrix subtraction error. matrix5="+matrix5+" result2"+result2, matrix5.equals(result2));

        // Result of addition
        Integer[][] array3 = new Integer[][]{{0,2},
                                             {4,6}};
        Matrix<Integer> result3 = new Matrix<Integer>(2,2,array3);

        Matrix<Integer> matrix6 = matrix4.add(matrix4);
        assertTrue("Matrix addition error. matrix6="+matrix6+" result3"+result3, matrix6.equals(result3));

        Matrix<Integer> matrix7 = new Matrix<Integer>(2, 2);
        matrix7.set(0, 0, 1);
        matrix7.set(0, 1, 2);
        matrix7.set(1, 0, 3);
        matrix7.set(1, 1, 4);

        Matrix<Integer> matrix8 = new Matrix<Integer>(2, 2);
        matrix8.set(0, 0, 1);
        matrix8.set(0, 1, 2);
        matrix8.set(1, 0, 3);
        matrix8.set(1, 1, 4);

        // Result of multiplication
        Integer[][] array4 = new Integer[][]{{7,10},
                                             {15,22}};
        Matrix<Integer> result4 = new Matrix<Integer>(2,2,array4);

        Matrix<Integer> matrix9 = matrix7.multiply(matrix8);
        assertTrue("Matrix multiplication error. matrix9="+matrix9+" result4"+result4, matrix9.equals(result4));
    }
    
    @Test
    public void testIdentityMethod1() {
        Matrix<Integer> matrix = new Matrix<Integer>(2, 2);
        matrix.set(0, 0, 0);
        matrix.set(0, 1, 0);
        matrix.set(1, 0, 0);
        matrix.set(1, 1, 0);
        
        Matrix<Integer> expectedResult = new Matrix<Integer>(2, 2);
        expectedResult.set(0, 0, 1);
        expectedResult.set(0, 1, 0);
        expectedResult.set(1, 0, 0);
        expectedResult.set(1, 1, 1);
        
        try{
        	matrix = matrix.identity();
        } catch(Exception ex){
        	fail();
        }
        
        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }

    /**
     * Testing the compare function in Matrix.java
     * by testing BigDecimal numeric type for the matrices.
     * This test should return true.
     */
    @Test
    public void testBigDecimalCompare() {
        // Testing BigDecimal branch
        Matrix<BigDecimal> matrix1 = new Matrix<BigDecimal>(2, 2);
        matrix1.set(0, 0, new BigDecimal("4.0"));
        matrix1.set(0, 1, new BigDecimal("9.0"));
        matrix1.set(1, 0, new BigDecimal("3.0"));
        matrix1.set(1, 1, new BigDecimal("2.0"));

        Matrix<BigDecimal> matrix2 = new Matrix<BigDecimal>(2, 2);
        matrix2.set(0, 0, new BigDecimal("4.0"));
        matrix2.set(0, 1, new BigDecimal("9.0"));
        matrix2.set(1, 0, new BigDecimal("3.0"));
        matrix2.set(1, 1, new BigDecimal("2.0"));

        assertTrue(matrix1.equals(matrix2));
        
    }

    /**
     * Testing the compare function in Matrix.java
     * by testing BigInterger numeric type for the matrices.
     * This test should return true.
     */
    @Test
    public void testBigIntegerCompare() {
        // Testing BigInteger branch
        Matrix<BigInteger> matrix3 = new Matrix<BigInteger>(2, 2);
        matrix3.set(0, 0, new BigInteger("4"));
        matrix3.set(0, 1, new BigInteger("9"));
        matrix3.set(1, 0, new BigInteger("3"));
        matrix3.set(1, 1, new BigInteger("2"));

        Matrix<BigInteger> matrix4 = new Matrix<BigInteger>(2, 2);
        matrix4.set(0, 0, new BigInteger("4"));
        matrix4.set(0, 1, new BigInteger("9"));
        matrix4.set(1, 0, new BigInteger("3"));
        matrix4.set(1, 1, new BigInteger("2"));

        assertTrue(matrix3.equals(matrix4));

    }

    /**
     * Testing the compare function in Matrix.java
     * by testing Long,Double and float numeric type for the matrices.
     */
    @Test
    public void testNumericTypesCompare2() {
        // Testing Long branch, the second condition in the if statement.
        Matrix<Integer> matrix5 = new Matrix<Integer>(2, 2);
        matrix5.set(0, 0, 4);
        matrix5.set(0, 1, 9);
        matrix5.set(1, 0, 3);
        matrix5.set(1, 1, 2);

        Matrix<Long> matrix6 = new Matrix<Long>(2, 2);
        matrix6.set(0, 0, 4L);
        matrix6.set(0, 1, 9L);
        matrix6.set(1, 0, 3L);
        matrix6.set(1, 1, 2L);

        assertTrue(matrix5.equals(matrix6));

        // Testing Double branch
        Matrix<Double> matrix7 = new Matrix<Double>(2, 2);
        matrix7.set(0, 0, 4.0d);
        matrix7.set(0, 1, 9.0d);
        matrix7.set(1, 0, 3.0d);
        matrix7.set(1, 1, 2.0d);

        Matrix<Double> matrix8 = new Matrix<Double>(2, 2);
        matrix8.set(0, 0, 4.0d);
        matrix8.set(0, 1, 9.0d);
        matrix8.set(1, 0, 3.0d);
        matrix8.set(1, 1, 2.0d);

        assertTrue(matrix7.equals(matrix8));

        // Testing Float branch with two different matrices. Should return false.
        Matrix<Float> matrix9 = new Matrix<Float>(2, 2);
        matrix9.set(0, 0, 4.0f);
        matrix9.set(0, 1, 9.0f);
        matrix9.set(1, 0, 3.0f);
        matrix9.set(1, 1, 2.0f);

        Matrix<Float> matrix10 = new Matrix<Float>(2, 2);
        matrix10.set(0, 0, 1.0f);
        matrix10.set(0, 1, 2.0f);
        matrix10.set(1, 0, 5.0f);
        matrix10.set(1, 1, 6.0f);

        assertFalse(matrix9.equals(matrix10));
    }

    /**
     * Test equals() method of Matrix class.
     * Test formal properties like shape and content.
     */
    @Test
    public void testMatrixEqualsFormal() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);

        // return false if obj provided is null
        assertFalse(matrix1.equals(null));

        // String is not an instance of Matrix
        String string = "I'm a string!";
        assertFalse(matrix1.equals(string));

        // # of rows don't match
        Matrix<Integer> matrix2 = new Matrix<Integer>(5, 3);
        assertFalse(matrix1.equals(matrix2));

        // # of cols don't match
        Matrix<Integer> matrix3 = new Matrix<Integer>(4, 4);
        assertFalse(matrix1.equals(matrix3));
    }

    /**
     * Test equals() method of Matrix class.
     * Test the content of the matrix.
     */
    @Test
    public void testMatrixEqualsContent() {

        Matrix<Integer> matrix1 = new Matrix<Integer>(2, 2);
        matrix1.set(0, 0, 0);
        matrix1.set(0, 1, 0);
        matrix1.set(1, 0, 0);
        matrix1.set(1, 1, 0);

        Matrix<Integer> matrix2 = new Matrix<Integer>(2, 2);
        matrix2.set(0, 0, 0);
        matrix2.set(0, 1, 0);
        matrix2.set(1, 0, 0);
        matrix2.set(1, 1, 0);

        // return true if equal
        assertTrue(matrix1.equals(matrix2));

        // return false if one cell is different
        matrix2.set(0, 0, 1);
        assertFalse(matrix1.equals(matrix2));

        // in different positions
        matrix2.set(0, 0, 0);
        matrix2.set(0, 1, 1);
        assertFalse(matrix1.equals(matrix2));
        matrix2.set(0, 1, 0);
        matrix2.set(1, 0, 1);
        assertFalse(matrix1.equals(matrix2));
        matrix2.set(1, 1, 0);
        matrix2.set(1, 1, 1);
        assertFalse(matrix1.equals(matrix2));

    }

}
