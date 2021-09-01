/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample_11;

/**
 *
 * @author Haseeb
 */
public class Movie extends Product 
{
    
    @Override
    public String toString() {
        return "Movie{" + "name=" + name + ", price=" + price + ", quantity=" + quantity + '}';
    }
    

    public Movie(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public Movie() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
