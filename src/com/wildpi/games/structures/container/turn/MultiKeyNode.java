/*
 * Licensed under the Creative Commons Attribution 4.0 International license, 2018, Alex Anderson
 */

package com.wildpi.games.structures.container.turn;

import java.util.ArrayList;
import java.util.List;

/**
 * A node for a binary tree which can store a list of data points
 *
 * @param <D> The type of object about which the node stores data
 * @param <V> The type of object/value by which the node is identified and sorted
 */
class MultiKeyNode<D, V>
{
    /**
     * Initializes the node's data and sets its value
     * @param data  The piece of data which the node will store
     * @param value The value by which the node will be identified and stored
     */
    public MultiKeyNode(D data, V value)
    {
        addData(data);
        this.value = value;
    }

    //region Key/Value

    /**
     * Adds the given data object to the node's collection of data objects
     * @param data The date to be stored
     */
    public void addData(D data)
    {
        this.data.add(data);
    }

    /**
     * Supplies a list of the data objects which have been stored at in this node
     * @return A list of data objects
     */
    public List<D> getData()
    {
        return data;
    }

    /**
     * Supplies the value by which the node should be sorted and identified
     * @return The node's value
     */
    public V getValue()
    {
        return value;
    }

    private List<D> data = new ArrayList<>();
    private V value;

    //endregion

    //region Child node getter/setter

    /**
     * Supplies the node which is to the left of this node.
     * @return The left node
     */
    public MultiKeyNode<D, V> getLeftNode()
    {
        return leftNode;
    }

    /**
     * Sets the left node of this node to the given node
     * @param leftNode This node's new left node
     */
    public void setLeftNode(MultiKeyNode<D, V> leftNode)
    {
        this.leftNode = leftNode;
    }

    /**
     * Supplies the node which is to the right of this node.
     * @return The right node
     */
    public MultiKeyNode<D, V> getRightNode()
    {
        return rightNode;
    }

    /**
     * Sets the right node of this node to the given node
     * @param rightNode This node's new right node
     */
    public void setRightNode(MultiKeyNode<D, V> rightNode)
    {
        this.rightNode = rightNode;
    }

    //endregion

    private MultiKeyNode<D, V> leftNode, rightNode;
}
