package com.adhocsensei.ahssenseiapi.dao;

import com.adhocsensei.ahssenseiapi.dto.Sensei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenseiRepository extends JpaRepository<Sensei, Long> {}
