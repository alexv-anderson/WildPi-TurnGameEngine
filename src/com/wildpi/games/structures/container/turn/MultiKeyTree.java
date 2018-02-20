/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * A binary tree whose nodes can store multiple pieces of data.
 *
 * If two pieces of data are inserted with the same value, then they will placed in the same node in the tree.
 *
 * @param <D> The type of object about which the node stores data
 * @param <V> The type of object/value by which the node is identified and sorted
 */
class MultiKeyTree<D, V extends Comparable<V>>
{
    /**
     * Traverses the tree in order and applies the given function to each node in the tree
     *
     * @param consumer A function which processes the data and value stored in each node
     */
    public void traverseInOrder(BiConsumer<List<D>, V> consumer)
    {
        traverseInOrder(node -> consumer.accept(node.getData(), node.getValue()), root);
    }

    /**
     * Helper method which recursively traverses the tree in order and applies the given function to each node
     * @param consumer A function which processes the data nd value stored in each node
     * @param node     The node of the tree from which traversal should begin
     */
    private void traverseInOrder(Consumer<MultiKeyNode<D, V>> consumer, MultiKeyNode<D, V> node)
    {
        if(node.getLeftNode() == null && node.getRightNode() == null)
            consumer.accept(node);
        else
        {
            if(node.getLeftNode() != null)
                traverseInOrder(consumer, node.getLeftNode());
            consumer.accept(node);
            if(node.getRightNode() != null)
                traverseInOrder(consumer, node.getRightNode());
        }
    }

    /**
     * Inserts the given piece of data into the tree using the given value to determine where in the tree the data should be placed
     *
     * @param data  The piece of data to insert
     * @param value The value which indicates where in the tree the value should be inserted
     */
    public void insert(D data, V value)
    {
        if(root ==  null)
            root = new MultiKeyNode<>(data, value);
        else
            insert(data, value, root);
    }

    /**
     * Helper method which recursively searches the tree to determine where the given piece of data should be inserted using the given value.
     *
     * @param data   The piece of data to insert
     * @param value  The value which indicates where in the tree the data should be inserted
     * @param parent The node of the tree from which the search should start
     */
    private void insert(D data, V value, MultiKeyNode<D, V> parent)
    {
        int result = parent.getValue().compareTo(value);

        if(result > 0)
        {
            if(parent.getLeftNode() == null)
                parent.setLeftNode(new MultiKeyNode<>(data, value));
            else
                insert(data, value, parent.getLeftNode());
        }
        else if(result < 0)
        {
            if(parent.getRightNode() == null)
                parent.setRightNode(new MultiKeyNode<>(data, value));
            else
                insert(data, value, parent.getRightNode());
        }
        else
        {
            parent.addData(data);
        }

    }

    private MultiKeyNode<D, V> root;
}
