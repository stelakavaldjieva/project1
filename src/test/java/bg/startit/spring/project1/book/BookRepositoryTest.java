package bg.startit.spring.project1.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

import java.math.BigDecimal;

import static org.testng.Assert.*;

@DataJpaTest
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public class BookRepositoryTest extends AbstractTestNGSpringContextTests
{
  @Autowired
  private BookRepository bookRepository;

  @BeforeClass
  public void beforeClass()
  {
    System.out.println("once on testing start");
  }

  @AfterClass
  public void afterClass()
  {
    System.out.println("once on testing end");
  }

  @BeforeMethod
  public void setUp()
  {
    System.out.println("================SETUP STARTED=====================");
  }

  @AfterMethod
  public void tearDown()
  {
    System.out.println("================TEAR DOWN STARTED=====================");

  }

  @BeforeSuite
  @Override
  protected void springTestContextPrepareTestInstance() throws Exception
  {
    super.springTestContextPrepareTestInstance();
  }

  @Test
  public void saveTest()
  {
    Book book = new Book();
    assertNull(book.getId());
    book.setAuthor("Puzo");
    book.setTitle("Godfather");
    book.setIsbn("9893817311301");
    book.setPrice(BigDecimal.TEN);
    book.setStock(10);
    book.setYear(1950);
    assertNull(book.getId());
    bookRepository.save(book);
    assertNotNull(book.getId());
    assertTrue(book.getId() > 0, "book id should be a positive number");
    assertEquals(book.getId(), Long.valueOf(100));
  }

  @Test
  public void deleteTest()
  {
    fail("====================FAKE FAILING TEST=======================");
  }

}