package concurrency.pro_con_col_exp;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public String  EOF = "EOF";
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        My_Producer producer = new My_Producer(list,Thread_Color.ANSI_BLUE);
        My_Consumer consumer_1 = new My_Consumer(list,Thread_Color.ANSI_PURPLE);
        My_Consumer consumer_2 = new My_Consumer(list,Thread_Color.ANSI_RED);
        new Thread(producer).start();
        new Thread(consumer_1).start();
        new Thread(consumer_2).start();
    }
}
