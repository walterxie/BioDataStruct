package org.compevol.data.tree;

/**
 * @author Arman Bilge
 */
public interface RootedBranch<N extends RootedNode> extends Branch<N> {

    @Override
    default double getLength() {
        final RootedNode[] nodes = getNodes();
        return Math.abs(nodes[0].getHeight() - nodes[1].getHeight());
    }

}
