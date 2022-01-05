package bg.startit.spring.project1.comment;

import bg.startit.spring.project1.book.Book;
import bg.startit.spring.project1.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Comment
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String text;


  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "book")
//  @JsonIgnore
  private Book book;

  @OnDelete(action = OnDeleteAction.CASCADE)
  @ManyToOne
  @JoinColumn
  private User user;

  public Comment()
  {
  }

  public Comment(String text, Book book, User user)
  {
    this.text = text;
    this.book = book;
    this.user = user;
  }


  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getText()
  {
    return text;
  }

  public void setText(String text)
  {
    this.text = text;
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
}
