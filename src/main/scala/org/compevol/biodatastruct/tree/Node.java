package org.compevol.biodatastruct.tree;

/**
 * @author Arman Bilge
 */
public interface Node<N extends Node<N, B>, B extends Branch<N>> extends org.compevol.biodatastruct.graph.Node<N, B> {

    default boolean isExternal() {
        return getDegree() == 1;
    }

    default boolean isInternal() {
        return !isExternal();
    }

}
