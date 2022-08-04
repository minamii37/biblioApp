package com.example.biblioapp.domain.staff;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StaffDomain {
    private String staffId;

    private String staffName;

    private LocalDateTime createDate;

    public StaffDomain(
            String staffId,
            String staffName,
            LocalDateTime createDate){
        this.staffId = staffId;
        this.staffName = staffName;
        this.createDate = createDate;
    }
}
