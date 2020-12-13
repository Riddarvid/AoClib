package riddarvid.aoc.math.geometry;

public class Vector {
    private final int x;
    private final int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int manhattanLength() {
        return Math.abs(x) + Math.abs(y);
    }

    public Vector scaleBy(int value) {
        return new Vector(x * value, y * value);
    }

    public Vector rotateLeft() {
        int newY = x;
        int newX = -y;
        return new Vector(newX, newY);
    }

    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    public Vector add(int x, int y) {
        return add(new Vector(x, y));
    }
}
