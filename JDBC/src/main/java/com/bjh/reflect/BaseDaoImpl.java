package com.bjh.reflect;

import com.bjh.pojo.Person;
import com.bjh.util.DBUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author Obito
 * @Date 2021/1/24 上午10:43
 * 要查询N张表，但是不想写N多的方法，能否写一个方法完成所有的表的查询工作
 */
public class BaseDaoImpl {

    /**
     * 统一的查询表的方法
     * @param sql     不同的SQL语句
     * @param params  SQL语句的参数
     * @param clazz   SQL语句查询返回的对象
     * @return
     */
    public List getRows(String sql,Object[] params,Class clazz){

        List list = new ArrayList();

        // 准备
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 获取连接
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // 给SQL语句填充参数
            if (params != null){
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i+1,params[i]);
                }
            }
            // 开始执行查询操作
            resultSet = preparedStatement.executeQuery();
            // 获取结果集合的元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 判断查询到的每一行记录中包含多少个列
            int columnCount = metaData.getColumnCount();
            // 循环遍历
            while (resultSet.next()){
                // 创建放置具体结果属性的对象
                Object o = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 从结果集合中获取单一列的值
                    Object objValue = resultSet.getObject(i + 1);
                    // 获取列的名称
                    String columnName = metaData.getColumnName(i + 1).toLowerCase();
                    // 获取类中的属性
                    Field declaredField = clazz.getDeclaredField(columnName);
                    // 获取类中属性对应的set方法
                    Method method = clazz.getMethod(getSetName(columnName), declaredField.getType());
                    if(objValue instanceof Number){
                        Number number = (Number) objValue;
                        String fname = declaredField.getType().getName();
                        if("int".equals(fname) || "java.lang.Integer".equals(fname)){
                            method.invoke(o,number.intValue());
                        }else if ("byte".equals(fname) || "java.lang.Byte".equals(fname)){
                            method.invoke(o,number.byteValue());
                        }else if ("short".equals(fname) || "java.lang.Short".equals(fname)){
                            method.invoke(o,number.shortValue());
                        }else if ("long".equals(fname) || "java.lang.Long".equals(fname)){
                            method.invoke(o,number.longValue());
                        }else if ("float".equals(fname) || "java.lang.Float".equals(fname)){
                            method.invoke(o,number.floatValue());
                        }else if ("double".equals(fname) || "java.lang.Double".equals(fname)){
                            method.invoke(o,number.doubleValue());
                        }
                    }else {
                        method.invoke(o,objValue);
                    }
                }
                list.add(o);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,preparedStatement);
        }

        return list;
    }

    public String getSetName(String name){
        return "set" + name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public static void main(String[] args) {
        BaseDaoImpl baseDao = new BaseDaoImpl();
        List rows = baseDao.getRows("select id,name from person where id = ?", new Object[]{1000}, Person.class);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()){
            Person next = (Person)iterator.next();
            System.out.println(next);
        }

    }
}
