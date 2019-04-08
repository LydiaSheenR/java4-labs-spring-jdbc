package edu.cscc.java4.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.Collection;

public class BookShopRepository {

  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource (DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }


  public void purchase (String isbn, int quantity, String username) {

    String bookPriceQuery = "SELECT PRICE FROM BOOK WHERE ISBN = ?";
    String bookQtyUpdateStatement = "UPDATE BOOK_STOCK SET QUANTITY = QUANTITY - ? WHERE ISBN = ?";
    String accountBalanceUpdateStatement = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE USERNAME = ?";

    // TODO Implement Me
  }

  public int getQuantityOnHand(String isbn) {
    String query = "select quantity from book_stock where isbn = ?";
    // TODO Implement Me
    return 0;
  }

  public double getAccountBalance(String username) {
    String query = "select balance from account where USERNAME = ?";
    // TODO Implement Me
    return 0.00;
  }


  public Collection<Book> getAllBooks () {

    String query = "select isbn, book_name, price from book";
    // TODO Implement Me
    return null;
  }


  public Book getBookByIsbn (String isbn) {
    String query = "select isbn, book_name, price from book where isbn = ?";
    // TODO Implement Me
    return null;
  }

}
