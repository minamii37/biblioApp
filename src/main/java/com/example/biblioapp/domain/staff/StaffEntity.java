package com.example.biblioapp.domain.staff;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class StaffEntity {
    @Id
    private String id;

    private String name;

    private LocalDateTime createDate;
}
