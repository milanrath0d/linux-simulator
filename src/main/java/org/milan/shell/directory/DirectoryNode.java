package org.milan.shell.directory;

import java.util.LinkedList;
import java.util.List;

/**
 * Tree Node kind structure for directory
 *
 * @author Milan Rathod
 */
public class DirectoryNode<T> {

    /**
     * Value of Node
     */
    private T data;

    /**
     * Parent Node
     */
    private DirectoryNode<T> parent;

    /**
     * child nodes
     */
    private List<DirectoryNode<T>> children;

    /**
     * Index of elements
     */
    private List<DirectoryNode<T>> elementsIndex;

    public List<DirectoryNode<T>> getChildren() {
        return children;
    }

    public DirectoryNode(T data) {
        this.data = data;
        this.children = new LinkedList<>();
        this.elementsIndex = new LinkedList<>();
        this.elementsIndex.add(this);
    }

    /**
     * For parent node, add child node
     *
     * @param child child node to be added
     * @return child node
     */
    public DirectoryNode<T> addChild(T child) {
        DirectoryNode<T> directoryNode = new DirectoryNode<>(child);
        directoryNode.parent = this;
        this.children.add(directoryNode);
        this.registerChildForSearch(directoryNode);
        return directoryNode;
    }

    /**
     * Register Child for search
     *
     * @param node child node
     */
    private void registerChildForSearch(DirectoryNode<T> node) {
        elementsIndex.add(node);
        if (parent != null)
            parent.registerChildForSearch(node);
    }

    @Override
    public String toString() {
        return data != null ? data.toString() : "[data null]";
    }

    /**
     * is Root Node?
     */
    public boolean isRoot() {
        return parent == null;
    }

    /**
     * is Leaf Node?
     */
    public boolean isLeaf() {
        return children.isEmpty();
    }

    /**
     * Level of element
     */
    public int getLevel() {
        return this.isRoot() ? 0 : parent.getLevel() + 1;
    }
}