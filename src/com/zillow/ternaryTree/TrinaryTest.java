package com.zillow.ternaryTree;
import java.util.logging.Logger;

/**
 * Created by rakesh .
 */
public class TrinaryTest {

    public static void main(String[] args)
    {
        TrinaryTree tree = new TrinaryTree();
        TrinaryNode root = new TrinaryNode(5);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        boolean result = tree.delete(5);
        System.out.print(result);

    }

}
