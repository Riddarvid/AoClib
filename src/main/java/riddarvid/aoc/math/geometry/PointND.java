package riddarvid.aoc.math.geometry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class PointND {
    int[] coordinates;

    public PointND(int n, int... values) {
        if (n != values.length) {
            throw new InputMismatchException(n + " != " + values.length);
        }
        coordinates = new int[n];
        System.arraycopy(values, 0, coordinates, 0, n);
    }

    public PointND(PointND point, int nextCoordinate) {
        coordinates = new int[point.getDimensions() + 1];
        if (point.getDimensions() >= 0) {
            System.arraycopy(point.coordinates, 0, coordinates, 0, point.getDimensions());
        }
        coordinates[point.getDimensions()] = nextCoordinate;
    }

    public int getDimensions() {
        return coordinates.length;
    }

    public Set<PointND> getNeighbours() {
        Set<PointND> neighbours = getNeighbours(0, new PointND(0));
        neighbours.remove(this);
        return neighbours;
    }

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
