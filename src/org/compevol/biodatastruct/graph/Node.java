package org.compevol.biodatastruct.graph;

import java.util.stream.Stream;

/**
 * Represents a node in a graph or tree. In general it is
 * used only as a handle to traverse a graph or tree structure and
 * it has no methods or instance variables.
 *
 * @author Andrew Rambaut
 * @author Alexei Drummond
 * @author Arman Bilge
 */
public interface Node {

    /**
     * Get the number of edges connected to this node. (this is also the number of nodes connected to this node).
     * <p/>
     * Note: In previous implementations, this method would return a different value on the root node of trees.
     * It would previously return 1 more than the correct value in that case.
     * @return the number of edges connected to this node
     */
    default int getDegree() {
        return Long.valueOf(getAdjacencies().count()).intValue();
    }

    /**
     * Returns a list of edges connected to this node
     * @return the set of nodes that are attached by edges to the given node.
     */
    Stream<Edge> getEdges();

    /**
     * Returns a list of nodes connected to this node by an edge
     * @return the set of nodes that are attached by edges to the given node.
     */
    Stream<Node> getAdjacencies();

}
