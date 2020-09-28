package com.tree;

import java.util.Queue;

public class Tree
{
    private Node root;
    Tree(){ root = null; }
    void insert(int data)
    {
        Node node = new Node(data,null,null);
        if(root==null)
        {
            root = node;
        }
        else
        {
            Node current = root;
            Node previous = null;
            while (current!=null)
            {
                previous = current;
                if(current.data==data)
                {
                    System.out.println("the number already exists");
                    return;
                }
                else if(current.data > data)
                {
                    current = current.left;
                }
                else
                {
                    current = current.right;
                }

            }
            if(previous.data>data)
                previous.left = node;
            else
                previous.right = node;
        }
    }
    void display_root()
    {
        if(root!=null)
            System.out.println(root.data);
        else
            System.out.println("root is empty");
    }
    public Node getRoot()
    {
        return root;
    }
    void pre_order(Node node)
    {
        if(node!=null)
        {
            pre_order(node.left);
            pre_order(node.right);
            System.out.print(node.data+" ");
        }
    }
    void post_order(Node node)
    {
        if(node!=null)
        {
            post_order(node.left);
            post_order(node.right);
            System.out.print(node.data+" ");
        }
    }
    void in_order(Node node)
    {
        if(node!=null)
        {
            in_order(node.left);
            System.out.print(node.data+" ");
            in_order(node.right);
        }
    }
    public void search_recursive(Node node, int data)
    {
        if(node==null)
            return;
        else
        {
            if(node.data == data)
            {
                System.out.println("the data is found");
                return;
            }
            else
            {
                search_recursive(node.left,data);
                search_recursive(node.right,data);
            }
        }

    }
    void search(int data)
    {
        if(root!=null)
        {
            Node current = root;
            while (current!=null)
            {
                if(current.data==data)
                {
                    System.out.println("Found the data");
                    return;
                }
                else if(current.data>data)
                {
                    current = current.left;
                }
                else if(current.data<data)
                {
                    current = current.right;
                }
            }
            if(current==null)
            {
                System.out.println("not found the data");
            }
        }
        else
        {
            System.out.println("Tree is NULL");
        }
    }
    public void descending(Node node)
    {
        if(node!=null)
        {
            descending(node.right);
            System.out.print(" "+node.data);
            descending(node.left);
        }
    }
    public void level_order()
    {
        Node current = root;
        Queue<Node> queue = null;
        queue.add(current);
        while (!queue.isEmpty())
        {
            Node node = queue.poll();
            System.out.print(node.data+" ");
            if(node.left!=null)
            {
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                queue.add(node.right);
            }
        }
    }
}
