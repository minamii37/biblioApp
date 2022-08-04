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
    private String staffName;

    @Column(nullable = false)
    private LocalDateTime createDate;

    protected StaffEntity () {

    }

    public StaffEntity(
            String staffId,
            String staffName,
            LocalDateTime createDate){
        this.staffId = staffId;
        this.staffName = staffName;
        this.createDate = createDate;
    }

}
