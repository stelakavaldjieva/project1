package bg.startit.spring.project1.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController
{
  @Autowired
  private RoleService roleService;

  @GetMapping("/all")
  public ResponseEntity<List<Role>> getAll()
  {
    List<Role> roles = roleService.getAll();
    return new ResponseEntity<>(roles, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Role> getById(@RequestParam(value = "role_id", required = false, defaultValue = "1") Long id)
  {
    return new ResponseEntity<>(roleService.getById(id), HttpStatus.OK);
  }
  //TODO getByRoleName
//  @GetMapping
//  public ResponseEntity<Role> getRoleName()
//  {
//    return new ResponseEntity<>(roleService.getByRoleName(), HttpStatus.OK);
//  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id)
  {
    roleService.delete(id);
  }

  @PutMapping()
  public ResponseEntity<Role> update(@RequestBody Role role)
  {
    return new ResponseEntity<>(roleService.insert(role), HttpStatus.OK);
  }
}
