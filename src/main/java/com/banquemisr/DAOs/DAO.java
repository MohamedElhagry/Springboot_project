package com.banquemisr.DAOs;

import com.banquemisr.DTOs.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private static DAO dao;
    public static Connection connection;

    Connection getConnection()  {
        if(connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            String dbURL = "jdbc:postgresql://localhost:5432/AppDB";
            try {
                connection = DriverManager.getConnection
                        (dbURL, "postgres", "hagry");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    public boolean addCustomer(CustomerDTO customer) {
        Connection con = getConnection();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Customers (name, balance, address) VALUES(?,?,?)");
//            pstmt.setInt(1, customer.getId());
            pstmt.setString(1, customer.getName());
            pstmt.setLong(2, customer.getBalance());
            pstmt.setString(3, customer.getAddress());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection(con);
        }
    }

    public List<CustomerDTO> getCustomer(int id) {
        Connection con = getConnection();
        List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

        try {
            PreparedStatement pstmt = con.prepareStatement("Select * From Customers Where 1=1 and id = " + id);
            ResultSet rSet = pstmt.executeQuery();

            while (rSet.next()) {
                customers.add(new CustomerDTO(rSet.getInt(1), rSet.getString(2), rSet.getLong(3), rSet.getString(4)));
            }
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
     */

}
