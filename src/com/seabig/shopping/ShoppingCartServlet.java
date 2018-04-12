package com.seabig.shopping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: YJZ
 * data: 2018/4/12.
 * des: 购物车列表
 */
@WebServlet("/shopping")
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("save".equals(cmd)) {
            save(req, resp);
        } else {
            delete(req, resp);
        }
        resp.sendRedirect("/shopping/ShoppingCart.jsp");
    }

    /**
     * 添加商品到购物车
     */
    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String num = req.getParameter("num");

        CartItem item = new CartItem();
        if ("手机".equals(name)) {
            item.setId(123);
            item.setPrice(1000d);
        } else if ("平板".equals(name)) {
            item.setId(456);
            item.setPrice(2000d);
        } else if ("电脑".equals(name)) {
            item.setId(789);
            item.setPrice(3000d);
        }

        item.setName(name);
        item.setNumber(Integer.parseInt(num));

        // 获取购物车实例，有且只有一个购物车
        ShoppingCartHelper shoppingCART = (ShoppingCartHelper) req.getSession().getAttribute("SESSION_SHOPPING_CART");
        if (shoppingCART == null) {
            shoppingCART = new ShoppingCartHelper();
        }
        shoppingCART.save(item);
        // 设置session数据
        req.getSession().setAttribute("SESSION_SHOPPING_CART", shoppingCART);
    }

    /**
     * 删除指定商品
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ShoppingCartHelper shoppingCART = (ShoppingCartHelper) req.getSession().getAttribute("SESSION_SHOPPING_CART");
        shoppingCART.delete(Integer.parseInt(id));
    }
}
