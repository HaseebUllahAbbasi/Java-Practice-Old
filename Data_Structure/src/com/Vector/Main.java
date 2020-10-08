package com.Vector;

import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(1);
        vector.add(1,9);
        System.out.println(vector.toString());




        /*
        add(int index, E element)
        Inserts the specified element at the specified position in this Vector.
        if element is already there then the existing element is moved ahead and new element is pushed at that position

        add(E e)
        Appends the specified element to the end of this Vector.

        capacity()
          Returns the current capacity of this vector.
        clear()
        Removes all of the elements from this Vector.

        	firstElement() , lastElement() last at the final index
Returns the first component (the item at index 0) of this vector.
        get(int index)
Returns the element at the specified position in this Vector.
        hashCode()
Returns the hash code value for this Vector.

        	indexOf(Object o)
        Returns the index of the first occurrence of the specified element in this vector, or -1 if this vector does not contain the element.
        int	indexOf(Object o, int index)
        Returns the index of the first occurrence of the specified element in this vector, searching forwards from index, or returns -1 if the element is not found.


        	iterator()
Returns an iterator over the elements in this list in proper sequence.

        	set(int index, E element)
            Replaces the element at the specified position in this Vector with the specified element.
            void	setElementAt(E obj, int index)
            Sets the component at the specified index of this vector to be the specified object.
            void	setSize(int newSize)
            Sets the size of this vector.
            int	size()
            Returns the number of components in this vector.


         */
    }
}
/*
Vector is like the dynamic array
can grow or shrink its size

recommended to use the Vector class in the thread-safe implementation only
don't need to use the thread-safe implementation, you should use the ArrayList


Iterators returned by the Vector class are fail-fast.

 */
