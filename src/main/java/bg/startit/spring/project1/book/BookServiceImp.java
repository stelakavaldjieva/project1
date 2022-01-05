package bg.startit.spring.project1.book;

import bg.startit.spring.project1.book.dto.BookRequest;
import bg.startit.spring.project1.exceptions.InvalidIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookServiceImp implements BookService
{
  @Autowired
  private BookRepository repository;

  @Override
  public Book getById(Long id)
  {
    if (repository.findById(id).isEmpty()) {
      throw new InvalidIdException("No book with id " + id + " available");
    }
    return repository.findById(id).get();
  }

  @Override
  public List<Book> getAll()
  {
    return (List<Book>) repository.findAll();
  }

  @Override
  public List<Book> getAll(PageRequest of)
  {
    return (List<Book>) repository.findAll();
  }

  @Override
  public List<Book> getByIsbn(String isbn)
  {
    if (repository.findByIsbn(isbn).isEmpty()) {
      throw new InvalidIdException("No book with ISBN " + isbn + " found");
    }
    return repository.findByIsbn(isbn);
  }

  @Override
  public List<Book> getByYearGreaterThan(int year)
  {
    if (year < 0 || year > 2021) {
      throw new InvalidIdException(String.format("Year is not valid: %d", year));
    }
    return repository.findByYearGreaterThan(year);
  }

  @Override
  @Transactional
  public List<Book> getByAuthorAndYearGreaterThan(String author, Integer year)
  {
    if (year < 0 || year > 2021) {
      throw new InvalidIdException(String.format("Year is not valid: %d", year));
    }
    if (repository.findByAuthorAndYearGreaterThan(author, year).isEmpty()) {
      throw new InvalidIdException(String.format("Not found author: %s", author));
    }
    return repository.findByAuthorAndYearGreaterThan(author, year);
  }

  @Override
  public List<Book> getByAuthor(String author)
  {
    if (repository.findByAuthor(author).isEmpty()) {
      throw new InvalidIdException("No book with author " + author + " found");
    }
    return repository.findByAuthor(author);
  }

  @Override
  public List<Book> getByTitle(String title)
  {
    if (repository.findByTitle(title).isEmpty()) {
      throw new InvalidIdException("No book with title " + title + " found");
    }
    return repository.findByTitle(title);
  }


  @Override
  public Book insert(BookRequest bookRequest)
  {
    Book book = new Book(bookRequest.getIsbn(),
        bookRequest.getTitle(),
        bookRequest.getAuthor(),
        BigDecimal.valueOf(12),
        bookRequest.getStock(),
        bookRequest.getYear());
    try {
      return repository.save(book);

    }
    catch (Exception e) {
      throw new InvalidIdException("Invalid book input!");
    }
  }

  @Override
  public void delete(Long id)
  {
    if (repository.findById(id).isPresent()) {
      repository.deleteById(id);
      return;
    }
    throw new InvalidIdException("You cannot delete a non existing book!");
  }
}
