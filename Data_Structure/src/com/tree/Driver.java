package com.tree;

public class Driver
{
    public static void main(String[] args)
    {
        Tree tree = new Tree();
        //tree.insert(5);
        tree.insert(10);
        tree.insert(-1);

        tree.insert(5);
        tree.insert(1);
        tree.insert(9);
        //.in_order(tree.getRoot());
        //tree.search_recursive(tree.getRoot(), 91);
        //tree.search(91);
        //tree.descending(tree.getRoot());
        tree.level_order();
    }
}
