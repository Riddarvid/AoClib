package aoc.graphs;

import java.util.ArrayList;
import java.util.List;

public class Path <T> {
    private final long cost;
    private final List<T> sequence;

    public Path(Node<T> endNode) {
        cost = endNode.getLowestCost();
        sequence = new ArrayList<>();
    }

    private void buildPath(List<T> sequence, Node<T> node) {
        if (node == null) {
            return;
        }
        buildPath(sequence, node.getPrevious());
        sequence.add(node.getValue());
    }

    public long getCost() {
        return cost;
    }

    public List<T> getSequence() {
        return sequence;
    }
}
