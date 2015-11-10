package org.compevol.data.tree;

import java.util.stream.Stream;

/**
 * @author Arman Bilge
 */
public interface RootedNode<N extends RootedNode<N, B>, B extends RootedBranch<N>> extends Node<N, B> {

    N getParent();

    Stream<N> getChildren();

    default int getChildCount() {
        return Long.valueOf(getChildren().count()).intValue();
    }

    B getBranch();

    double getHeight();

    boolean isRoot();

    default int getTipCount() {
        if (isExternal())
            return 1;
        else
            return getChildren().mapToInt(N::getTipCount).sum();
    }

    String newick();

}
