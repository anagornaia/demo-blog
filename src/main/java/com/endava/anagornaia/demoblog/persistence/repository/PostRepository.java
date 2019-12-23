package com.endava.anagornaia.demoblog.persistence.repository;

import com.endava.anagornaia.demoblog.persistence.model.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
