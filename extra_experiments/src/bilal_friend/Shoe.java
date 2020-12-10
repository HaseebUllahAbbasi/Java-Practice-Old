package bilal_friend;

public class Shoe
{

    int id;
    String category;
    String brand;
    float size;
    float cost;
    float price;
    //cost<price;
    String heel;
    String leather;

    public Shoe(int id, String category, String brand, float size, float cost, float price, String heel, String leather) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.size = size;
        this.cost = cost;
        this.price = price;
        this.heel = heel;
        this.leather = leather;
    }

    public Shoe() {

    }

    public void addProduct()
    {

    }
    public void show()
    {
        System.out.println("Shoe : " +
                "id=" + id +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                ", price=" + (price - (price*.1)) +
                ", heel='" + heel + '\'' +
                ", leather='" + leather + '\'' );
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Shoe : " +
                "id=" + id +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                ", price=" + (price - (price*.1)) +
                ", heel='" + heel + '\'' +
                ", leather='" + leather + '\'' ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
