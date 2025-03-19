package com.ozeyranoglucengizhan.library_management_system.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError <E>{

    private String path;

    private LocalDate createTime;

    private E message;

    private Integer status;
}
