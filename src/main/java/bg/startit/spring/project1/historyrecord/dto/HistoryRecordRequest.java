package bg.startit.spring.project1.historyrecord.dto;

import bg.startit.spring.project1.book.Book;
import bg.startit.spring.project1.user.User;

import java.time.LocalDateTime;
import java.util.Date;

public class HistoryRecordRequest
{
  private Book book;

  private User user;

  private Date dateOfLending;

  private Date dateOfReturn;

  public Book getBook()
  {
    return book;
  }

  public HistoryRecordRequest setBook(Book book)
  {
    this.book = book;
    return this;
  }

  public User getUser()
  {
    return user;
  }

  public HistoryRecordRequest setUser(User user)
  {
    this.user = user;
    return this;
  }

  public Date getDateOfLending()
  {
    return dateOfLending;
  }

  public HistoryRecordRequest setDateOfLending(Date dateOfLending)
  {
    this.dateOfLending = dateOfLending;
    return this;
  }

  public Date getDateOfReturn()
  {
    return dateOfReturn;
  }

  public HistoryRecordRequest setDateOfReturn(Date dateOfReturn)
  {
    this.dateOfReturn = dateOfReturn;
    return this;
  }
}
