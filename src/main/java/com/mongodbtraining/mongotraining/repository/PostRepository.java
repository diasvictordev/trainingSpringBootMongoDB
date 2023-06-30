package com.mongodbtraining.mongotraining.repository;

import com.mongodbtraining.mongotraining.domain.Post;
import com.mongodbtraining.mongotraining.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> findByTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);


}
