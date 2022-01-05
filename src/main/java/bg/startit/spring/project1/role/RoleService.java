package bg.startit.spring.project1.role;

import java.util.List;

public interface RoleService
{
  Role getById(Long id);

  Role getByRoleName(Role.RoleName roleName);

  List<Role> getAll();

  Role insert(Role role);

  void delete(Long id);
}
