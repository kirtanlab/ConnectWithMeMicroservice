package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthJpaRepository extends JpaRepository<UsersEntity, Integer> {
    boolean existsByEmail(String email);
    UsersEntity findByEmail(String email);
}
