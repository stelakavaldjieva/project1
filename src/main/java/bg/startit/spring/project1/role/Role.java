package bg.startit.spring.project1.role;

import bg.startit.spring.project1.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role implements GrantedAuthority
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private RoleName roleName;

  @JsonBackReference
  @ManyToMany(mappedBy = "roles", cascade = CascadeType.ALL)
  private List<User> users;

  @Override
  public String getAuthority()
  {
    return "ROLE_" + roleName.toString();
  }

  public List<User> getUsers()
  {
    return users;
  }

  public void setUsers(List<User> users)
  {
    this.users = users;
  }

  public void addUser(User user){
    users.add(user);
  }

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

  public RoleName getRoleName()
  {
    return roleName;
  }

  public void setRoleName(RoleName roleName)
  {
    this.roleName = roleName;
  }

  public enum RoleName
  {
    LIBRARIAN,
    USER,
    ADMIN
  }
}
