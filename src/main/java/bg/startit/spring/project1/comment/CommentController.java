package bg.startit.spring.project1.comment;

import bg.startit.spring.project1.book.BookService;
import bg.startit.spring.project1.exceptions.AnonymousUserAuthenticationException;
import bg.startit.spring.project1.user.User;
import bg.startit.spring.project1.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController
{
  private final UserService userService;

  private final BookService bookService;

  private final CommentService commentService;

  public CommentController(UserService userService, BookService bookService, CommentService commentService)
  {
    this.userService = userService;
    this.bookService = bookService;
    this.commentService = commentService;
  }

  @GetMapping("/{comment_id}")
  public ResponseEntity<Comment> getById(@PathVariable(name = "comment_id") Long id)
  {
    Comment comment = commentService.getById(id);
    return new ResponseEntity<>(commentService.getById(id), HttpStatus.OK);
  }

  @GetMapping("/get_all_books/{bookId}")
  public ResponseEntity<List<Comment>> getByBookId(@PathVariable Long bookId)
  {
    return new ResponseEntity<>(commentService.getByBookId(bookId), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Comment>> getAll()
  {
    return new ResponseEntity<>(commentService.getAll(), HttpStatus.OK);
  }

//  @GetMapping("/{userId}")
//  public ResponseEntity<List<User>> getByUser(@PathVariable Long userId)
//  {
//    return new ResponseEntity<>(commentService.getByUser(userId), HttpStatus.OK);
//  }

  @GetMapping("/user")
  public ResponseEntity<List<Comment>> getByUser()
  {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (!(principal instanceof UserDetails)) {
      throw new AnonymousUserAuthenticationException("Cannot get user from session!");
    }
    User user = userService.getByEmail(((UserDetails) principal).getUsername());

    return new ResponseEntity<>(commentService.getByUser(user), HttpStatus.OK);
  }

  @PostMapping("book/{bookId}")
  public ResponseEntity<Comment> insert(@PathVariable Long bookId, @RequestBody Comment comment) throws GeneralSecurityException
  {
    if (bookService.getById(bookId) == null) {
      throw new GeneralSecurityException("Book with id: " + bookId + "does not exist");
    }
    comment.setBook(bookService.getById(bookId));

    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (!(principal instanceof UserDetails)) {
      throw new AnonymousUserAuthenticationException("Cannot get user from session!");
    }
    comment.setUser(userService.getByEmail(((UserDetails) principal).getUsername()));

    return new ResponseEntity<>(commentService.insert(comment), HttpStatus.OK);
  }

  @PutMapping("/{bookId}")
  public ResponseEntity<Comment> update(@PathVariable Long bookId, @RequestBody Comment comment)
  {
    return new ResponseEntity<>(commentService.insert(comment), HttpStatus.OK);
  }

  @DeleteMapping("/{comment_id}")
  public void delete(@PathVariable("comment_id") Long id)
  {
    commentService.delete(id);
  }
}
