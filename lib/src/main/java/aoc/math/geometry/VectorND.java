package aoc.math.geometry;

import java.util.Arrays;

public class VectorND {
    private final int[] coordinates;

    public static VectorND getNullVector(int nDimensions) {
        return new VectorND(new int[nDimensions]);
    }

    /**
     * Constructs a point in n dimension.
     * @param values The values in the various dimensions.
     */
    public VectorND(int... values) {
        coordinates = new int[values.length];
        System.arraycopy(values, 0, coordinates, 0, values.length);
    }

    /**
     * Constructs a vector in n + 1 dimensions given a vector in n dimensions.
     * @param vector The vector in n dimensions.
     * @param nextCoordinate The coordinate to be added in the n + 1'th dimension.
     */
    public VectorND(VectorND vector, int nextCoordinate) {
        coordinates = new int[vector.getDimensions() + 1];
        if (vector.getDimensions() >= 0) {
            System.arraycopy(vector.coordinates, 0, coordinates, 0, vector.getDimensions());
        }
        coordinates[vector.getDimensions()] = nextCoordinate;
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

    @Override
    public String toString() {
        if (coordinates.length == 0) {
            return "Empty vector";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(coordinates[0]);
        for (int index = 1; index < coordinates.length; index++) {
            sb.append(',').append(coordinates[index]);
        }
        sb.append(')');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorND vectorND = (VectorND) o;
        return Arrays.equals(coordinates, vectorND.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }
}
