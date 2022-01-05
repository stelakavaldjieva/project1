package bg.startit.spring.project1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>
{
  List<User> findByFirstNameAndLastName(String firstname, String lastname);

  User findByEmail(String email);
}
