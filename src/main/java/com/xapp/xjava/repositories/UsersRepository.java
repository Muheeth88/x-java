package com.xapp.xjava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xapp.xjava.entities.UserEntity;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}