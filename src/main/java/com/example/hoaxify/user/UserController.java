package com.example.hoaxify.user;



import com.example.hoaxify.error.ApiError;
import com.example.hoaxify.shared.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @PostMapping("/api/1.0/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        String username = user.getUsername();
        if(username == null ||  username.isEmpty()){
            ApiError error = new ApiError(400,"Validation failed","/api/1.0/users");
            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("username", "Username cannot be null");
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        userService.save(user);
        return ResponseEntity.ok(new GenericResponse("User created successfully"));


    }

}
