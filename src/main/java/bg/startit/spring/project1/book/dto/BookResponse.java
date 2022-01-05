package bg.startit.spring.project1.book.dto;

import java.math.BigDecimal;

public class BookResponse
{
  private Long id;

  private String isbn;

  private String title;

  private String author;

  private BigDecimal price;

  private Integer stock;

  private Integer year;

  public Long getId()
  {
    return id;
  }

  public BookResponse setId(Long id)
  {
    this.id = id;
    return this;
  }

  public String getIsbn()
  {
    return isbn;
  }

  public BookResponse setIsbn(String isbn)
  {
    this.isbn = isbn;
    return this;
  }

  public String getTitle()
  {
    return title;
  }

  public BookResponse setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public String getAuthor()
  {
    return author;
  }

  public BookResponse setAuthor(String author)
  {
    this.author = author;
    return this;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public BookResponse setPrice(BigDecimal price)
  {
    this.price = price;
    return this;
  }

  public Integer getStock()
  {
    return stock;
  }

  public BookResponse setStock(Integer stock)
  {
    this.stock = stock;
    return this;
  }

  public Integer getYear()
  {
    return year;
  }

  public BookResponse setYear(Integer year)
  {
    this.year = year;
    return this;
  }
}
