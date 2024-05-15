package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.UserProjectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectsJpaRepository extends JpaRepository<UserProjectsEntity,Integer> {
    boolean existsByProjectTitle(String projectTitle);
}
