package com.ozeyranoglucengizhan.library_management_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoUsers {

    @NotNull(message = "User first name can not be null")
    @NotEmpty(message = "User first name can not be empty")
    private String userFirstName;

    @NotNull(message = "User first name can not be null")
    @NotEmpty(message = "User first name can not be empty")
    private String userLastName;

    @Email(message = "Invalid email format. Please enter a valid email address.")
    private String email;

    @NotNull(message = "Password can not be null")
    @NotEmpty(message = "Password can not be empty")
    private String password;
}
