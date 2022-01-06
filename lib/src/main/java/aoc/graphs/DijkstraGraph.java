package aoc.graphs;

import java.util.*;

public abstract class DijkstraGraph <T> {
    /**
     * Finds the shortest path from the start node to the end node.
     * @param startNode The start node.
     * @param endNode The end node.
     * @return A graph result containing the shortest path.
     */
    public GraphResult<T> solveStartToEnd(Node<T> startNode, Node<T> endNode) {
        PriorityQueue<Node<T>> discovered = new PriorityQueue<>(new NodeComparator<>());
        discovered.add(startNode);
        Set<Node<T>> discoveredSet = new HashSet<>();
        discoveredSet.add(startNode);
        Set<Node<T>> determined = new HashSet<>();
        while (!discovered.isEmpty()) {
            Node<T> current = discovered.poll();
            if (current.equals(endNode)) {
                Map<Node<T>, Path<T>> costMap = new HashMap<>();
                costMap.put(current, new Path<>(current));
                return new GraphResult<>(costMap);
            }
            determined.add(current);
            Set<Node<T>> neighbours = getNeighbours(current);
            for (Node<T> neighbour : neighbours) {
                if (!determined.contains(neighbour)) {
                    long currentCost = neighbour.getLowestCost();
                    long potentialCost = current.getLowestCost() + getCostBetween(current, neighbour);
                    if (potentialCost < currentCost) {
                        neighbour.update(potentialCost, current);
                    }
                    if (!discoveredSet.contains(neighbour)) {
                        discoveredSet.add(neighbour);
                        discovered.add(neighbour);
                    }
                }
            }
        }
        throw new IllegalArgumentException("No path exists between the start and end nodes.");
    }

    protected abstract long getCostBetween(Node<T> current, Node<T> neighbour);

    protected abstract Set<Node<T>> getNeighbours(Node<T> current);
}
