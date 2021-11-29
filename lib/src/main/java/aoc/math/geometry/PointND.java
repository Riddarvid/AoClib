package aoc.math.geometry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

/**
 * A class representing an N-dimensional point.
 */
public class PointND {
    int[] coordinates;

    /**
     * Constructs a point in n dimension.
     * @param n The number of dimensions.
     * @param values The values in the various dimensions.
     */
    public PointND(int n, int... values) {
        if (n != values.length) {
            throw new InputMismatchException(n + " != " + values.length);
        }
        coordinates = new int[n];
        System.arraycopy(values, 0, coordinates, 0, n);
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
