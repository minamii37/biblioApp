package com.example.biblioapp.application.staffservice;

import com.example.biblioapp.domain.staff.StaffDomain;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
public class StaffViewModel {
    private String id;

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
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

    public StaffViewModel fromDomain(StaffDomain domain){
        return new StaffViewModel(
                domain.getStaffId(),
                domain.getFirstName(),
                domain.getFamilyName(),
                domain.getCreateDate());
    }

    public StaffDomain fromView(){
        return new StaffDomain(
                this.id,
                this.firstName,
                this.familyName,
                this.createDate);
    }
}
