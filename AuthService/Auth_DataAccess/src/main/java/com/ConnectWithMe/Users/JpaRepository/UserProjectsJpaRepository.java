package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.UserProjectsEntity;
import com.ConnectWithMe.Users.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProjectsJpaRepository extends JpaRepository<UserProjectsEntity,Integer> {
    boolean existsByProjectTitle(String projectTitle);
//    List<Integer> findProjectIDsByuser(UsersEntity user);
}
