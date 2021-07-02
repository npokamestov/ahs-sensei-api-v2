package com.adhocsensei.ahssenseiapi.dao;

import com.adhocsensei.ahssenseiapi.dto.Sensei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenseiRepository extends JpaRepository<Sensei, Long> {
    List<Sensei> findByUserId(Long userId);
    List<Sensei> findByCourseId(Long courseId);
}
