package com.paul.store.dto;

import com.paul.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 255)
    private String name;

    @NotBlank
    @Email(message = "Email must be valid")
    @Lowercase(message = "email must be in lowercase")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 25, message = "Must be between 6-25 chars")
    private String password;
}
