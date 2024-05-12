package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.SkillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillJpaRepository extends JpaRepository<SkillsEntity,Integer> {
}
