package com.omarmohseni.repairingstoremanagment;

import java.sql.SQLException;
import java.util.List;

/**
 * Dao generic interface for interacting with a database
 * @param <T>
 */
public interface Dao<T> {
    T create(T t) throws SQLException;
    T read(Integer id) throws SQLException;
    T update(T t) throws SQLException;
    Boolean delete(T t) throws SQLException;
    List<T> list() throws SQLException;
}
