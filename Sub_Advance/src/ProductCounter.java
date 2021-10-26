public class ProductCounter
{
    public ProductCounter(Product object, int noOfItems, double subTotal) {
        this.object = object;
        this.noOfItems = noOfItems;
        this.subTotal = subTotal;
    }
    Product object;
    public Product getObject() {
        return object;
    }
    int noOfItems;
    double subTotal;
}