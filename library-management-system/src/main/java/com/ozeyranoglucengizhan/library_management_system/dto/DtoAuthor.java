package com.ozeyranoglucengizhan.library_management_system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoAuthor {

    @NotNull(message = "Author name can not be null")
    @NotEmpty(message = "Author name can not be empty")
    private String authorName;

    @NotNull(message = "Author lastname can not be null")
    @NotEmpty(message = "Author lastname can not be empty")
    private String authorLastName;

}
