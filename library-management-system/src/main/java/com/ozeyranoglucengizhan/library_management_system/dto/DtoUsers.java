package com.ozeyranoglucengizhan.library_management_system.dto;

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

    private String userFirstName;

    private String userLastName;

    private String email;

    private String password;

    private List<Long> borrowedBooksId;



}
