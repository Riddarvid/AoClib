package aoc.math.geometry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A class representing an N-dimensional point.
 */
public class PointND {
    private final int[] coordinates;

    public static PointND getOrigo(int nDimensions) {
        return new PointND(new int[nDimensions]);
    }

    /**
     * Constructs a point in n dimension.
     * @param values The values in the various dimensions.
     */
    public PointND(int... values) {
        coordinates = values.clone();
    }

    /**
     * Constructs a point in n + 1 dimensions given a point in n dimensions.
     * @param point The point in n dimensions.
     * @param nextCoordinate The coordinate to be added in the n + 1'th dimension.
     */
    public PointND(PointND point, int nextCoordinate) {
        coordinates = new int[point.getDimensions() + 1];
        if (point.getDimensions() >= 0) {
            System.arraycopy(point.coordinates, 0, coordinates, 0, point.getDimensions());
        }
        coordinates[point.getDimensions()] = nextCoordinate;
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
     * Method for finding the coordinates of all points adjacent to this one.
     * @return The set of points adjacent to this point.
     */
    public Set<PointND> getNeighbours() {
        Set<PointND> neighbours = getNeighbours(0, new PointND(0));
        neighbours.remove(this);
        return neighbours;
    }

    /**
     * Recursive method for finding the coordinates of all points adjacent to this one.
     * @param i The number of dimensions having been considered so far.
     * @param soFar A point in a lower or equal dimension which is to be built upon.
     * @return The set of points adjacent to this point.
     */
    private Set<PointND> getNeighbours(int i, PointND soFar) {
        Set<PointND> neighbours = new HashSet<>();
        if (i == coordinates.length) {
            neighbours.add(soFar);
            return neighbours;
        }
        for (int d = -1; d <= 1; d++) {
            PointND newSoFar = new PointND(soFar, coordinates[i] + d);
            neighbours.addAll(getNeighbours(i + 1, newSoFar));
        }
        return neighbours;
    }

    /**
     * Translates this point by the given vector.
     * @param vector The vector to translate by.
     * @return A new point created at the specified location.
     */
    public PointND moveBy(VectorND vector) {
        int[] newCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = coordinates[i] + vector.getCoordinate(i);
        }
        return new PointND(newCoordinates);
    }

    /**
     * Translates this point by the x and y values.
     * @param values The values to translate by
     * @return A new point created at the specified location.
     */
    public PointND moveBy(int... values) {
        return moveBy(new VectorND(values));
    }

    /**
     * Calculates the vector between this point and the given point.
     * @param other The other point.
     * @return The vector between this point and the given point.
     */
    public VectorND vectorTo(PointND other) {
        int[] newCoordinates = new int[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            newCoordinates[i] = other.getCoordinate(i) - getCoordinate(i);
        }
        return new VectorND(newCoordinates);
    }

    /**
     * Calculates the manhattan distance between this point and origo.
     * @return The manhattan distance between this point and origo.
     */
    public int manhattanDistanceTo() {
        return manhattanDistanceTo(getOrigo(getDimensions()));
    }

    /**
     * Calculates the manhattan distance between this point and the given point.
     * @param other The other point.
     * @return The manhattan distance between this point and the given point.
     */
    public int manhattanDistanceTo(PointND other) {
        return vectorTo(other).manhattanLength();
    }

    @Override
    public String toString() {
        if (coordinates.length == 0) {
            return "Empty point";
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
        PointND pointND = (PointND) o;
        return Arrays.equals(coordinates, pointND.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }
}
