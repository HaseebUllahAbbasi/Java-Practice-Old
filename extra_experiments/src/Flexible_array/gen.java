import java.lang.reflect.Array;
import java.util.Arrays;

public class gen <E>
{
    E array[];
    private final int initial_capacity = 10;
    private int capacity;
    private  int size;
    gen()
    {
         array = (E[]) new Object[initial_capacity];
        size =0;
    }
    public gen(int capacity)
    {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal initial capacity : " + capacity);
        }
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
        size =0;
    }

    public void insert(E element) {
        sizeCheck();
        array[size++] = element;
    }
    public int size()
    {
        return size;
    }
    public boolean isEmpty() { return size == 0; }

    public E get(int index)
    {
        rangeCheck(index);
        return (E) array[index];
    }

    public E update(E element, int index)
    {
        rangeCheck(index);
        E value = get(index);
        array[index] = element;
        return value;
    }

    public E delete(int index)
    {
        rangeCheck(index);
        E value = (E) array[index];
        int numberToMove = size - index - 1;
        if (numberToMove > 0) {
            System.arraycopy(array, index + 1, array, index, numberToMove);
        }
        array[--size] = null;
        return value;
    }

    public boolean delete(E o) {
        int found = this.indexOf(o);
        if (found < 0) return false;
        this.delete(found);
        return true;
    }

    public int indexOf(E obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(array[i])) return i;
            }
        }
        return -1;
    }

    private void sizeCheck()
    {
        if (size + 1 >= capacity) {
            grow();
        }
    }
    private void grow()
    {
        capacity += (capacity * 3)/2;

    }
    private void rangeCheck(int index)
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index : " + index);
        }
    }
    public void print()
    {
        for (int i=0; i<size; i++)
        {
            System.out.print(array[i]+" ");
        }
    }
    public boolean search(E obj)
    {
        for (int i=0; i<size; i++)
        {
            if(array[i].equals(obj))
            {
                System.out.println("Element found");
                return true;
            }
        }
        System.out.println("Element Not Found");
        return false;
    }
    public void sort()
    {
        E[] arr = (E[])new Object[size];

    }

    public static void main(String[] args) {
        gen<Integer> array = new gen<>();
        array.insert(122);
        array.insert(11);
        array.insert(33);
        array.insert(0);
        array.sort();
        array.print();

    }
}
