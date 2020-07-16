package com.stayhome.demo.repositories;

import com.stayhome.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;


public interface UserRepository extends JpaRepository<User, BigInteger> {


}