package com.seabig.comm.bean;

/**
 * @author: YJZ
 * data: 2018/4/6.
 */
public class User {

    private String name;
    private int aget;

    public User() {
    }

    public User(String name, int aget) {
        this.name = name;
        this.aget = aget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAget() {
        return aget;
    }

    public void setAget(int aget) {
        this.aget = aget;
    }

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", aget=" + aget +
                '}';
    }
}
