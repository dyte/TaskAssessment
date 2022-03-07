package com.memsource.task.dto;

import com.memsource.task.dto.base.BaseApiDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseApiDTO {

    private String name;
    private String surName;
    private String userName;

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
