package com.bjh.dao.impl;

import com.bjh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author Obito
 * @Date 2021/1/24 上午8:58
 * 批处理
 */
public class BatchDaoImpl {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        insertBatch();
        long end = System.currentTimeMillis();
        System.out.println("批处理花费的时间：" + (end - start));
    }

    public static void insertBatch(){
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert into person(id,name) values(?,?)";
        // 准备预处理块对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1,i + 1000);
                preparedStatement.setString(2,"BJH" + i);
                // 向批处理中添加SQL语句
                preparedStatement.addBatch();
            }
            int[] ints = preparedStatement.executeBatch();
//            for (int anInt : ints) {
//                System.out.println(anInt);
//            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection,preparedStatement);
        }
    }
}
