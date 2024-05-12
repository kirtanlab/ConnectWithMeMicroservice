package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.CollegesInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeInfoJpaRepository extends JpaRepository<CollegesInfoEntity, Integer> {
}
