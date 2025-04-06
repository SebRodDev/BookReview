package bookreviews.demo;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 
 * This receives HTTP request and delegates them to a 
 * service layer that is forwarded back - basically the bread and butter
 * 
 * HTTP method determine the target method for the request
 *
 * Both the user and homework service will be inside this one controller
 * 
 * --------------------- NOTE -----------------------
 * 
 * GetMapping - use when a client wants to get information without directly changing anything to the server
 * PostMapping - use when a client sends information to be ADDED to the server 
 * 
 */
@RestController // central artifact in the RESTful API
@RequestMapping("/api/users") // this is the api call that we use to call the backend from the frontend I believe
@CrossOrigin(origins = { "*" })
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user") // used to indicate that this will handle HTTP requests and return the response as a JSON file
    public ResponseEntity<User> createUser(@RequestBody User user) { // the RequestBody annotation is used to bind the HTTP request to a parameter in a controller method
        // basically says that the information that the client will send data alongside their request body
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }


    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id) ? ResponseEntity.ok("User with ID: " + id + " successfully deleted") : 
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user with ID: " + id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login/user")
    public ResponseEntity<User> findUserByUsername(@RequestBody LoginRequest loginRequest) {
        Optional<User> foundUserOptional = userService.findUserByUsername(loginRequest.getUsername(), loginRequest.getPassword());
        User foundUser = foundUserOptional.get();
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        } else {
        return ResponseEntity.ok(foundUser);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserByID(@PathVariable Long id) {
        Optional<User> foundUser = userService.findUserByID(id);
        return foundUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/update/user/{id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable Long id, @RequestBody User newUserInfo) {
        Optional<User> updatedUserInfo = userService.updateUserInfo(id, newUserInfo);
        return updatedUserInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}