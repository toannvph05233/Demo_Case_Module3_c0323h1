package com.example.demo1.dao;

import com.example.demo1.model.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO {
    Connection connection = ConnectMySQL.getConnect();

    public List<NhanVien> getAll(){
        List<NhanVien> nhanViens = new ArrayList<>();
        try {
            String sql = "select * from nhanvien";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                nhanViens.add(new NhanVien(id,name,img));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanViens;
    }

    public void save(NhanVien nhanVien){
        try {
            String sql = "insert into nhanvien(name,img) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,nhanVien.getName());
            preparedStatement.setString(2,nhanVien.getImg());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
