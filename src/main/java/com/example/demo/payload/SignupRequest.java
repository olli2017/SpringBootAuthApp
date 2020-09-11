package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    private String username;

    private String email;

    private String password;
}
