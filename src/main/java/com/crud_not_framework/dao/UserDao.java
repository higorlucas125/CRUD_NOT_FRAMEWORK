package com.crud_not_framework.dao;

import com.crud_not_framework.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao implements JPANewLearning {

    private User returnObject (PreparedStatement stmt) throws SQLException {

        User user = null;
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        }

        return user;
    }


    @Override
    public Object findById(Long id) throws SQLException {
        String sql = "SELECT * FROM defaultdb.users WHERE id = ? ";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
        ){
            stmt.setLong(1,id);
           return returnObject(stmt);
        }
    }

    @Override
    public <T> List<T> findAll() throws SQLException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM users";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }

        }

        return (List<T>) users;
    }

    @Override
    public <T> void save(T object) throws SQLException {

        String sql = "INSERT INTO users (name,email) VALUES(?,?)";

        User user = (User) object;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
        ){
            stmt.setString(1,user.getName());
            stmt.setString(2,user.getEmail());
            stmt.executeUpdate();
        }

    }

    @Override
    public void delete(Long id) throws Exception {
        User user = (User) findById(id);

        if(user == null ){
            throw new Exception("Não existe id para deletar");
        }

        String sql = "DELETE FROM users WHERE id = ?";

        try(Connection connection = DatabaseConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }


    @Override
    public <T> void update(T object) throws Exception {
        User user = (User) object;

        if(user == null){
            throw new Exception("Não existe esse id ");
        }

        String sql = "UPDATE users SET name = ?, email =? WHERE id= ?";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setLong(3, user.getId());
            preparedStatement.executeUpdate();

        }

    }
}
