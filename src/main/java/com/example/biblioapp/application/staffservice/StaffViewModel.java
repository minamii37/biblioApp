package com.example.biblioapp.application.staffservice;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class StaffViewModel {
    private String id;

    @NotNull
    @NotBlank
    private String name;

    private LocalDate createDate;
}
