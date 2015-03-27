package com.zillow.ternaryTree;

/**
 * Created by rakesh
 */
public class TrinaryTree {

    TrinaryNode root;

    public TrinaryTree()
    {
        root = null;
    }

    public void insert(int key)
    {
        root = Insert(root,key);
    }

    public TrinaryNode Insert(TrinaryNode root,int key)
    {
        if(root == null)
            root = new TrinaryNode(key);

        else if(key < root.key)
            root.left = Insert(root.left,key);
        else if(key == root.key)
            root.middle = Insert(root.middle,key);
        else
            root.right = Insert(root.right,key);

        return root;
    }

    public Boolean delete(int key) {
        if (root == null) return false;

        TrinaryNode current = root;
        TrinaryNode Parent = null;

        while (current != null)         //Move to the node to be deleted
        {
            if (key > current.key)
            {
                Parent = current;
                current = current.right;
            }
            else if (key < current.key)
            {
                Parent = current;
                current = current.left;
            }
            else break;
        }

        if (current == null) return false;

        //Check if the val to be deleted occurs more
        //than once , then delete the bottom most occurence of it
        if (current.middle != null)
        {                                       //and return
            while (current.middle != null)
            {
                Parent = current;
                current = current.middle;
            }
            Parent.middle = null;
            return true;
        }

        // If the node to be deleted is the leaf node.
        if (current.left == null && current.right == null)
        {
            if (current == root)
            {
                root = null;
            }
            else if (Parent.left == current) Parent.left = null;
            else Parent.right = null;
            return true;
        }

        //If the node to be deleted has only one child
        if (current.left == null)
        {
            if (current == root)
            {
                root = current.right;
            }
            else if (Parent.left == current) Parent.left = current.right;
            else Parent.right = current.right;
        }
        else if (current.right == null)
        {
            if (current == root)
            {
                root = current.left;
            }
            else if (Parent.left == current) Parent.left = current.left;
            else Parent.right = current.left;
        }
        else  // If it has both left and right children.
        {
            TrinaryNode ParentofSuccessor = null;
            TrinaryNode Successor = null;

            TrinaryNode Node = current.right;
            while (Node.left != null)
            {
                ParentofSuccessor = Node;
                Node = Node.left;
            }

            Successor = Node;
            if (ParentofSuccessor == null)
            {
                current.key = Successor.key;
                current.right = Successor.right;
            }
            else
            {
                current.key = Successor.key;
                ParentofSuccessor.left = Successor.right;
            }
        }
        return true;
    }


}
