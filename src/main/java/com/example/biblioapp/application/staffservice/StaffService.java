package com.example.biblioapp.application.staffservice;

import com.example.biblioapp.domain.repository.IStaffRepository;
import com.example.biblioapp.domain.staff.StaffDomain;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

@Service
public class StaffService implements IStaffService{
    private final IStaffRepository staffRepository;

    public StaffService(IStaffRepository staffRepository){
        this.staffRepository = staffRepository;
    }

    @Override
    public String addNewStaff (StaffViewModel view) {
        var domain = createNewStaffDomainFromView(view);
        domain.checkForSaving();
        staffRepository.save(domain);

        return "Saved";
    }

    @Override
    public ArrayList<StaffViewModel> getAllStaffs () {
        var staffDomains = staffRepository.getAllStaffs();
        var views = new ArrayList<StaffViewModel>();
        staffDomains.forEach(x ->{
            var view = new StaffViewModel();
            views.add(view.fromDomain(x));
        });
        views.sort(Comparator.comparing(StaffViewModel::getCreateDate));

        return views;
    }

    private StaffDomain createNewStaffDomainFromView(StaffViewModel view) {
        return new StaffDomain(
                UUID.randomUUID().toString(),
                view.getFamilyName(),
                view.getFirstName(),
                LocalDateTime.now()
        );
    }
}
