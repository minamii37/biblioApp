package com.example.biblioapp.application.staffservice;

import com.example.biblioapp.domain.staff.StaffDomain;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StaffViewModel {
    private String id;

    private String firstName;

    private String familyName;

    private LocalDateTime createDate;

    public StaffViewModel(
            String id,
            String firstName,
            String familyName,
            LocalDateTime createDate){
        this.id = id;
        this.firstName = firstName;
        this.familyName = familyName;
        this.createDate = createDate;
    }

    public StaffViewModel (){
    }

    public StaffViewModel fromDomain(StaffDomain domain){
        return new StaffViewModel(
                domain.getStaffId(),
                domain.getFamilyName(),
                domain.getFirstName(),
                domain.getCreateDate());
    }

    public StaffDomain fromView(){
        return new StaffDomain(
                this.id,
                this.familyName,
                this.firstName,
                this.createDate);
    }
}
