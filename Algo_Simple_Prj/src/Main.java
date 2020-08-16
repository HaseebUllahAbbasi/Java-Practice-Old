import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        //  karima Ali//
        //int array[] = {10,0,17,8,12,0,0,11,8};       //
        // laila Khalid   //
        int array[] =  {11,0,8,11,0,10,7,0,11,8,3};
        bubbleSort();
        selectionSort();
        insertionSort();
        mergesort(array);
        selectionSort();
        quickSort(array,0,array.length-1);

    }
    public static void quickSort(int[] arr, int start, int end){

        //calling again partition method that start
        int partition = partition(arr, start, end);

        if(partition-1>start)
        {
            //calling Quick sort again as recursive
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            //calling Quick sort again as recursive
            quickSort(arr, partition + 1, end);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        //assigning the pivot value

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
                // moving the element
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        return start;
    }
    public void shellSort()
    {
        System.out.println("The Shell sort is : ");

        int array[] =  {11,0,8,11,0,10,7,0,11,8,3};
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key)
                {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = key;
            }
            System.out.println(Arrays.toString(array));
        }
        System.out.println("The Sorted Array is :");
        for (int number:array)
        {
            System.out.print(number+" ");
        }
        System.out.println();


    }
    static void bubbleSort()
    {

        System.out.println("The Bubble sort is ");

        int array[] =  {11,0,8,11,0,10,7,0,11,8,3};
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++) // Looping through the array length
        {  System.out.println("Sort Pass Number "+(i+1));
            for(int j=1; j < (n-i); j++)
            {
                System.out.println("Comparing "+ array[j-1]+ " and " + array[j]);
                if(array[j-1] > array[j])
                {

                    //swap elements
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                    System.out.println(array[j]  + " is greater than " + array[j-1]);
                    System.out.println("Swapping Elements: New Array After Swap");
                    System.out.println(Arrays.toString(array));
                }
            }
        }
        System.out.println("The Sorted Array is :");
        for (int number:array)
        {
            System.out.print(number+" ");
        }
        System.out.println();
    }
    public static void selectionSort()
    {

        System.out.println("Selection Sort");
        int arr[] =  {11,0,8,11,0,10,7,0,11,8,3};

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            System.out.println(Arrays.toString(arr));
            //replacing with the index
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        System.out.println("The Sorted Array is :");
        for (int number:arr)
        {
            System.out.print(number+" ");
        }
        System.out.println();
    }
    public static void insertionSort()
    {
        System.out.println("Selection sort ");
        int array[] =  {11,0,8,11,0,10,7,0,11,8,3};
        for (int j = 1; j < array.length; j++)
        {
            int current = array[j];
            int i = j-1;
            while ((i > -1) && (array[i] > current)) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = current;
            System.out.println(Arrays.toString(array));
        }
        System.out.println("The Sorted Array is :");
        for (int number:array)
        {
            System.out.print(number+" ");
        }
        System.out.println();
    }
    static void mergesort(int arr[])
    {
        int n = arr.length;
        if (n < 2)
            return;
        int mid = n / 2;
        int left[] = new int[mid];
        int right[] = new int[n - mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];
        for (int i = mid; i < n; i++)
            right[i - mid] = arr[i];
        mergesort(left);
        mergesort(right);
        merge(arr, left, right);

    }

    public static void merge(int arr[], int left[], int right[])
    {
        int nL = left.length;
        int nR = right.length;
        int i = 0, j = 0, k = 0;
        while (i < nL && j < nR) {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
                {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < nL)
        {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < nR)
        {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}

