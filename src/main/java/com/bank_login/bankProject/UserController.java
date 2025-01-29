package com.bank_login.bankProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // Change this to Controller to serve HTML views
public class UserController {

    @Autowired
    private UserService userService;

    // Show the login/register page using template1
    @GetMapping("/login-register")
    public String showLoginRegisterPage(Model model) {
        return "index"; // Return the Thymeleaf template name (template1.html)
    }

    // Create a new user with POST mapping
    @PostMapping("/login-register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    // Show all users in template2
    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> users = userService.getAllUsers(); // Fetch the list of users
        model.addAttribute("users", users); // Add the user list to the model
        return "userForm"; // Return the Thymeleaf template name (template2.html)
    }

    // REST API to fetch all users
    @GetMapping("/users/usersData")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Read a single user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}