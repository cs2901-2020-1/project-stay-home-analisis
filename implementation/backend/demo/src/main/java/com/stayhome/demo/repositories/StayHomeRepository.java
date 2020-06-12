package com.stayhome.demo.repositories;

import com.stayhome.demo.data.StayHome;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigInteger;


public interface StayHomeRepository extends JpaRepository<StayHome, BigInteger> {

}