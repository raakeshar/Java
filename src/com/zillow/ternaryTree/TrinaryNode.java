package com.zillow.ternaryTree;

/**
 * Created by rakesh .
 */
public class TrinaryNode {

        int key;
        TrinaryNode left;
        TrinaryNode middle;
        TrinaryNode right;

        public TrinaryNode(int key) {
            this.key = key;
            this.left = this.middle = this.right = null;
        }

}

