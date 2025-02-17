package com.crud_not_framework.dao;

import java.sql.SQLException;
import java.util.List;

public interface JPANewLearning {
    Object findById(Long id ) throws SQLException;
    <T> List< T > findAll() throws SQLException;
    <T> void save(T object)  throws SQLException;;
    void delete(Long id ) throws Exception;
    <T> void update(T object) throws Exception;

}
