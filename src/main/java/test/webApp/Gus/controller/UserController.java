package test.webApp.Gus.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.webApp.Gus.entity.User;
import test.webApp.Gus.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.FOUND);
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        return  ResponseEntity.ok(userService.getUser(email));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> delete(@PathVariable("email") String email){
        userService.delete(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@RequestBody User user){
        return ResponseEntity.ok(userService.update(user));
    }

    @GetMapping("/current")
    public ResponseEntity<User> getById() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }
}