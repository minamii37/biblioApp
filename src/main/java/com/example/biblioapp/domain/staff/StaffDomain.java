package com.example.biblioapp.domain.staff;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StaffDomain {
    private String staffId;

    private String firstName;

    private String familyName;

    private LocalDateTime createDate;

    public StaffDomain(
            String staffId,
            String firstName,
            String familyName,
            LocalDateTime createDate){
        this.staffId = staffId;
        this.firstName = firstName;
        this.familyName = familyName;
        this.createDate = createDate;
    }
}
