package bg.startit.spring.project1.user.dto;

public class UserResponse
{
  private String email;
  private String firstName;
  private String lastName;

  public String getEmail()
  {
    return email;
  }

  public UserResponse setEmail(String email)
  {
    this.email = email;
    return this;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public UserResponse setFirstName(String firstName)
  {
    this.firstName = firstName;
    return this;
  }

  public String getLastName()
  {
    return lastName;
  }

  public UserResponse setLastName(String lastName)
  {
    this.lastName = lastName;
    return this;
  }
}
