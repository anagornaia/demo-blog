package com.endava.anagornaia.demoblog.persistence.repository;

import com.endava.anagornaia.demoblog.persistence.model.TagEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<TagEntity, Long> {
}
