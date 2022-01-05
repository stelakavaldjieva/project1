package bg.startit.spring.project1.book;

import bg.startit.spring.project1.book.dto.BookRequest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BookService
{
  Book getById(Long id);

  List<Book> getAll();

  List<Book> getAll(PageRequest of);

  List<Book> getByIsbn(String isbn);

  List<Book> getByYearGreaterThan(int year);

  List<Book> getByAuthorAndYearGreaterThan(String author, Integer year);

  List<Book> getByAuthor(String author);

  List<Book> getByTitle(String title);

  Book insert(BookRequest bookRequest);

  void delete(Long id);


}
