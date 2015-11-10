package org.compevol.biodatastruct.tree;

import org.compevol.biodatastruct.graph.Graph;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * A rooted or unrooted tree. This interface is the common base class for all trees,
 * and contains only operations for unrooted trees. The subinterface RootedTree
 * contains additional methods that make sense only on rooted trees.
 *
 * Both interfaces contain no mutator methods. As of 2006-12-08, the only way
 * to mutate a tree after it has been built is to use its concrete class
 * instead of the Tree or RootedTree interface.
 *
 * @author rambaut
 * @author Alexei Drummond
 * @author Arman Bilge
 */
public interface Tree<N extends Node<N, B>, B extends Branch<N>> extends Graph<N, B> {

    /**
     * @return a set of all nodes that have degree 1.
     * These nodes are often refered to as 'tips'.
     */
    default Stream<N> getExternalNodes() {
        return getNodes().filter(node -> node.getDegree() == 1);
    }

    /**
     * @return a set of all nodes that have degree 2 or more.
     * These nodes are often refered to as internal nodes.
     */
    default Stream<N> getInternalNodes() {
        return getNodes().filter(node -> node.getDegree() >= 2);
    }

	/**
	 * @return a set of all edges that have a degree 1 node.
	 */
	default Stream<B> getExternalEdges() {
        return getEdges().filter(e -> Arrays.stream(e.getNodes()).anyMatch(N::isExternal));
    }

	/**
	 * @return a set of all edges for which both nodes have degree 2 or more.
	 */
    default Stream<B> getInternalEdges() {
        return getEdges().filter(e -> Arrays.stream(e.getNodes()).anyMatch(N::isInternal));
    }

}