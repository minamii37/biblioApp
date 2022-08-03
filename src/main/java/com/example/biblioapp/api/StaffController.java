package com.example.biblioapp.api;

import com.example.biblioapp.Repositories.StaffRepository;
import com.example.biblioapp.domain.staff.StaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping(path = "/biblioApp/staff")
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewStaff(@RequestParam String name){
        StaffEntity staff = new StaffEntity();
        staff.setId(UUID.randomUUID().toString());
        staff.setName(name);
        staff.setCreateDate(LocalDateTime.now());
        staffRepository.save(staff);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<StaffEntity> getAllStaffs() {
        return staffRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
