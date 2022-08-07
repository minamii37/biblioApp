package com.example.biblioapp.domain.staff;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class StaffDomain {
    private String staffId;

    private String familyName;

    private String firstName;

    private LocalDateTime createDate;

    public StaffDomain(
            String staffId,
            String familyName,
            String firstName,
            LocalDateTime createDate){
        this.staffId = staffId;
        this.familyName = familyName;
        this.firstName = firstName;
        this.createDate = createDate;
    }

    public void checkForSaving(){
        if(familyName == null || familyName.isEmpty() || familyName.isBlank()){
            throw new IllegalArgumentException("苗字は必須入力項目です");
        }
        if (firstName == null || firstName.isEmpty() || firstName.isBlank()){
            throw new IllegalArgumentException("名前は必須入力項目です");
        }
    }
}
