package bg.startit.spring.project1.user;

import bg.startit.spring.project1.user.dto.UserRegisterRequest;
import bg.startit.spring.project1.user.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController
{

  private final UserService userService;

  public UserController(UserService userService)
  {
    this.userService = userService;
  }

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAll()
  {
    List<User> users = userService.getAll();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<User> getById(@RequestParam(value = "user_id", required = false, defaultValue = "1") Long id)
  {
    return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
  }

  @GetMapping("/first_and_last_name")
  public ResponseEntity<List<User>> getByFirstAndLastName(@RequestParam(value = "first_name") String firstName,
                                                          @RequestParam(value = "last_name") String lastName)
  {
    return new ResponseEntity<>(userService.getByFirstAndLastName(firstName, lastName), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<User> insert(@RequestBody User user)
  {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
  }

  @PostMapping("/registration")
  public ResponseEntity<UserResponse> registration(@RequestBody UserRegisterRequest dto)
  {
    User user = userService.registration(dto.getEmail(), dto.getPassword(), dto.getCheckPassword(), dto.getFirstName(), dto.getLastName());
    return new ResponseEntity<>(new UserResponse().setEmail(user.getEmail()).setFirstName(user.getFirstName()).setLastName(user.getLastName()), HttpStatus.CREATED);
  }

  @DeleteMapping("/{user_id}")
  public void delete(@PathVariable("user_id") Long id)
  {
    userService.delete(id);
  }

  @PutMapping()
  public ResponseEntity<User> update(@RequestBody User user)
  {
    return new ResponseEntity<>(userService.insert(user), HttpStatus.OK);
  }
}
