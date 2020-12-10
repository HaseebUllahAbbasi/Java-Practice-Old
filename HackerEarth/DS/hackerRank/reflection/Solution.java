package hackerRank.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args)
    {

        Class student = Student.class.getClass();
        Method[] methods = Student.class.getMethods();
        ArrayList<String> methodList = new ArrayList<>();
        for(String method: methodList)
        {
       //methodList.add();
    }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}
class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }

}