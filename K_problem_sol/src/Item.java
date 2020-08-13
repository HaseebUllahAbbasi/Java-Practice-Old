public class Item
{
    private  int volume;
    private  int benefit;

    @Override
    public String toString() {
        return "Item{" +
                "volume=" + volume +
                ", benefit=" + benefit +
                '}';
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getBenefit() {
        return benefit;
    }

    public void setBenefit(int benefit)
    {
        this.benefit = benefit;
    }

    public Item(int volumne, int benefit)
    {
        this.volume = volumne;
        this.benefit = benefit;
    }
}
