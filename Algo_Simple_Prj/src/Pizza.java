public class Pizza
{
    private String size;
    private int cheese_toppings;
    private int beef_toppings;
    private int chicken_toppings;
    Pizza(String size,int cheese_toppings,int beef_toppings,int chicken_toppings)
    {
        this.size = size;
        this.cheese_toppings = cheese_toppings;
        this.beef_toppings = beef_toppings;
        this.chicken_toppings = chicken_toppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCheese_toppings() {
        return cheese_toppings;
    }

    public void setCheese_toppings(int cheese_toppings) {
        this.cheese_toppings = cheese_toppings;
    }

    public int getBeef_toppings() {
        return beef_toppings;
    }

    public void setBeef_toppings(int beef_toppings) {
        this.beef_toppings = beef_toppings;
    }

    public int getChicken_toppings() {
        return chicken_toppings;
    }

    public void setChicken_toppings(int chicken_toppings) {
        this.chicken_toppings = chicken_toppings;
    }
    public String getDescription()
    {
        return "You have ordered: 1 "+size+" Pizza with"+chicken_toppings+" chicken_toppings , "+beef_toppings+", beef_toppings: "+chicken_toppings+" cheese_toppings : "
                +" and Pizza Cost "+calcCost();
    }
    public int calcCost()
    {
        int total_amount = 0;
        if(size.equals("small")){
                total_amount+=10;
                int  total_toppings = beef_toppings+cheese_toppings+chicken_toppings;
                total_amount = total_amount + total_toppings*2;
        }
        else if(size.equals("medium")){
            total_amount+=12;
            int  total_toppings = beef_toppings+cheese_toppings+chicken_toppings;
            total_amount = total_amount + total_toppings*2;
        }
        else if(size.equals("large")){
            total_amount+=14;
            int  total_toppings = beef_toppings+cheese_toppings+chicken_toppings;
            total_amount = total_amount + total_toppings*2;
        }
        return total_amount;
    }
}
