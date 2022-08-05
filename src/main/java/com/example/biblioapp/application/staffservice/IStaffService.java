package com.example.biblioapp.application.staffservice;

import java.util.ArrayList;

public interface IStaffService {
    String addNewStaff (StaffViewModel view);
    ArrayList<StaffViewModel> getAllStaffs ();
}
