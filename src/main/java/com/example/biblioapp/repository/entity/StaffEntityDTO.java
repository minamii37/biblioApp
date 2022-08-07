package com.example.biblioapp.repository.entity;

import com.example.biblioapp.domain.staff.StaffDomain;

public class StaffEntityDTO {
    public static StaffEntity fromDomain(StaffDomain domain){
        return new StaffEntity(
                domain.getStaffId(),
                domain.getFamilyName(),
                domain.getFirstName(),
                domain.getCreateDate());
    }

    public static StaffDomain fromEntity(StaffEntity entity){
        return new StaffDomain(
                entity.getStaffId(),
                entity.getFamilyName(),
                entity.getFirstName(),
                entity.getCreateDate());
    }
}
