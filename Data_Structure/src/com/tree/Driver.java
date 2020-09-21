package com.tree;

public class Driver
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(5);
        tree.insert(1);
        tree.insert(9);
        tree.in_order(tree.getRoot());




    }
}
