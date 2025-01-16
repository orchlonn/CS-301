// Honor Code: By doing this assignment and submitting, I pledge that this submission is solely my own work, and it is not a copy or partial copy from anywhere.

public class LandTractTest {
    public static void main(String[] args) {
        // Create LandTract objects
        LandTract tract1 = new LandTract(30, 40);
        LandTract tract2 = new LandTract(20, 60);
        LandTract tract3 = new LandTract(tract1);

        // Test getLength, getWidth, and area
        System.out.println("Tract 1 Length: " + tract1.getLength());
        System.out.println("Tract 1 Width: " + tract1.getWidth());
        System.out.println("Tract 1 Area: " + tract1.area());

        System.out.println("Tract 2 Length: " + tract2.getLength());
        System.out.println("Tract 2 Width: " + tract2.getWidth());
        System.out.println("Tract 2 Area: " + tract2.area());

        // Test equals method
        System.out.println("Tract 1 equals Tract 2: " + tract1.equals(tract2));
        System.out.println("Tract 1 equals Tract 3: " + tract1.equals(tract3));

        // Test toString method
        System.out.println("Tract 1: " + tract1);
        System.out.println("Tract 2: " + tract2);
        System.out.println("Tract 3: " + tract3);
    }
}
