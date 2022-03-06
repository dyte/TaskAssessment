package com.memsource.task.domain;

import com.memsource.task.domain.base.BaseEntity;
import com.memsource.task.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity<User, UserDTO> {

    private String name;
    private String surName;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getSurName(), user.getSurName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurName());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", id='" + getId() + '\'' +
                ", createDate='" + getCreateDate() + '\'' +
                ", updateDate='" + getUpdateDate() + '\'' +
                ", isDeleted='" + isDeleted() + '\'' +
                '}';
    }
}
