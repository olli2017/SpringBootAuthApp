package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// DON'T WORK
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AuthController.class)
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    public void whenValidInputThenReturns200() throws Exception {
//        Mockito.when(userService.register(new SignupRequest())).thenThrow(RuntimeException.class);
        mockMvc.perform(post("/signup")
                .contentType("application/json")
                .content("{\"username\":\"ayd\",\n" +
                        " \"password\":\"1\",\n" +
                        " \"email\":\"dsd\"\n" +
                        " }")
        )
                .andExpect(status().isOk());

    }
}
