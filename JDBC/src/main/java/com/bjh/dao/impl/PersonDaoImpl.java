package com.bjh.dao.impl;

import com.bjh.dao.PersonDao;
import com.bjh.pojo.Person;
import com.bjh.util.DBUtil;

import java.sql.*;


/**
 * @Author Obito
 * @Date 2021/1/19 下午4:11
 */
public class PersonDaoImpl implements PersonDao {
    public void insert(Person person) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into person values(?,?)";
            statement = connection.prepareStatement(sql);
            System.out.println(sql);
            statement.setInt(1,person.getId());
            statement.setString(2,person.getName());
            int i = statement.executeUpdate();
            System.out.println("受影响的行数" + i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.closeConnection(connection,statement);
    }
    public void deleteById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from person where id= ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id.toString());
            System.out.println(sql);
            int i = preparedStatement.executeUpdate();
            System.out.println("受影响的行数" + i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.closeConnection(connection,preparedStatement);
    }

    public void deleteByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from person where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            System.out.println(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.closeConnection(connection,preparedStatement);
    }

    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person(2,"sss");
        //personDao.insert(person);
        personDao.deleteById(2);
    }
}
