package bg.startit.spring.project1.user;

import java.util.List;

public interface UserService
{
  User findById(Long id);

  List<User> getAll();

  List<User> getByFirstAndLastName(String firstName, String lastName);

  User insert(User user);

  User registration(String email, String password, String checkPassword, String firstName, String lastName);

  void delete(Long id);

  User getByEmail(String email);
}
