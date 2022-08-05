package com.example.biblioapp.repository.entity;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class StaffEntity {
    @Id
    private String staffId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private LocalDateTime createDate;

    protected StaffEntity () {
    }

    public StaffEntity(
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
