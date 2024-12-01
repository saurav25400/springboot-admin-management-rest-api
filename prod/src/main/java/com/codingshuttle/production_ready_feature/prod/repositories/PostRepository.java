package com.codingshuttle.production_ready_feature.prod.repositories;

import com.codingshuttle.production_ready_feature.prod.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

}
