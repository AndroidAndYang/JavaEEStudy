package com.seabig.comm;

import com.seabig.comm.bean.User;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: YJZ
 * data: 2018/4/6.
 * des: Bean转换为Map,以及Map转换成Bean.通过内省机制
 */
public class MapBeanUtil {

    public static void main(String[] args) throws Exception {
        User user = new User("YJZ", 24);
        Map<String, Object> map = beanToMap(user);
        System.out.println(map.toString());

        User user1 = mapToBean(map, User.class);
        System.out.println(user1.toString());
    }

    /**
     * bean 转换成map
     *
     * @param object bean类
     * @return Map
     */
    private static Map<String, Object> beanToMap(Object object) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 获取class对象
        Class clz = object.getClass();
        // 通过内省机制获取class中的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
        // 获取类中的所有属性
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pds : propertyDescriptors) {
            // 属性名
            String name = pds.getName();
            // 获取值，通过get方法获取到字段的值
            Object value = pds.getReadMethod().invoke(object);
            map.put(name, value);
        }
        return map;
    }

    /**
     * map 转换成bean
     *
     * @param objectMap map对象
     * @param cla       需要转换的class对象
     * @param <T>       具体的类型
     * @return bean类
     * @throws Exception
     */
    public static <T> T mapToBean(Map<String, Object> objectMap, Class<T> cla) throws Exception {
        // 实例化class对象
        T clz = cla.newInstance();
        // 通过class对象获取BeanInfo对象
        BeanInfo beanInfo = Introspector.getBeanInfo(cla, Object.class);
        //获取Class下的属性和方法
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pds : propertyDescriptors) {
            // 获取属性名
            String name = pds.getName();
            // 获取值
            Object value = objectMap.get(name);
            // 调用setter方法
            pds.getWriteMethod().invoke(clz, value);
        }
        return clz;
    }
}
