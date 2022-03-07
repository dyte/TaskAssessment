package com.memsource.task.dto;

import com.memsource.task.dto.base.BaseApiDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSettingsDTO extends BaseApiDTO {

    private String password;

    private Long userId;

}
