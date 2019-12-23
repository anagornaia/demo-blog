package com.endava.anagornaia.demoblog.persistence.repository;

import com.endava.anagornaia.demoblog.persistence.model.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
