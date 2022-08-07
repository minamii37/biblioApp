package com.example.biblioapp.repository;

import com.example.biblioapp.domain.repository.IStaffRepository;
import com.example.biblioapp.domain.staff.StaffDomain;
import com.example.biblioapp.repository.entity.StaffEntityDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StaffRepositoryImpl implements IStaffRepository {
    private final StaffRepositoryJpa staffRepositoryJpa;

    public StaffRepositoryImpl(StaffRepositoryJpa staffRepositoryJpa){
        this.staffRepositoryJpa = staffRepositoryJpa;
    }

    @Override
    public ArrayList<StaffDomain> getAllStaffs () {
        var staffs = staffRepositoryJpa.findAll();
        var staffDomains = new ArrayList<StaffDomain>();
        staffs.forEach(x -> staffDomains.add(StaffEntityDTO.fromEntity(x)));
        return staffDomains;
    }

    @Override
    public void save (StaffDomain domain) {
        var entity = StaffEntityDTO.fromDomain(domain);
        staffRepositoryJpa.save(entity);
    }
}
