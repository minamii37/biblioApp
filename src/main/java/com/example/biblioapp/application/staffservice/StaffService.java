package com.example.biblioapp.application.staffservice;

import com.example.biblioapp.domain.repository.IStaffRepository;

import java.util.ArrayList;

public class StaffService implements IStaffService{
    private final IStaffRepository staffRepository;

    public StaffService(IStaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    @Override
    public String addNewStaff (StaffViewModel view) {
        var domain = view.fromView();
        staffRepository.save(domain);

        return "Saved";
    }

    @Override
    public ArrayList<StaffViewModel> getAllStaffs () {

    }
}
