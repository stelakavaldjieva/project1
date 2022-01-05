package bg.startit.spring.project1.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService
{
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Role getById(Long id)
  {
    return roleRepository.findById(id).get();
  }

  @Override
  public Role getByRoleName(Role.RoleName roleName)
  {
    return roleRepository.findByRoleName(roleName);
  }

  @Override
  public List<Role> getAll()
  {
    return roleRepository.findAll();
  }

  @Override
  public Role insert(Role role)
  {
    return roleRepository.save(role);
  }

  @Override
  public void delete(Long id)
  {
    roleRepository.deleteById(id);
  }
}
