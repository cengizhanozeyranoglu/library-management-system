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
public class DtoReturnBookRequest {

    @NotNull(message = "BorrowBook id can not be null.")
    private Long borrowedBookId;
}
