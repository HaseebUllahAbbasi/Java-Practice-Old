public class hacker_rank
{
    static String timeConversion(String s)
    {
        if(s.charAt(8)=='P')
        {
            int hrs = Integer.parseInt(s.substring(0,2))+12;
            int min = Integer.parseInt(s.substring(3,5));
            int sec = Integer.parseInt(s.substring(6,8));
            return hrs+":"+min+":"+sec;
        }
        else if(s.charAt(8)=='A')
        {
            int hrs = Integer.parseInt(s.substring(0,2));
            int min = Integer.parseInt(s.substring(3,5));
            int sec = Integer.parseInt(s.substring(6,8));
            return hrs+":"+min+":"+sec;
        }
        else return "";
    }

    public static void main(String[] args)
    {
        hacker_rank.timeConversion("07:05:45PM");

    }
}
