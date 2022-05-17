package com.revature.repositories;

import com.revature.models.Stomp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StompRepository extends JpaRepository<Stomp, Integer> {
}
