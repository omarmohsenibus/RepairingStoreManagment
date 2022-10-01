package com.omarmohseni.repairingstoremanagment.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao<Customer>{
    private final Connection connection;
    private String sql;

    public CustomerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Customer create(Customer customer) throws SQLException {
        Customer c = null;
        sql = "INSERT INTO customer(firstName, lastName, CF, email) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);


        return c;
    }

    @Override
    public Customer read(Integer id) throws SQLException {
        Customer c = null;
        sql = "SELECT id, firstName, lastName, CF, email FROM customer WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("firstName"));
            c.setLastName(rs.getString("lastName"));
            c.setCF(rs.getString("CF"));
            c.setEmail(rs.getString("email"));
        }

        return c;
    }

    @Override
    public Customer update(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(Customer customer) throws SQLException {
        return null;
    }

    @Override
    public List<Customer> list() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        sql = "SELECT id, firstName, lastName, CF, email FROM customer";
        PreparedStatement stmt = connection.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setFirstName(rs.getString("firstName"));
            c.setLastName(rs.getString("lastName"));
            c.setCF(rs.getString("CF"));
            c.setEmail(rs.getString("email"));
            customers.add(c);
        }

        return customers;
    }
}
