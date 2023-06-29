package com.example.demo1.dao;

import com.example.demo1.model.Account;
import com.example.demo1.model.NhanVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    Connection connection = ConnectMySQL.getConnect();

    public Account getLogin(String username, String password) {
        try {
            String sql = "select * from `account` where `username`= ? and `password`= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            resultSet.next();
            int id = resultSet.getInt("id");
            String role = resultSet.getString("role");
            return new Account(id, username, password, role);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
