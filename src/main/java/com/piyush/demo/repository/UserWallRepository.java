package com.piyush.demo.repository;

/**
 * Created By : Piyush Kumar
 */

import com.piyush.demo.model.UserWall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserWallRepository extends JpaRepository<UserWall, Long> {

    @Query(value = "SELECT * FROM  userPosts WHERE userId = :userId", nativeQuery = true)
    List<UserWall> findByUserId(Long userId);

}
