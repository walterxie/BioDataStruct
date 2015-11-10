package org.compevol.data.tree;

/**
 * @author Arman Bilge
 */
public interface Node<N extends Node<N, B>, B extends Branch<N>> extends org.compevol.data.graph.Node<N, B> {

    default boolean isExternal() {
        return getDegree() == 1;
    }

    default boolean isInternal() {
        return !isExternal();
    }

}
