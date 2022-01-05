package bg.startit.spring.project1.book;

import bg.startit.spring.project1.book.dto.BookRequest;
import bg.startit.spring.project1.book.dto.BookResponse;
import bg.startit.spring.project1.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController
{
  @Autowired
  private BookService bookService;

  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  @RequestMapping("/catalog")
  public ResponseEntity<List<BookResponse>> getAll(@RequestParam Integer pageNumber, @Min(value = 1)
  @Max(value = 100) @RequestParam Integer pageCapacity)
  {
    List<Book> bookList = bookService.getAll(PageRequest.of(pageNumber, pageCapacity));
    List<BookResponse> bookResponses = new ArrayList<>();
    for (Book book : bookList) {
      BookResponse bookResponse = new BookResponse()
          .setId(book.getId())
          .setTitle(book.getTitle())
          .setAuthor(book.getAuthor())
          .setIsbn(book.getIsbn())
          .setStock(book.getStock())
          .setYear(book.getYear())
          .setPrice(book.getPrice());
      bookResponses.add(bookResponse);
    }
    return new ResponseEntity<>(bookResponses, HttpStatus.OK);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Book>> getAll()
  {
    List<Book> books = bookService.getAll();
    return new ResponseEntity<>(books, HttpStatus.OK);
  }

  @GetMapping({"/{book_id}"})
  @PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN', 'USER')")
  public ResponseEntity<?> getById(@PathVariable("book_id") Long id)
  {
    return new ResponseEntity<>(bookService.getById(id), HttpStatus.OK);
  }

  @GetMapping("/greater_than_year")
  public ResponseEntity<List<Book>> getByYearGreaterThan(@RequestParam(value = "year",
      defaultValue = "2000") Integer year)
  {
    return new ResponseEntity<>(bookService.getByYearGreaterThan(year), HttpStatus.OK);
  }
  @GetMapping("/isbn")
  public ResponseEntity<List<Book>> getByIsbn(@RequestParam(value = "isbn") String isbn)
  {
    return new ResponseEntity<>(bookService.getByIsbn(isbn), HttpStatus.OK);
  }

  @GetMapping("/recent_author")
  public ResponseEntity<List<Book>> getByAuthorAndYearGreaterThan(@RequestParam(value = "author") String author,
                                                                  @RequestParam(defaultValue = "2000",
                                                                      required = false) Integer year)
  {
    return new ResponseEntity<>(bookService.getByAuthorAndYearGreaterThan(author, year), HttpStatus.OK);
  }
  @GetMapping("/author")
  @RequestMapping( method = RequestMethod.GET)
  public ResponseEntity<List<Book>> getByAuthor(@RequestParam(value = "author") String author)
  {
    return new ResponseEntity<>(bookService.getByAuthor(author), HttpStatus.OK);
  }

  @GetMapping("/title")
//  @RequestMapping( method = RequestMethod.GET)
  public ResponseEntity<List<Book>> getByTitle(@RequestParam(value = "title") String title)
  {
    return new ResponseEntity<>(bookService.getByTitle(title), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<Book> insert(@RequestBody BookRequest bookRequest)
  {
    return new ResponseEntity<>(bookService.insert(bookRequest), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id)
  {
    bookService.delete(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> update(@RequestBody BookRequest bookRequest, @PathVariable Long id)
  {
    return new ResponseEntity<>(bookService.insert(bookRequest), HttpStatus.OK);
  }

}
