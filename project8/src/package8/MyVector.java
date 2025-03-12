package package8;

import java.util.ArrayList;

public class MyVector {
    private ArrayList<Double> components;

    // Constructor with array parameter
    public MyVector(double[] initValues) {
        components = new ArrayList<>();
        for (double value : initValues) {
            components.add(value);
        }
    }

    // Copy constructor
    public MyVector(MyVector other) {
        components = new ArrayList<>(other.components);
    }

    // Accessor for k-th component (0-based index)
    public double getComponent(int k) {
        if (k >= 0 && k < components.size()) {
            return components.get(k);
        }
        throw new IllegalArgumentException("Index out of bounds");
    }

    // Vector addition
    public MyVector plus(MyVector other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        double[] result = new double[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = this.components.get(i) + other.components.get(i);
        }
        return new MyVector(result);
    }

    // Vector subtraction
    public MyVector minus(MyVector other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        double[] result = new double[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = this.components.get(i) - other.components.get(i);
        }
        return new MyVector(result);
    }

    // Scalar multiplication
    public MyVector scaledBy(double s) {
        double[] result = new double[components.size()];
        for (int i = 0; i < components.size(); i++) {
            result[i] = s * components.get(i);
        }
        return new MyVector(result);
    }

    // Dot product
    public double dot(MyVector other) {
        if (this.components.size() != other.components.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        double result = 0;
        for (int i = 0; i < components.size(); i++) {
            result += this.components.get(i) * other.components.get(i);
        }
        return result;
    }

    // Absolute value (magnitude)
    public double abs() {
        return Math.sqrt(this.dot(this));
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyVector)) return false;
        MyVector other = (MyVector) obj;
        return this.components.equals(other.components);
    }

    // Override toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < components.size(); i++) {
            sb.append(String.format("%.2f", components.get(i)));
            if (i < components.size() - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}