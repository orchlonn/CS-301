package package8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyVectorTest {

    @Test
    public void testConstructorAndToString() {
        double[] values = {1.0, 2.0, 3.0};
        MyVector v = new MyVector(values);
        assertEquals("[1.00, 2.00, 3.00]", v.toString());
    }

    @Test
    public void testCopyConstructor() {
        double[] values = {1.0, 2.0};
        MyVector v1 = new MyVector(values);
        MyVector v2 = new MyVector(v1);
        assertEquals(v1, v2);
        assertNotSame(v1, v2); // Ensure it's a deep copy
    }

    @Test
    public void testGetComponent() {
        double[] values = {1.0, 2.0, 3.0};
        MyVector v = new MyVector(values);
        assertEquals(2.0, v.getComponent(1), 0.001);
        assertThrows(IllegalArgumentException.class, () -> v.getComponent(5));
    }

    @Test
    public void testPlus() {
        MyVector v1 = new MyVector(new double[]{1.0, 2.0});
        MyVector v2 = new MyVector(new double[]{3.0, 4.0});
        MyVector result = v1.plus(v2);
        assertEquals("[4.00, 6.00]", result.toString());
    }

    @Test
    public void testMinus() {
        MyVector v1 = new MyVector(new double[]{5.0, 6.0});
        MyVector v2 = new MyVector(new double[]{3.0, 4.0});
        MyVector result = v1.minus(v2);
        assertEquals("[2.00, 2.00]", result.toString());
    }

    @Test
    public void testScaledBy() {
        MyVector v = new MyVector(new double[]{1.0, 2.0});
        MyVector result = v.scaledBy(3.0);
        assertEquals("[3.00, 6.00]", result.toString());
    }

    @Test
    public void testDot() {
        MyVector v1 = new MyVector(new double[]{1.0, 2.0});
        MyVector v2 = new MyVector(new double[]{3.0, 4.0});
        double dotProduct = v1.dot(v2);
        assertEquals(11.0, dotProduct, 0.001); // 1*3 + 2*4 = 11
    }

    @Test
    public void testAbs() {
        MyVector v = new MyVector(new double[]{3.0, 4.0});
        double magnitude = v.abs();
        assertEquals(5.0, magnitude, 0.001); // sqrt(3^2 + 4^2) = 5
    }

    @Test
    public void testEquals() {
        MyVector v1 = new MyVector(new double[]{1.0, 2.0});
        MyVector v2 = new MyVector(new double[]{1.0, 2.0});
        MyVector v3 = new MyVector(new double[]{1.0, 3.0});
        assertTrue(v1.equals(v2));
        assertFalse(v1.equals(v3));
    }

    @Test
    public void testInvalidDimensions() {
        MyVector v1 = new MyVector(new double[]{1.0, 2.0});
        MyVector v2 = new MyVector(new double[]{1.0});
        assertThrows(IllegalArgumentException.class, () -> v1.plus(v2));
        assertThrows(IllegalArgumentException.class, () -> v1.minus(v2));
        assertThrows(IllegalArgumentException.class, () -> v1.dot(v2));
    }
}