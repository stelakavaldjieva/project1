package bg.startit.spring.project1.book;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{

  List<Book> findByIsbn(String isbn);

  List<Book> findByYearGreaterThan(Integer year);

  List<Book> findByAuthorAndYearGreaterThan(String author, Integer year);


  List<Book> findByAuthor(String author);

  List<Book> findByTitle(String title);
}
