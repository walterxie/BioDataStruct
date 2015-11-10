package org.compevol.data.tree;

import org.compevol.data.graph.Edge;

/**
 * @author Arman Bilge
 */
public interface Branch<N extends Node> extends Edge<N> {

    double getLength();

}
