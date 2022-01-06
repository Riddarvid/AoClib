package aoc.graphs;

import java.util.Objects;

public class Node<T> {
    private final T value;
    private long lowestCost;
    private Node<T> previous;

    protected Node(T value) {
        this.value = value;
        lowestCost = Integer.MAX_VALUE;
        previous = null;
    }

    public T getValue() {
        return value;
    }

    public long getLowestCost() {
        return lowestCost;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void update(long newLowestCost, Node<T> newPrevious) {
        lowestCost = newLowestCost;
        previous = newPrevious;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
