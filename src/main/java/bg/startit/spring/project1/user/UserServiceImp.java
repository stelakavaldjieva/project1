package bg.startit.spring.project1.user;

import bg.startit.spring.project1.role.Role;
import bg.startit.spring.project1.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService
{
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleService    roleService;

  @Override
  public User findById(Long id)
  {
    return userRepository.findById(id).get();
  }

  @Override
  public List<User> getAll()
  {
    return userRepository.findAll();
  }

  @Override
  public List<User> getByFirstAndLastName(String firstName, String lastName)
  {
    return userRepository.findByFirstNameAndLastName(firstName, lastName);
  }

  @Override
  public User insert(User user)
  {
    Role role = new Role();
    role.setRoleName(Role.RoleName.USER);
    user.setRoles(List.of(role));
    return userRepository.save(user);
  }

  @Override
  public User registration(String email, String password, String checkPassword, String firstName, String lastName)
  {
    if (userRepository.findByEmail(email)!=null) throw new IllegalArgumentException("This email is already registered!");
    if (!password.equals(checkPassword)) {
      throw new BadCredentialsException("Passwords do not match!");
    }
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.getRoles().add(roleService.getByRoleName(Role.RoleName.USER));
    return userRepository.save(user);
  }

  @Override
  public void delete(Long id)
  {
    userRepository.deleteById(id);
  }

  @Override
  public User getByEmail(String email)
  {
    return userRepository.findByEmail(email);
  }
}
