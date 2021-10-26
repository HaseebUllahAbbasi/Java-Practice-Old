import java.util.ArrayList;
import java.util.Scanner;

public class Cart
{
    private final String shop_name;
    private final String shop_address;
    ArrayList<ProductCounter> purchasedProducts;
    private double total;
    public Cart() {
        this.purchasedProducts = new ArrayList<>();
        this.total = 0.0;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Shop Name");
        this.shop_name = input.nextLine();
        System.out.println("Enter Shop address");
        this.shop_address = input.nextLine();
    }

    public void addProduct(Product p)
    {
        ProductCounter product_result = purchasedProducts.stream()
                .filter(prod -> p.equals(prod.getObject()))
                .findAny()
                .orElse(null);

        if(product_result==null)
        {
            purchasedProducts.add(new ProductCounter(p,1,p.getPrice()));
        }
        else
        {
            purchasedProducts.stream().map(item-> {
                if(item.object.equals(p))
                {
                    item.noOfItems+=1;
                    item.subTotal = item.noOfItems*item.object.getPrice();
                    return item;
                }
                return  item;
            });

            product_result.noOfItems+=1;
            product_result.subTotal = product_result.object.getPrice() * product_result.noOfItems;
        }
        total+= p.getPrice();
    }
    public double getTransactionTotal()
    {
        return total;
    }
    /**
     * returns a formatted string containing the entire
     * representation of the receipt for this cart,
     * including store name, list of items with subtotals,
     * grand total, payment, and change.
     * @return a String
     */
    public String toString()
    {
        ArrayList<ProductCounter>  list = new ArrayList();
        StringBuilder data = new StringBuilder("\n\n" + shop_name + "\n" + shop_address + "\n\n");

        String heading = String.format("%-20s","Item");
        heading+="Subtotal";


        data.append(heading+"\n");
        for(ProductCounter product : purchasedProducts)
        {
            String new_data = String.format("%-20s", product.object.getName());
            data.append(new_data).append(""+ product.noOfItems + "").append("("+"$"+product.object.getPrice() +")\t\t").append("$"+(product.noOfItems*product.object.getPrice()));
            data.append("\n");
        }

        data.append("\n\nTotal $").append(total);
        return data.toString();
    }
}