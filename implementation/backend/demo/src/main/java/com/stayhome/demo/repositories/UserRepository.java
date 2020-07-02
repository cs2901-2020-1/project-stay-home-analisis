package com.stayhome.demo.repositories;

import com.stayhome.demo.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;


public interface UserRepository extends JpaRepository<User, BigInteger> {

}