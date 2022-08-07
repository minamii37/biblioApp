package com.example.biblioapp.api;

import com.example.biblioapp.application.staffservice.IStaffService;
import com.example.biblioapp.application.staffservice.StaffViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/biblioApp/staff")
public class StaffController {
    private final IStaffService staffService;

    public StaffController (IStaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewStaff(@RequestBody @Validated StaffViewModel view){
        staffService.addNewStaff(view);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<StaffViewModel> getAllStaffs() {
        return staffService.getAllStaffs();
    }
}
