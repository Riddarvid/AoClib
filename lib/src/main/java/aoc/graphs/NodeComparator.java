package aoc.graphs;

import java.util.Comparator;

class NodeComparator <T> implements Comparator<Node<T>> {
    @Override
    public int compare(Node<T> node1, Node<T> node2) {
        return Long.compare(node1.getLowestCost(), node2.getLowestCost());
    }
}
