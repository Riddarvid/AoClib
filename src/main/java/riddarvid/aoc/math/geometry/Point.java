package riddarvid.aoc.math.geometry;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveBy(Vector vector) {
        return new Point(x + vector.getX(), y + vector.getY());
    }

    public Point moveBy(int x, int y) {
        return moveBy(new Vector(x, y));
    }

    public int manhattanDistanceTo(Point other) {
        return vectorTo(other).manhattanLength();
    }

    private Vector vectorTo(Point other) {
        return new Vector(other.x - x, other.y - y);
    }

    public int manhattanDistanceTo() {
        return manhattanDistanceTo(new Point());
    }
}
