package bg.startit.spring.project1.user.dto;

public class UserRegisterRequest
{
  private String email;
  private String password;
  private String checkPassword;
  private String firstName;
  private String lastName;

  public String getEmail()
  {
    return email;
  }

  public UserRegisterRequest setEmail(String email)
  {
    this.email = email;
    return this;
  }

  public String getPassword()
  {
    return password;
  }

  public String getCheckPassword()
  {
    return checkPassword;
  }

  public UserRegisterRequest setCheckPassword(String checkPassword)
  {
    this.checkPassword = checkPassword;
    return this;
  }

  public UserRegisterRequest setPassword(String password)
  {
    this.password = password;
    return this;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public UserRegisterRequest setFirstName(String firstName)
  {
    this.firstName = firstName;
    return this;
  }

  public String getLastName()
  {
    return lastName;
  }

  public UserRegisterRequest setLastName(String lastName)
  {
    this.lastName = lastName;
    return this;
  }
}
