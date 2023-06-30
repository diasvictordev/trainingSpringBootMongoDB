package com.mongodbtraining.mongotraining.repository;

import com.mongodbtraining.mongotraining.domain.Post;
import com.mongodbtraining.mongotraining.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
