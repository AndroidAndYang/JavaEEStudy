package com.seabig.jdbc.helper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: YJZ
 * data: 2018/3/29.
 * des 查询多个,实体类属性名必须要表名的列名一致
 */
public class BeanInfoListHelper<T> implements IResultSetHelper<List<T>> {

    private Class<T> aClass;

    public BeanInfoListHelper(Class<T> tClass) {
        this.aClass = tClass;
    }

    @Override
    public List<T> hand(ResultSet resultSet) {
        // 创建当前aClass所表示的对象
        List<T> list = new ArrayList<>();
        try {
            T obj = aClass.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass, Object.class);
            // 获取该对象的所有属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            while (resultSet.next()) {
                for (PropertyDescriptor pro : propertyDescriptors) {
                    // 属性名(列名)
                    String name = pro.getName();
                    // 获取对应的值
                    Object value = resultSet.getObject(name);
                    // 调用属性的set方法
                    pro.getWriteMethod().invoke(obj, value);
                }
                list.add(obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
