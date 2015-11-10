/*
 * RootedTree.java
 *
 * (c) 2005 JEBL Development Team
 *
 * This package is distributed under the
 * Lesser Gnu Public Licence (LGPL)
 */
package org.compevol.biodatastruct.tree;

/**
 * A tree with a root (node with maximum height). This interface
 * provides the concept of a direction of time that flows from the
 * root to the tips. Each node in the tree has a node height that is
 * less than its parent's height and greater than it children's heights.
 *
 * @author rambaut
 * @author Alexei Drummond
 * @author Arman Bilge
 */
public interface RootedTree<N extends RootedNode<N, B>, B extends RootedBranch<N>> extends Tree<N, B> {

    /**
     * @return Whether this tree has node heights available
     */
    boolean hasHeights();

    /**
     * @return Whether this tree has branch lengths available
     */
    boolean hasLengths();

    /**
     * The root of the tree has the largest node height of
     * all nodes in the tree.
     * @return the root of the tree.
     */
    N getRoot();

    default boolean isBinary() {
        return getNodes().mapToInt(N::getChildCount).allMatch(Integer.valueOf(2)::equals);
    }

    default String newick() {
        return getRoot().newick() + ";";
    }

}