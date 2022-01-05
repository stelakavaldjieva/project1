package bg.startit.spring.project1.book.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class BookRequest
{

  @NotEmpty(message = "ISBN cannot be empty")
  private String isbn;

  @NotBlank(message = "Title cannot be empty")
  @Size(min = 1, max = 30, message = "Book outside of size bounds")
  private String title;

  @Pattern(regexp = "^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\\\/<>?:;|=.,]{1,20}$", message = "Not a valid name for author")
  private String author;

  private BigDecimal price;

  private Integer stock;

  @Min(value = 1800)
  @Max(value = 2021)
  private Integer year;


  public String getIsbn()
  {
    return isbn;
  }

  public BookRequest setIsbn(String isbn)
  {
    this.isbn = isbn;
    return this;
  }

  public String getTitle()
  {
    return title;
  }

  public BookRequest setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public String getAuthor()
  {
    return author;
  }

  public BookRequest setAuthor(String author)
  {
    this.author = author;
    return this;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public BookRequest setPrice(BigDecimal price)
  {
    this.price = price;
    return this;
  }

  public Integer getStock()
  {
    return stock;
  }

  public BookRequest setStock(Integer stock)
  {
    this.stock = stock;
    return this;
  }

  public Integer getYear()
  {
    return year;
  }

  public BookRequest setYear(Integer year)
  {
    this.year = year;
    return this;
  }
}
