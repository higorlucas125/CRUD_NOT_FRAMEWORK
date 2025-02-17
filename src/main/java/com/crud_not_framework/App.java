package com.crud_not_framework;

import com.crud_not_framework.dao.DatabaseConnection;
import com.crud_not_framework.dao.UserDao;
import com.crud_not_framework.model.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        // FUNCIONANDO A CONEXÃO COM O BANCO DE DADOS.
        try {
//            User user = new User();
//            user.setId(1);
//            user.setName("Test");
//            user.setEmail("higortt@gmail.com");

            UserDao userDao = new UserDao();

//            userDao.save(user);

            User user1 = (User) userDao.findById(1L);

            System.out.println(user1);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
