package basic;
/*
// What is Enum
An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).
Usage :
Enums are used when we know all possible values at compile time, such as choices on a menu, rounding modes, command line flags, etc. It is not necessary that the set of constants in an enum type stay fixed for all time.

Declarations :

///////////Enum declaration can be done outside a Class or inside a Class but not inside a Method.

// A simple enum example where enum is declared
// outside any class (Note enum keyword instead of
// class keyword)
enum Color
{
    RED, GREEN, BLUE;
}

public class Test
{
    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}

//// enum declaration inside a class.
public class Test
{
    enum Color
    {
        RED, GREEN, BLUE;
    }

    // Driver method
    public static void main(String[] args)
    {
        Color c1 = Color.RED;
        System.out.println(c1);
    }
}

Important points of enum :

Every enum internally implemented by using Class.
internally above enum Color is converted to
class Color
{
     public static final Color RED = new Color();
     public static final Color BLUE = new Color();
     public static final Color GREEN = new Color();
}
Every enum constant represents an object of type enum.
enum type can be passed as an argument to switch statement.






 */
enum Day
{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}
public class Enum_exp
{
    Day day;

    // Constructor
    public Enum_exp(Day day)
    {
        this.day = day;
    }

    // Prints a line about Day using switch
    public void dayIsLike()
    {
        switch (day)
        {
            case MONDAY:
                System.out.println("Mondays are ....");
                break;
            case FRIDAY:
                System.out.println("Fridays are ....");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    // Driver method
    public static void main(String[] args)
    {
        String str = "MONDAY";
        Enum_exp t1 = new Enum_exp(Day.valueOf(str));
        t1.dayIsLike();
    }
}
