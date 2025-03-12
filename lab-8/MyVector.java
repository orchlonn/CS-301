import java.util.ArrayList;

public class MyVector {
    private ArrayList<Double> components;

    // Constructor with initialization values
    public MyVector(double[] initValues) {
        components = new ArrayList<>();
        for (double value : initValues) {
            components.add(value);
        }
    }

    // Copy Constructor
    public MyVector(MyVector other) {
        this.components = new ArrayList<>(other.components);
    }

    // Accessor for k-th component
    public double getComponent(int k) {
        if (k < 0 || k >= components.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return components.get(k);
    }

    // Addition
    public MyVector plus(MyVector other) {
        checkSize(other);
        double[] result = new double[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = components.get(i) + other.components.get(i);
        }
        return new MyVector(result);
    }

    // Subtraction
    public MyVector minus(MyVector other) {
        checkSize(other);
        double[] result = new double[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = components.get(i) - other.components.get(i);
        }
        return new MyVector(result);
    }

    // Dot product
    public double dot(MyVector other) {
        checkSize(other);
        double sum = 0;
        for (int i = 0; i < components.size(); i++) {
            sum += components.get(i) * other.components.get(i);
        }
        return sum;
    }

    // Scalar multiplication
    public MyVector scaledBy(double scalar) {
        double[] result = new double[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = components.get(i) * scalar;
        }
        return new MyVector(result);
    }

    // Absolute value (magnitude)
    public double abs() {
        return Math.sqrt(this.dot(this));
    }

    // Override toString method
    @Override
    public String toString() {
        return components.toString();
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyVector)) return false;
        MyVector other = (MyVector) obj;
        return this.components.equals(other.components);
    }

    // Helper method to check vector size compatibility
    private void checkSize(MyVector other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must have the same dimensions");
        }
    }

    public String get(int i) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
}
