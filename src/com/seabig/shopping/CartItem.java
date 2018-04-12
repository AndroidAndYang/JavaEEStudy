package com.seabig.shopping;

/**
 * @author: YJZ
 * data: 2018/4/12.
 * des: 购物车Bean
 */
public class CartItem {

    private int id;
    private String name;
    private int number;
    private Double price;

    public CartItem() {
    }

    public CartItem(int id, String name, int number, Double price) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }
}

