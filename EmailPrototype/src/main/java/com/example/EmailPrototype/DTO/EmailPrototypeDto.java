package com.example.EmailPrototype.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmailPrototypeDto {
    private String username;
    private String Email;
    private String password;
}
