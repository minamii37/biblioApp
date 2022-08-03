package com.example.biblioapp.Repositories;

import com.example.biblioapp.domain.staff.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
    List<StaffEntity> findAll();
}
