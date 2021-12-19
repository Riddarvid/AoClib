package aoc.math.geometry;

public class VectorND {
    private final int[] coordinates;

    /**
     * Constructs a point in n dimension.
     * @param values The values in the various dimensions.
     */
    public VectorND(int... values) {
        coordinates = new int[values.length];
        System.arraycopy(values, 0, coordinates, 0, values.length);
    }

    /**
     * Getter for the number of dimensions.
     * @return The number of dimensions.
     */
    public int getDimensions() {
        return coordinates.length;
    }

    /**
     * Gets the specified coordinate
     * @param index The index of the coordinate.
     * @return The coordinate at the specified index.
     */
    public int getCoordinate(int index) {
        return coordinates[index];
    }

    /**
     * Gets the coordinates as an array.
     * @return The coordinates.
     */
    public int[] getCoordinates() {
        return coordinates.clone();
    }

    /**
     * Calculates the manhattan length of the vector.
     * @return The manhattan length of the vector.
     */
    public int manhattanLength() {
        int length = 0;
        for (int value : coordinates) {
            length += Math.abs(value);
        }
        return length;
    }

    /**
     * Scales the vector by a factor of value.
     * @param value The factor to scale by.
     * @return A scaled vector.
     */
    public VectorND scaleBy(int value) {
        int[] newCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = value * getCoordinate(i);
        }
        return new VectorND(newCoordinates);
    }

    /**
     * Adds a vector to this vector.
     * @param other The vector to add.
     * @return The vector equal to the sum of this vector and the other vector.
     */
    public VectorND add(VectorND other) {
        int[] newCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = getCoordinate(i) + other.getCoordinate(i);
        }
        return new VectorND(newCoordinates);
    }

    /**
     * Adds a vector represented by x and y to this vector.
     * @param values The coordinates to add.
     * @return The vector equal to the sum of this vector and the other vector.
     */
    public VectorND add(int... values) {
        return add(new VectorND(values));
    }
}
