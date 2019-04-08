package edu.cscc.java4.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AnnotatedTransactionalBookShopTests {

  private final String ISBN = "0001";
  private final String USER1 = "user1";

  @Autowired
  BookShopRepository repository;

  @Test
  public void findByValidIsbnWorks_Test () {
    Book book = repository.getBookByIsbn(ISBN);
    assertNotNull(book);
    assertEquals(ISBN, book.getIsbn());
  }

  @Test
  public void findByBadIsbnWorks_Test () {
    Book book = null;
    try {
      book = repository.getBookByIsbn("0000");
      fail("EmptyResultDataAccessException not thrown");
    }
    catch (EmptyResultDataAccessException exception) {
      // Should happen
    }
    assertNull(book);
  }

  @Test
  public void findAllBooksWorks_Test () {

    Collection<Book> books = repository.getAllBooks();
    assertEquals(1,books.size());
    Book book = books.iterator().next();
    assertEquals(ISBN, book.getIsbn());
  }

  @Test
  public void purchaseDecrementsQtyOnHandAndBalance_Test () {
    assertEquals(10, repository.getQuantityOnHand(ISBN));
    assertEquals(25.00, repository.getAccountBalance(USER1), 0.00);
    repository.purchase(ISBN, 1, USER1);
    assertEquals(9, repository.getQuantityOnHand(ISBN));
    assertEquals(18.00, repository.getAccountBalance(USER1), 0.00);
  }

  @Test
  public void consistentStateMaintainedWhenBalanceExceeded_Test () {
    assertEquals(10, repository.getQuantityOnHand(ISBN));
    assertEquals(25.00, repository.getAccountBalance(USER1), 0.00);
    try {
      repository.purchase(ISBN, 4, USER1);
      fail("Should have thrown DataIntegrityViolationException");
    }
    catch (DataIntegrityViolationException e) {
    }
    finally {
      assertEquals(10, repository.getQuantityOnHand(ISBN));
      assertEquals(25.00, repository.getAccountBalance(USER1), 0.00);
    }
  }

}
