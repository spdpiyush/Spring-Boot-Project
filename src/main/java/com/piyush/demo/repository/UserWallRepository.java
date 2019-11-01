package com.piyush.demo.repository;

/**
 * Created By : Piyush Kumar
 */

import com.piyush.demo.model.UserWall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserWallRepository extends JpaRepository<UserWall, Long> {
}
