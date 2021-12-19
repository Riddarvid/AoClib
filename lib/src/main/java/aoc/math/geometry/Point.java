package aoc.math.geometry;

import java.util.Objects;

/**
 * A point in 2D.
 */
public class Point {
    private final int x;
    private final int y;

    /**
     * Constructs a point given x and y coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a point at origo.
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Getter for x.
     * @return The value of x.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for y.
     * @return The value of y.
     */
    public int getY() {
        return y;
    }

    /**
     * Translates this point by the given vector.
     * @param vector The vector to translate by.
     * @return A new point created at the specified location.
     */
    public Point moveBy(Vector vector) {
        return new Point(x + vector.getX(), y + vector.getY());
    }

    /**
     * Translates this point by the x and y values.
     * @param x The translation of x.
     * @param y The translation of y.
     * @return A new point created at the specified location.
     */
    public Point moveBy(int x, int y) {
        return moveBy(new Vector(x, y));
    }

    /**
     * Calculates the vector between this point and the given point.
     * @param other The other point.
     * @return The vector between this point and the given point.
     */
    public Vector vectorTo(Point other) {
        return new Vector(other.x - x, other.y - y);
    }

    /**
     * Calculates the manhattan distance between this point and origo.
     * @return The manhattan distance between this point and origo.
     */
    public int manhattanDistanceTo() {
        return manhattanDistanceTo(new Point());
    }

    /**
     * Calculates the manhattan distance between this point and the given point.
     * @param other The other point.
     * @return The manhattan distance between this point and the given point.
     */
    public int manhattanDistanceTo(Point other) {
        return vectorTo(other).manhattanLength();
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
