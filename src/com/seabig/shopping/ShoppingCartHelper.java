package com.seabig.shopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: YJZ
 * data: 2018/4/12.
 */
public class ShoppingCartHelper {

    private List<CartItem> items = new ArrayList<>();

    /**
     * 获取所有商品
     */
    public List<CartItem> getItems() {
        return items;
    }


    /**
     * 添加商品到购物车
     */
    public void save(CartItem item) {
        // 判断添加的商品
        for (CartItem cartItem : items) {
            if (cartItem.getId() == item.getId()) {
                cartItem.setNumber(cartItem.getNumber() + item.getNumber());
                return;
            }
        }
        items.add(item);
    }

    /**
     * 获取购物车总价
     */
    public Double getTotalPrice() {
        double totalPrice = 0;
        for (CartItem cartItem : items) {
            totalPrice += cartItem.getPrice() * cartItem.getNumber();
        }
        return totalPrice;
    }

    /**
     * 移除商品到购物车
     *
     * @param id
     */
    public void delete(int id) {
        Iterator<CartItem> iterator = items.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
            }
        }
    }

}
