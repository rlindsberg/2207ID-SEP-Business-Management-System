package com.SEP.BusinessManagementSystem.Service;
import com.SEP.BusinessManagementSystem.Entity.HRApplication;
import com.SEP.BusinessManagementSystem.Entity.Task;
import com.SEP.BusinessManagementSystem.Repository.HRApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HRApplicationService {
    private final HRApplicationRepository hrApplicationRepository;


    @Autowired
    public HRApplicationService(HRApplicationRepository hrApplicationRepository) {
        this.hrApplicationRepository = hrApplicationRepository;
    }

    public HRApplication getHRApplicationById(Long id){
        Optional<HRApplication> HRApplicationOptional = hrApplicationRepository.findById(id);
        if (HRApplicationOptional.isEmpty()) {
            throw new RuntimeException("HR Application not found!");
        }
        return HRApplicationOptional.get();
    }

    public HRApplication createNewHRApplication(HRApplication hrApplication) {

        return hrApplicationRepository.save(hrApplication);
    }

    public HRApplication addComment(Long id, String comment) {
        Optional<HRApplication> hrApplicationOptional = hrApplicationRepository.findById(id);
        if (hrApplicationOptional.isEmpty()) {
            throw new RuntimeException("HRApplication not found!");
        }
        HRApplication hrApplication = hrApplicationOptional.get();
        hrApplication.setCommentFromHR(comment);
        return hrApplicationRepository.save(hrApplication);
    }
}
