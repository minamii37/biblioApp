package com.example.biblioapp.repository;

import com.example.biblioapp.repository.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepositoryJpa extends JpaRepository<StaffEntity, Integer> {
    List<StaffEntity> findAll();
}
