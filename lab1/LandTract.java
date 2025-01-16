// Honor Code: By doing this assignment and submitting, I pledge that this submission is solely my own work, and it is not a copy or partial copy from anywhere.

public class LandTract {
    private int length;
    private int width;

    public LandTract(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public LandTract(LandTract landTract) {
        this.length = landTract.length;
        this.width = landTract.width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int area() {
        return length * width;
    }

    public boolean equals(LandTract landTract) {
        return this.area() == landTract.area();
    }

    @Override
    public String toString() {
        return "Length: " + length + ", Width: " + width + ", Area: " + area();
    }
}
