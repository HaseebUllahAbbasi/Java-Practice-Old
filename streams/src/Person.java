import java.util.Comparator;

public class Person implements Comparable <Person>
{
    private int  id;
    private String name;
    private int age;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Person o) {
        return this.id - o.getId();
    }
}

class NameCompare implements Comparator<Person>
{
    public int compare(Person m1, Person m2)
    {
        return m1.getName().compareTo(m2.getName());

    }
}

class ageCompare implements Comparator<Person>
{
    public int compare(Person m1, Person m2)
    {
        if (m1.getAge() < m2.getAge()) return -1;
        if (m1.getAge() > m2.getAge()) return 1;
        else return 0;
    }
}