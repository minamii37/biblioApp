package com.example.biblioapp.domain.repository;

import com.example.biblioapp.domain.staff.StaffDomain;

import java.util.ArrayList;

public interface IStaffRepository {
    ArrayList<StaffDomain> getAllStaffs ();

    void save(StaffDomain staffDomain);
}
