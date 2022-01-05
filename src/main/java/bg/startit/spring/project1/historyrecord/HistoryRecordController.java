package bg.startit.spring.project1.historyrecord;

import bg.startit.spring.project1.exceptions.AnonymousUserAuthenticationException;
import bg.startit.spring.project1.historyrecord.dto.HistoryRecordRequest;
import bg.startit.spring.project1.user.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/history_record")
public class HistoryRecordController
{
  @Autowired
  private final HistoryRecordService historyRecordService;

  @Autowired
  private final UserService userService;

  public HistoryRecordController(HistoryRecordService historyRecordService, UserService userService)
  {
    this.historyRecordService = historyRecordService;
    this.userService = userService;
  }

  @GetMapping("/all")
  public ResponseEntity<List<HistoryRecord>> getAll()
  {
    List<HistoryRecord> historyRecords = historyRecordService.getAll();
    return new ResponseEntity<>(historyRecords, HttpStatus.OK);
  }

  @GetMapping("/history_record_id")
  public ResponseEntity<HistoryRecord> getById(@RequestParam(value = "history_record_id", required = false,
      defaultValue = "1") Long id)
  {
    return new ResponseEntity<>(historyRecordService.getById(id), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<HistoryRecord> insert(@RequestBody HistoryRecordRequest historyRecordRequest)
  {
    return new ResponseEntity<>(historyRecordService.insert(historyRecordRequest), HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id)
  {
    historyRecordService.delete(id);
  }

  @PutMapping("{record_id}")
  public ResponseEntity<HistoryRecord> update(@PathVariable("record_id") Long id)
  {
    return new ResponseEntity<>(historyRecordService.insert(id), HttpStatus.OK);
  }

  //TODO these methods
  @GetMapping("/user/{user_id}")
  public ResponseEntity<List<HistoryRecord>> getByUserId(@PathVariable("user_id") Long userId)
  {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof AnonymousAuthenticationToken) {
      throw new AnonymousUserAuthenticationException("Current user not authenticated");
    }
    return new ResponseEntity<>(historyRecordService.getByUserId(userId), HttpStatus.OK);
  }

  @GetMapping("/book/{book_id}")
  public ResponseEntity<List<HistoryRecord>> getByBookId(@PathVariable("book_id") Long bookId)
  {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof AnonymousAuthenticationToken) {
      throw new AnonymousUserAuthenticationException("Current user not authenticated");
    }
    return new ResponseEntity<>(historyRecordService.getByBookId(bookId), HttpStatus.OK);
  }

  @PostMapping("/lending_date")
  public ResponseEntity<List<HistoryRecord>> getByLendingDate(@Valid @RequestParam("lending_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date lendingDate)
  {
    return new ResponseEntity<>(historyRecordService.getByLendingDate(lendingDate), HttpStatus.OK);
  }

  @PostMapping("/return_date")
  public ResponseEntity<List<HistoryRecord>> getByReturnDate(@Valid @RequestParam("return_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date returnDate)
  {
    return new ResponseEntity<>(historyRecordService.getByReturnDate(returnDate), HttpStatus.OK);
  }

  @PostMapping("/user_and_return_date")
  public ResponseEntity<List<HistoryRecord>> getByUserIdAndReturnDate(@NotNull @RequestParam("user_id") Long userId,
                                                                      @NotNull @RequestParam("return_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date returnDate)
  {
    return new ResponseEntity<>(historyRecordService.getByUserIdAndReturnDate(userId, returnDate), HttpStatus.OK);
  }

  @GetMapping("/unreturned_books")
  public ResponseEntity<List<HistoryRecord>> getAllReturnedBooksByCurrentUser()
  {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Long currentUserId;

    if (principal instanceof UserDetails) {
      currentUserId = userService.getByEmail(((UserDetails) principal).getUsername()).getId();
    }
    else {
      throw new AnonymousUserAuthenticationException("Cannot get user from session!");
    }

    return new ResponseEntity<>(historyRecordService.getByUserIdAndReturnDate(currentUserId, null), HttpStatus.OK);
  }
}
