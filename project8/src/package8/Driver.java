package package8;

public class Driver {
    public static void main(String[] args) {
        // Create test vectors
        double[] v1Data = {1.0, 2.0, 3.0};
        double[] v2Data = {4.0, 5.0, 6.0};
        
        MyVector v1 = new MyVector(v1Data);
        MyVector v2 = new MyVector(v2Data);
        MyVector v3 = new MyVector(v1); // Using copy constructor

        // Test operations
        System.out.println("Vector 1: " + v1);
        System.out.println("Vector 2: " + v2);
        System.out.println("Vector 3 (copy of v1): " + v3);

        // Test addition
        MyVector sum = v1.plus(v2);
        System.out.println("v1 + v2 = " + sum);

        // Test subtraction
        MyVector diff = v2.minus(v1);
        System.out.println("v2 - v1 = " + diff);

        // Test scalar multiplication
        MyVector scaled = v1.scaledBy(2.0);
        System.out.println("2 * v1 = " + scaled);

        // Test dot product
        double dotProduct = v1.dot(v2);
        System.out.println("v1 • v2 = " + dotProduct);

        // Test absolute value
        System.out.println("|v1| = " + v1.abs());

        // Test equivalence
        System.out.println("v1 equals v3: " + v1.equals(v3));
        System.out.println("v1 equals v2: " + v1.equals(v2));

        // Test accessor
        System.out.println("Second component of v1: " + v1.getComponent(1));
    }
}