package com.example.biblioapp.api;

import com.example.biblioapp.repository.StaffRepositoryJpa;
import com.example.biblioapp.application.staffservice.StaffViewModel;
import com.example.biblioapp.repository.entity.StaffEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping(path = "/biblioApp/staff")
public class StaffController {
    @Autowired
    private StaffRepositoryJpa staffRepositoryJpa;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewStaff(@RequestBody @Validated StaffViewModel view){
        StaffEntity staff = new StaffEntity(
                UUID.randomUUID().toString(),
                view.getFirstName(),
                view.getFamilyName(),
                LocalDateTime.now());
        staffRepositoryJpa.save(staff);

        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<StaffEntity> getAllStaffs() {
        return staffRepositoryJpa.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
