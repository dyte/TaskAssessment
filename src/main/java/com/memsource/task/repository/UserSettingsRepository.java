package com.memsource.task.repository;

import com.memsource.task.domain.UserSettings;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserSettingsRepository extends CrudRepository<UserSettings, Long> {

    Optional<UserSettings> findOneByUserId(Long userId);
}
