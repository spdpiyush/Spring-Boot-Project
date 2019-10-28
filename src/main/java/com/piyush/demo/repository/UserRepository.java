package com.piyush.demo.repository;

/**
 * Created By : Piyush Kumar
 */

import com.piyush.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM UserProfile WHERE UserId =: userId", nativeQuery = true)
    User findByUserId(Long userId);
}
