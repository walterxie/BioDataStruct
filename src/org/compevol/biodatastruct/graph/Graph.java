package org.compevol.biodatastruct.graph;

import java.util.stream.Stream;

/**
 * @author Andrew Rambaut
 * @author Alexei Drummond
 * @author Arman Bilge
 */
public interface Graph<N extends Node<N, E>, E extends Edge<N>> {

    /**
     * Returns the Edge that connects these two nodes
     * @param node1
     * @param node2
     * @return the edge object.
     * @throws NoEdgeException if the nodes are not directly connected by an edge.
     */
    E getEdge(N node1, N node2) throws NoEdgeException;

    /**
     * Returns the length of the edge that connects these two nodes
     * @param node1
     * @param node2
     * @return the edge length.
     * @throws NoEdgeException if the nodes are not directly connected by an edge.
     */
    default double getEdgeLength(N node1, N node2) throws NoEdgeException {
        return getEdge(node1, node2).getLength();
    }

    /**
     * @return the set of all nodes in this graph.
     */
    Stream<N> getNodes();

    /**
     * @return the set of all edges in this graph.
     */
    Stream<E> getEdges();

    /**
     * @param degree the number of edges connected to a node
     * @return a set containing all nodes in this graph of the given degree.
     */
    default Stream<N> getNodes(int degree) {
        return getNodes().filter(node -> node.getDegree() == degree);
    }

    /**
     * @return true if the given graph is acyclic.
     */
    default boolean isAcyclical() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @return true if the given graph is fully connected.
     */
    default boolean isConnected() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * @return true if the given graph is a tree, i.e. is acyclic
     * and fully connected.
     */
    default boolean isTree() {
        return isAcyclical() && isConnected();
    }

    /**
     * This class is thrown by getEdgeLength(node1, node2) if node1 and node2
     * are not directly connected by an edge.
     */
    class NoEdgeException extends Exception {}

}
