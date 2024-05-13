package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.UserSkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillJpaRepository extends JpaRepository<UserSkillsEntity , Integer> {
}
