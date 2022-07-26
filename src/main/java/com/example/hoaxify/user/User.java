package com.example.hoaxify.user;

import lombok.Data;
import org.springframework.validation.annotation.Validated;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "USERS")
@Validated
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "{hoaxify.constraints.username.NotNull.message}")
    @Size(min=3, max=20)
    @UniqueUsername
    private String username;

    @NotNull
    @Size(min=3, max=20)
    private String displayName;

    @Size(min=8, max=255)
    @NotNull
    @Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$" , message = "{hoaxify.constraints.password.Pattern.message}")
    private String password;

    private String image;

}
