package bg.startit.spring.project1.historyrecord;

import bg.startit.spring.project1.book.Book;
import bg.startit.spring.project1.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class HistoryRecord
{
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Book book;

  @ManyToOne
  private User user;

  @Temporal(TemporalType.DATE)
  @Column(nullable = false)
  private Date lendingDate;

  @Temporal(TemporalType.DATE)
  private Date returnDate;

  public HistoryRecord(Long id, Book book, User user, Date lendingDate, Date returnDate)
  {
    this.id = id;
    this.book = book;
    this.user = user;
    this.lendingDate = lendingDate;
    this.returnDate = returnDate;
  }

  public HistoryRecord()
  {

  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public Book getBook()
  {
    return book;
  }

  public void setBook(Book book)
  {
    this.book = book;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  public Date getLendingDate()
  {
    return lendingDate;
  }

  public void setLendingDate(Date dateOfLending)
  {
    this.lendingDate = dateOfLending;
  }

  public Date getReturnDate()
  {
    return returnDate;
  }

  public void setReturnDate(Date dateOfReturn)
  {
    this.returnDate = dateOfReturn;
  }
}
