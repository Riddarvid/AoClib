package aoc.math.geometry;

/**
 * Class representing a vector in 2D.
 */
public class Vector {
    private final int x;
    private final int y;

    public static VectorND getNullVector(int nDimensions) {
        return new VectorND(new int[nDimensions]);
    }

    /**
     * Constructs a vector from the given coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs the null vector.
     */
    public Vector() {
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
     * Calculates the manhattan length of the vector.
     * @return The manhattan length of the vector.
     */
    public int manhattanLength() {
        return Math.abs(x) + Math.abs(y);
    }

    /**
     * Scales the vector by a factor of value.
     * @param value The factor to scale by.
     * @return A scaled vector.
     */
    public Vector scaleBy(int value) {
        return new Vector(x * value, y * value);
    }

    /**
     * Rotates the vector 90 degrees to the left.
     * @return The rotated vector.
     */
    public Vector rotateLeft() {
        int newY = x;
        int newX = -y;
        return new Vector(newX, newY);
    }

    /**
     * Adds a vector to this vector.
     * @param other The vector to add.
     * @return The vector equal to the sum of this vector and the other vector.
     */
    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    /**
     * Adds a vector represented by x and y to this vector.
     * @param x The x to add.
     * @param y The y to add.
     * @return The vector equal to the sum of this vector and the other vector.
     */
    public Vector add(int x, int y) {
        return add(new Vector(x, y));
    }
}
