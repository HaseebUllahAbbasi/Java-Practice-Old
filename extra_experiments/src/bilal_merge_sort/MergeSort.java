package bilal_merge_sort;
public class MergeSort
{
    public static void main(String args[])
    {
        int myArr[] = {10,9,200,390,90,9};
        int l = 0;
        int u = myArr.length-1;
        mergeSort(myArr,l,u);

        for(int i =0; i<myArr.length; i++)
        {
            System.out.println(myArr[i]);
        }

    }
    public static void mergeSort(int a[], int l, int u)
    {

        int m = (l+u)/2;
        mergeSort(a,l,m);
        mergeSort(a,m+1,u);
        merge(a,l,m,u);
    }

    public static void merge(int a[],int l,int m,int u)
    {
        int i = l;
        int j = m+1;
        int k = l;
        int b[] = new int[a.length];
        while(i<=m && j <=u)
        {
            if(a[i]<=a[j])
            {
                b[k] = a[i];
                k++;
                i++;
            }
            else
            {
                b[k] = a[j];
            }	k++;
            j++;
        }
        if(i>m)
        {
            while(j<=u)
            {
                b[k] = a[j];
                k++;
                j++;
            }
        }
        else
        {
            while(i<=m)
            {
                b[k] = a[i];
                k++;
                i++;
            }
        }
    }
}