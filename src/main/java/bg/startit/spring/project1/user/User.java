package bg.startit.spring.project1.user;

import bg.startit.spring.project1.book.Book;
import bg.startit.spring.project1.role.Role;
import bg.startit.spring.project1.validation.password.StrongPassword;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

//  @NotBlank(message = "First name cannot be blank!")
//  @Column(name = "FIRST_NAME")//, length = 50, nullable = false)
  private String firstName;

//  @NotBlank(message = "Last name cannot be blank!")
//  @Column(name = "LAST_NAME")//, length = 50, nullable = false)
  private String lastName;

//  @Column(unique = true)
  @Email
  @NotBlank(message = "Email cannot be blank!")
  private String email;

  @NonNull
  @NotBlank(message = "New password is mandatory")
  @StrongPassword
  private String password;

  @OneToMany
  @JsonIgnore
  private List<Book> books;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> roles = new ArrayList<>();

  public User()
  {
  }

  public User(String firstName, String lastName, String email, String password)
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public List<Book> getBooks()
  {
    return books;
  }

  public void setBooks(List<Book> books)
  {
    this.books = books;
  }

  public List<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(List<Role> roles)
  {
    this.roles = roles;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }
}
