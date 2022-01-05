package bg.startit.spring.project1.historyrecord.dto;

import bg.startit.spring.project1.book.Book;
import bg.startit.spring.project1.user.User;

import java.util.Date;

public class HistoryRecordResponse
{
  private Long id;

  private Book book;

  private User user;

  private Date dateOfLending;

  private Date dateOfReturn;

  public Long getId()
  {
    return id;
  }

  public HistoryRecordResponse setId(Long id)
  {
    this.id = id;
    return this;
  }

  public Book getBook()
  {
    return book;
  }

  public HistoryRecordResponse setBook(Book book)
  {
    this.book = book;
    return this;
  }

  public User getUser()
  {
    return user;
  }

  public HistoryRecordResponse setUser(User user)
  {
    this.user = user;
    return this;
  }

  public Date getDateOfLending()
  {
    return dateOfLending;
  }

  public HistoryRecordResponse setDateOfLending(Date dateOfLending)
  {
    this.dateOfLending = dateOfLending;
    return this;
  }

  public Date getDateOfReturn()
  {
    return dateOfReturn;
  }

  public HistoryRecordResponse setDateOfReturn(Date dateOfReturn)
  {
    this.dateOfReturn = dateOfReturn;
    return this;
  }
}
