package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateJpaRepository extends JpaRepository<StateEntity, Integer> {
}