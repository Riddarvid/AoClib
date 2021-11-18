package riddarvid.aoc.math.geometry;

import java.util.Objects;

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

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
