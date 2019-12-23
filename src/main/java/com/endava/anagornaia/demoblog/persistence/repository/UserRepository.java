package com.endava.anagornaia.demoblog.persistence.repository;

import com.endava.anagornaia.demoblog.persistence.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
