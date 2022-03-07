package com.memsource.task.domain;

import com.memsource.task.domain.base.BaseEntity;
import com.memsource.task.dto.UserSettingsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserSettings extends BaseEntity<UserSettings, UserSettingsDTO> {

    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @Override
    public String toString() {
        return "UserSettings{" +
                "password='" + password + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
