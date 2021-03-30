package org.ucvts.comics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ucvts.comics.model.Customer;

public class CustomerDAO {

    /**
     * Retrieves a Customer from the database.
     * 
     * @param cusotmerId the customerId of the customer to retrieve
     * @return the customer retrieved from the database
     * @throws SQLException 
     */
    
    public static Customer getCustomer(long customerId) throws SQLException {
        Customer customer = null;
        
        // first, we need to establish a connection to the database. we
        // call getConnection, which will return a new connection object.
        
        Connection conn = DAO.getConnection();
        
        // a statement is a query we'll execute on the database. this
        // includes select, insert, update, and delete statements. a
        // prepared statement is a parameterized statement that allows
        // us to pass in values to predefined placeholders.
        
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM customers WHERE customerId = ?");
        
        // we need to provide an actual value for our placeholder.
        
        pstmt.setLong(1, customerId);
        
        // when we execute our query (a select statement), it's going to
        // return zero or more rows. we'll store that result in what is
        // called a result set.
        
        ResultSet rs = pstmt.executeQuery();
        
        // a result set has something called a cursor that points at the
        // current row. initially, this cursor is positioned before the
        // first row (i.e., it points at nothing). we need to call next
        // to tell the cursor to advance to the first row.
        //
        // next returns a boolean value. if it returns true, that means
        // the cursor successfully advanced to the next row (which, in this
        // case, is the first row).
        //
        // our query is designed to return a single row. if next returns
        // true, that means we've got a row. we'll use that row to build
        // a CUSTOMER object.
            
        if (rs.next()) {
            customer = new Customer();
            
            customer.setCustomerId(rs.getLong(1));
            customer.setFirstName(rs.getString(2));
            customer.setLastName(rs.getString(3));
            customer.setPhone(rs.getLong(4));
            customer.setEmail(rs.getString(5));
            customer.setStreetAddress(rs.getString(6));
            customer.setCity(rs.getString(7));
            customer.setState(rs.getString(8));
            customer.setPostalCode(rs.getString(9));
            
        }
        
        // we're done with the result set, prepared statement, and connection
        // objects, so we should close them. this is a form of memory management.
                
        rs.close();
        pstmt.close();
        conn.close();
        
        return customer;
    }
    
    /**
     * Retrieves all Customers from the database.
     * 
     * @return a list of cusomters retrieved from the database
     * @throws SQLException
     */
    
    public static List<Customer> getCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        Connection conn = DAO.getConnection();
        
        // earlier, we created a prepared statement (i.e., a parameterized
        // statement). this is just a regular statement, which is used for
        // simpler queries that don't require additional values.
        
        Statement stmt = conn.createStatement();
        
        // statements are executed the same way prepared statements are. their
        // results are stored in a result set, too. the only difference is we
        // pass the SQL directly into the executeQuery method.
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
        
        // remember, next returns true if the cursor is advanced to the next
        // row. last time, we called next in an if statement to advance the
        // cursor to the first and only row.
        //
        // this query is designed to return more than one row, so we call next
        // in the condition of a while loop instead. this allows us to repeatedly
        // build CUSTOMERs from every row in the result set. the while loop will
        // exist after the last row is processed and next returns false.
                
        while (rs.next()) {
        	 Customer customer = new Customer();
             
             customer.setCustomerId(rs.getLong(1));
             customer.setFirstName(rs.getString(2));
             customer.setLastName(rs.getString(3));
             customer.setPhone(rs.getLong(4));
             customer.setEmail(rs.getString(5));
             customer.setStreetAddress(rs.getString(6));
             customer.setCity(rs.getString(7));
             customer.setState(rs.getString(8));
             customer.setPostalCode(rs.getString(9));
                        
            customers.add(customer);
        }
        
        rs.close();
        stmt.close();
        conn.close();
        
        return customers;
    }
    
    /**
     * Inserts a Customer into the database.
     * 
     * @param customer the customer to insert into the database
     * @throws SQLException
     */
        
    public static void insertCustomer(Customer customer) throws SQLException {        
        Connection conn = DAO.getConnection();        
        PreparedStatement pstmt = conn.prepareStatement(
        	"INSERT INTO customers (" +
            "	firstname," +
            "	lastname," +
            "	phone," +
            "	email," +
            "	streetaddress," +
            "	city," +
            "	state," +
            "	postalcode," +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
        );
        
        // we've got quite a few more placeholders to fill in this time. they
        // are numbered in the order in which they appear in the SQL statement.
        
        pstmt.setString(1, customer.getFirstName());
        pstmt.setString(2, customer.getLastName());
        pstmt.setLong(3, customer.getPhone());
        pstmt.setString(4, customer.getEmail());
        pstmt.setString(5, customer.getStreetAddress());
        pstmt.setString(6, customer.getCity());
        pstmt.setString(7, customer.getState());
        pstmt.setString(8, customer.getPostalCode());
        
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }
    
    /**
     * Updates an existing Customer in the database
     * 
     * @param customer the new customer used to update the old one
     * @throws SQLException
     */
    
    public static void updateCustomer(Customer customer) throws SQLException {
        Connection conn = DAO.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(
			"UPDATE customers SET" +
			"	firstname = ?" +
			"	lastname = ?" +
			"	phone = ?" +
			"	email = ?" +
			"	streetaddress = ?" +
			"	city = ?" +
			"	state = ?" +
			"	postalcode = ?" +
			"WHERE id = ?"
        );
                
        pstmt.setString(1, customer.getFirstName());
        pstmt.setString(2, customer.getLastName());
        pstmt.setLong(3, customer.getPhone());
        pstmt.setString(4, customer.getEmail());
        pstmt.setString(5, customer.getStreetAddress());
        pstmt.setString(6, customer.getCity());
        pstmt.setString(7, customer.getState());
        pstmt.setString(8, customer.getPostalCode());
        
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }
    
    /**
     * Deletes an existing Customer from the database.
     * 
     * @param customer the customer to delete
     * @throws SQLException
     */
    
    public static void deleteCustomer(Customer customer) throws SQLException {
        Connection conn = DAO.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("DELETE FROM customer WHERE id = ?");
        
        // we're deleting a CUSTOMER from the table, so we only need the primary key
        // (in this case, the id column). a primary key, which can be a combination
        // of columns (called a composite key) is the value that is guaranteed to
        // uniquely identify a row in the table.
        
        pstmt.setLong(1, customer.getCustomerId());
        
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }
}