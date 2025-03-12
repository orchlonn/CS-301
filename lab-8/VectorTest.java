public class VectorTest {
    public static void main(String[] args) {
        // Create two vectors
        double[] v1Data = {1.0, 2.0, 3.0};
        double[] v2Data = {4.0, 5.0, 6.0};
        MyVector v1 = new MyVector(v1Data);
        MyVector v2 = new MyVector(v2Data);

        // Test toString
        System.out.println("v1 = " + v1); // [1.0, 2.0, 3.0]
        System.out.println("v2 = " + v2); // [4.0, 5.0, 6.0]

        // Test addition
        MyVector v3 = v1.plus(v2);
        System.out.println("v1 + v2 = " + v3); // [5.0, 7.0, 9.0]

        // Test subtraction
        MyVector v4 = v2.minus(v1);
        System.out.println("v2 - v1 = " + v4); // [3.0, 3.0, 3.0]

        // Test scalar multiplication
        MyVector v5 = v1.scaledBy(2.0);
        System.out.println("2 * v1 = " + v5); // [2.0, 4.0, 6.0]

        // Test dot product
        double dotProduct = v1.dot(v2);
        System.out.println("v1 • v2 = " + dotProduct); // 32.0 (1*4 + 2*5 + 3*6)

        // Test absolute value
        double absV1 = v1.abs();
        System.out.println("|v1| = " + absV1); // ~3.7416573867739413 (sqrt(1^2 + 2^2 + 3^2))

        // Test equals
        MyVector v1Copy = new MyVector(v1);
        System.out.println("v1 equals v1Copy? " + v1.equals(v1Copy)); // true
        System.out.println("v1 equals v2? " + v1.equals(v2));         // false

        // Test accessor
        // System.out.println("v1[1] = " + v1.get(1)); // 2.0
    }
}