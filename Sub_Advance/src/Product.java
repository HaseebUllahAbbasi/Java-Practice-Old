public class Product
{
    private String productSKU;
    private String productName;
    private String productSize;
    private double productPrice;

    /**
     * creates a Product object with given name, size, and price
     * @param productName - the name of this product
     * @param productSize - the size of this product as a string
     * @param productPrice  - the price of this product as a double
     * **/
    public Product(String productSKU, String productName, String productSize, double productPrice) {
        this.productSKU = productSKU;
        this.productName = productName;
        this.productSize = productSize;
        this.productPrice = productPrice;
    }


    public String getName() {
        return productName;
    }

    public String getSKU() {
        return productSKU;
    }

    public String getSize() {
        return productSize;
    }

    public double getPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return "Product {" +
                "productSKU='" + productSKU + '\'' +
                ", productName='" + productName + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    /**
     * overrides equals() so that two Product objects are considered equal if the
     * strings representing their SKU numbers are equal
     * */
    public boolean equals(Object other)
    {
        Product otherProduct = (Product) other;
        if(this.productSKU.equals(otherProduct.getSKU())) {
            return true;
        }
        return false;
    }
}