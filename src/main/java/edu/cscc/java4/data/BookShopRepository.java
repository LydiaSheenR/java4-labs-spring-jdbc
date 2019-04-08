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


  public void setBookPrice (String isbn, double newPrice) {
    String updateStatment = "UPDATE BOOK SET PRICE = ? WHERE ISBN = ?";
    // TODO: Make me work
  }

  public double getBookPrice (String isbn) {
    String query = "SELECT PRICE FROM BOOK WHERE ISBN = ?";
    // TODO: Make me work
    return 0.00;
  }


  public void setQuantityOnHand (String isbn, int quantityOnHand) {
    String updateStatment = "UPDATE BOOK_STOCK SET QUANTITY = ? WHERE ISBN = ?";
    // TODO: Make me work
  }

  public int getQuantityOnHand(String isbn) {
    String query = "SELECT QUANTITY FROM BOOK_STOCK WHERE ISBN = ?";
    // TODO: Make me work
    return 0;
  }

  public void setAccountBalance (String username, double newBalance) {
    String updateStatment = "UPDATE ACCOUNT SET BALANCE = ? WHERE USERNAME = ?";
    // TODO: Make me work
  }

  public double getAccountBalance(String username) {
    String query = "SELECT BALANCE FROM ACCOUNT WHERE USERNAME = ?";
    // TODO: Make me work
    return 0.00;
  }


  public Collection<Book> getAllBooks () {

    String query = "SELECT ISBN, BOOK_NAME, PRICE FROM BOOK";
    // TODO: Make me work
    return null;
  }


  public Book getBookByIsbn (String isbn) {
    String query = "SELECT ISBN, BOOK_NAME, PRICE FROM BOOK WHERE ISBN = ?";
    // TODO: Make me work
    return null;
  }

  @Transactional
  public void purchase (String isbn, int quantity, String username) {

    String bookPriceQuery = "SELECT PRICE FROM BOOK WHERE ISBN = ?";
    String bookQtyUpdateStatement = "UPDATE BOOK_STOCK SET QUANTITY = QUANTITY - ? WHERE ISBN = ?";
    String accountBalanceUpdateStatement = "UPDATE ACCOUNT SET BALANCE = BALANCE - ? WHERE USERNAME = ?";

    // TODO: Make me work
  }

}
