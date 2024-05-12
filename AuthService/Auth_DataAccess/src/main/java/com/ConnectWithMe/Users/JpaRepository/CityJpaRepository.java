package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityJpaRepository extends JpaRepository<CityEntity, Integer> {
}
