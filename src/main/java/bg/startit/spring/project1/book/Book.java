package bg.startit.spring.project1.book;

import bg.startit.spring.project1.comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Book implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  @NotEmpty(message = "ISBN cannot be empty")
  private String isbn;

  @NotBlank(message = "Title cannot be empty")
  @Size(min = 1, max = 30, message = "Book outside of size bounds")
  private String title;

  @NotBlank(message = "Author name cannot be empty")
  private String author;

  @DecimalMin(value = "0.0", inclusive = false)
  private BigDecimal price;

  @Min(value = 1)
  private Integer stock;

  @Min(value = 1800)
  @Max(value = 2021)
  private Integer year;

  @OneToMany(mappedBy = "book")
  @JsonIgnore
  private List<Comment> comments;

  public Book()
  {

  }

  public Book(String isbn, String title, String author, BigDecimal price, Integer stock, Integer year)
  {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.price = price;
    this.stock = stock;
    this.year = year;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public String getIsbn()
  {
    return isbn;
  }

  public void setIsbn(String isbn)
  {
    this.isbn = isbn;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor(String author)
  {
    this.author = author;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public void setPrice(BigDecimal price)
  {
    this.price = price;
  }

  public Integer getStock()
  {
    return stock;
  }

  public void setStock(Integer stock)
  {
    this.stock = stock;
  }

  public Integer getYear()
  {
    return year;
  }

  public void setYear(Integer releaseYear)
  {
    this.year = releaseYear;
  }

  public List<Comment> getComments()
  {
    return comments;
  }

  public Book setComments(List<Comment> comments)
  {
    this.comments = comments;
    return this;
  }

  @Override
  public String toString()
  {
    return "Book{" +
        "id=" + id +
        ", isbn='" + isbn + '\'' +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        ", releaseYear=" + year +
        '}';
  }
}
