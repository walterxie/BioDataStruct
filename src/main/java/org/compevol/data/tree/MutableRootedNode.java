package org.compevol.data.tree;

/**
 * @author Arman Bilge
 */
public interface MutableRootedNode<N extends MutableRootedNode<N, B>, B extends RootedBranch<N>> extends RootedNode<N, B> {

    void setHeight(double height);

    void setParent(N node);

    void removeChild(N node);

    void addChild(N node);

}
