package aoc.graphs;

import java.util.Map;

public class GraphResult <T> {
    private final Map<Node<T>, Path<T>> costMap;

    public GraphResult(Map<Node<T>, Path<T>> costMap) {
        this.costMap = costMap;
    }
}
