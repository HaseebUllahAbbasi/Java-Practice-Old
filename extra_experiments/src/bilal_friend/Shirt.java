package bilal_friend;

public class Shirt
{

    int id;
    String category;
    String brand;
    float size;
    float cost;
    float price;
    //cost<price;
    String fabrics;
    String slaves;
    String collar_type;

    @Override
    public String toString() {
        return "Shirt : " +
                "id=" + id +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                ", price=" + (price - (price*.1)) +
                ", fabrics='" + fabrics + '\'' +
                ", slaves='" + slaves + '\'' +
                ", collar_type='" + collar_type + '\'';
    }

    public Shirt(int id, String category, String brand, float size, float cost, float price, String fabrics, String slaves, String color_type) {
        this.id = id;
        this.category = category;
        this.brand = brand;
        this.size = size;
        this.cost = cost;
        this.price = price;
        this.fabrics = fabrics;
        this.slaves = slaves;
        this.collar_type = color_type;
    }

    public Shirt() {

    }

    public void addProduct()
    {

    }
    public void show()
    {
        System.out.println("Shirt : " +
                "id=" + id +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                ", price=" + (price - (price*.1)) +
                ", fabrics='" + fabrics + '\'' +
                ", slaves='" + slaves + '\'' +
                ", collar_type='" + collar_type + '\'');
    }


    public int getId() {
        return id;
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
