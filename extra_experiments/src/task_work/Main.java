package task_work;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();

        list.add(8);
        list.add(10);
        list.add(12);
        find(list,19,list.size()-1);
    }
    static void find(ArrayList<Integer> list,int item, int index)
    {
        if(index<0)
        {
            System.out.println("item not found");
        }
        else if(list.get(index)==item)
        {
            System.out.println("item found on "+ index+" item :"+list.get(index));
        }
        else
        {
            find(list,item,index-1);
        }





    }
}
