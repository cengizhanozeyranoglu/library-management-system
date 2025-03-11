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
public class DtoBooks {

    private String title;

    private Integer publicationYear;

    private String state;

    private Long authorId;

    private List<Long> categoryId;

}
