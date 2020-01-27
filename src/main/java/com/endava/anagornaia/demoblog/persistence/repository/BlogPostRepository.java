package com.endava.anagornaia.demoblog.persistence.repository;

import com.endava.anagornaia.demoblog.persistence.model.BlogPostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPostEntity, Long> {
}
