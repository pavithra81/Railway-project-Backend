package com.projectbypp.usermanagementmicroservices.repository;



import com.projectbypp.usermanagementmicroservices.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User,Integer> {
    User findByUserName(String username);
}