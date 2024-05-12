package com.ConnectWithMe.Users.JpaRepository;

import com.ConnectWithMe.Users.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryJpaRepository extends JpaRepository<CountryEntity, Integer> {
}