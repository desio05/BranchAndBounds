package ru.desiolab.bnb.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
        nodes.add(new Node(1));
    }

    public Node getNode(int nodeIndex) {
        Optional<Node> result = nodes.stream().filter(node -> node.getIndex() == nodeIndex).findFirst();
        return result.orElseGet(() -> {
            Node node = new Node(nodeIndex);
            nodes.add(node);
            return node;
        });
    }

    public void createEdge(int firstNodeIndex, int secondNodeIndex) {
        Node firstNode = getNode(firstNodeIndex);
        Node secondNode = getNode(secondNodeIndex);
        firstNode.addNeighbour(secondNode);
        secondNode.addNeighbour(firstNode);
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
