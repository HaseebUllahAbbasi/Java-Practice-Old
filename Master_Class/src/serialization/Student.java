package serialization;
/*
1. Serialization is a mechanism to convert an object into stream of bytes
 -- that it can be written into a file,
  -- transported through a network or
   -- stored into database
 2.  De-serialization is just a vice versa

 3. serialization is converting an object to stream of bytes
  4. and de-serialization is rebuilding the object from stream of bytes

    5. Java Serialiation API provides the features to perform seralization & de-serialization
    6. must implement java.io.Serializable interface
 */

import java.io.Serializable;

public class Student implements Serializable
{
    private int stuRollNum;
    private int stuAge;
    private String stuName;
    private  String stuAddress;
    private  double stuHeight;

    public Student(int roll, int age, String name,
                   String address, double height) {
        this.stuRollNum = roll;
        this.stuAge = age;
        this.stuName = name;
        this.stuAddress = address;
        this.stuHeight = height;
    }

    public int getStuRollNum() {
        return stuRollNum;
    }
    public void setStuRollNum(int stuRollNum) {
        this.stuRollNum = stuRollNum;
    }
    public int getStuAge() {
        return stuAge;
    }
    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }
    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
    public String getStuAddress() {
        return stuAddress;
    }
    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }
    public double getStuHeight() {
        return stuHeight;
    }
    public void setStuHeight(double stuHeight) {
        this.stuHeight = stuHeight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuRollNum=" + stuRollNum +
                ", stuAge=" + stuAge +
                ", stuName='" + stuName + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", stuHeight=" + stuHeight +
                '}';
    }
}

