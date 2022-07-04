package Encapsulation.Exercise._3_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products=new ArrayList<>();
    }

    private void setName(String name) {
        if (name!=null && (!name.trim().isEmpty())){
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double money) {
        if (money>=0){
            this.money = money;
        }else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product){
        if (this.money>=product.getCost()){
            products.add(product);
            this.money-=product.getCost();
        }else {
            throw new IllegalArgumentException(this.name + "can't afford " + product.getName());
        }
    }

}
