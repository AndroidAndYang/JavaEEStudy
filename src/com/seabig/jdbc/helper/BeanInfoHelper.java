package com.seabig.jdbc.helper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

/**
 * @author: YJZ
 * data: 2018/3/29.
 * des 查询单个,实体类属性名必须要表名的列名一致
 */
public class BeanInfoHelper<T> implements IResultSetHelper<T> {

    private Class<T> aClass;

    public BeanInfoHelper(Class<T> tClass) {
        this.aClass = tClass;
    }

    @Override
    public T hand(ResultSet resultSet) {
        // 创建当前aClass所表示的对象
        try {
            T obj = aClass.newInstance();
            // 通过Introspector类来获取JavaBean属性。(内省机制)
            // 第一个参数是我们需要获取JAVABean类，第二个是不想获取的属性(会获取所有，这里表示除掉class属性)。
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass, Object.class);
            // 获取该对象的所有属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (resultSet.next()) {
                for (PropertyDescriptor pro : propertyDescriptors) {
                    // 属性名(列名)
                    String name = pro.getName();
                    // 获取对应的值
                    Object value = resultSet.getObject(name);
                    // 调用属性的set方法
                    pro.getWriteMethod().invoke(obj, value);
                }
                return obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
