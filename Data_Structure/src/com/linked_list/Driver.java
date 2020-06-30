package com.linked_list;

public class Driver
{
    public static void main(String[] args) {
        List list = new List();
        list.insert_at_head(1);
        list.insert_at_head(2);
        list.insert_at_tail(5);
        list.print();
    }
}
