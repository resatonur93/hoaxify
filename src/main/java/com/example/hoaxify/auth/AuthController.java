package com.example.hoaxify.auth;

import com.example.hoaxify.error.ApiError;
import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/api/1.0/auth")
    ResponseEntity<?> handleAuthentication(@RequestHeader (name ="Authorization", required = false) String authorization){
        if (authorization == null){
            ApiError error = new ApiError(401,"Unauthorized request","/api/1.0/auth");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
        log.info(authorization);
        return ResponseEntity.ok().build();
    }
}
