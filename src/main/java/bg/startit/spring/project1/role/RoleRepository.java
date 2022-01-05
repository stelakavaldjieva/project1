package bg.startit.spring.project1.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long>
{
   Role findByRoleName(Role.RoleName roleName);

  List<Role> findAllByRoleName(Role.RoleName roleName);
}
