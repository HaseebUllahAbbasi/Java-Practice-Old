import java.util.ArrayList;
import java.util.Arrays;
public class FlexibleArray<E>
{

    private final int INITIAL_CAPACITY = 12;
    private int size;
    private int capacity = INITIAL_CAPACITY;

    private Object[] array;
    public FlexibleArray()
    {
        array = new Object[INITIAL_CAPACITY];
    }

    public FlexibleArray(int capacity)
    {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Illegal initial capacity : " + capacity);
        }
        this.capacity = capacity;
        array = new Object[capacity];
    }


    public void insert(E element) {
        sizeCheck();
        array[size++] = element;
    }

    public void insert(E element, int index)
    {
        if (index == size) {
            insert(element);
        }
        else
        {
            rangeCheck(index);
            sizeCheck();
            System.arraycopy(array, index, array, index + 1, size - index);
            array[index] = element;
            size++;
        }
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

    public boolean delete(Object o) {
        int found = this.indexOf(o);
        if (found < 0) return false;
        this.delete(found);
        return true;
    }

    public int indexOf(Object obj) {
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
        array = Arrays.copyOf(array, capacity);
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
    public boolean search(Object obj)
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

        if(size>0)
        {
            int temp_array[] = new int[size];
            for (int i=0; i<size; i++)
            {
                temp_array[i] = (int)(array[i]);
            }
            Arrays.sort(temp_array);
            for (int i=0; i<size; i++)
            {
                 (array[i]) = temp_array[i];
            }
        }
    }

    public static void main(String[] args)
    {
        FlexibleArray<Integer> obj = new FlexibleArray<>();

        obj.insert(1000);
        obj.insert(23);
        obj.insert(144);
        obj.update(100, 2);

        obj.sort();
        obj.print();
        String[] test = { "Bakhtiar", "", "ptr", "int", "String", "Stark", "Shaikh", "Tony", "fine", "ok"};


        FlexibleArray<String> obj2 = new FlexibleArray<>();
        for ( String item: test)
        {
            obj2.insert(item);
        }
        obj2.search("string");
        obj2.print();

    }
}