package com.paul.store.dto;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name;
    private String email;
}
