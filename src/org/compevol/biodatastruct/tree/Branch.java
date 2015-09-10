package org.compevol.biodatastruct.tree;

import org.compevol.biodatastruct.graph.Edge;

/**
 * @author Arman Bilge
 */
public interface Branch<N extends Node> extends Edge<N> {

    double getLength();

}
