package OOP;

/**
 * Rectangle
 */
public class Rectangle {
    int l, w;

    Rectangle() {
        this.l = 1;
        this.w = 1;
    }

    Rectangle(int l, int w) {
        this.l = l;
        this.w = w;

    }

    public int getArea() {
        return l * w;
    }

    public int getPerimeter() {
        return (2 * l) + (2 * w);
    }

    void printStats() {
        System.out.println("Area: " + getArea() + "Perimeter: " + getPerimeter());
    }

}