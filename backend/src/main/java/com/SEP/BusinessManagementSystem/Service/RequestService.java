package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Request;

import com.SEP.BusinessManagementSystem.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    private final RequestRepository requestRepository;
    @Autowired
    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }


    public Request createNewRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request approveRequestBySCSById(Long id){
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isEmpty()){
            throw new RuntimeException("request is not found");
        }
        Request request = requestOptional.get();

        //set approved to true
        request.setApprovedBySCS(true);
        //set reviewed to true
        request.setReviewedBySCS(true);
        return requestRepository.save(request);

    }

    // pre-condition: SCS reviews/approves the request
    public Request approveRequestByFMById(Long id){
        //Optional<Request> requestOptional = requestRepository.findById(id);
        Optional<Request> requestOptional = requestRepository.findRequestByIdByFM(id);
        if (!requestOptional.isPresent()){
            throw new RuntimeException("request is not found or not approved by Senior Customer Service");
        }
        Request request = requestOptional.get();

        //set approved to true
        request.setApprovedByFinancialManager(true);
        //set reviewed to true
        request.setReviewedByFinancialManager(true);
        return requestRepository.save(request);

    }

    // pre-condition: FM reviews/approves the request
    public Request approveRequestByAMById(Long id){
//        Optional<Request> requestOptional = requestRepository.findById(id);
//        if (requestOptional.isEmpty()){
//            throw new RuntimeException("request is not found");
//        }
        Optional<Request> requestOptional = requestRepository.findRequestByIdByAM(id);
        if (!requestOptional.isPresent()){
            throw new RuntimeException("request is not found or is not approved by Financial Manager");
        }
        Request request = requestOptional.get();

        //set approved to true
        request.setApprovedByAdminManager(true);
        //set reviewed to true
        request.setReviewedByAdminManager(true);
        return requestRepository.save(request);

    }

    public Request rejectRequestBySCSById(Long id){
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isEmpty()){
            throw new RuntimeException("request is not found");
        }
        Request request = requestOptional.get();

        //set approved to false
        request.setApprovedBySCS(false);
        //set reviewed to true
        request.setReviewedBySCS(true);

        return requestRepository.save(request);

    }

    public Request rejectRequestByFMById(Long id){
        //Optional<Request> requestOptional = requestRepository.findById(id);
        Optional<Request> requestOptional = requestRepository.findRequestByIdByFM(id);
        if (!requestOptional.isPresent()){
            throw new RuntimeException("request is not found or is not approved by Senior Customer Service");
        }
        Request request = requestOptional.get();

        //set approved to false
        request.setApprovedByFinancialManager(false);
        //set reviewed to true
        request.setReviewedByFinancialManager(true);

        return requestRepository.save(request);

    }

    public Request rejectRequestByAMById(Long id){
        Optional<Request> requestOptional = requestRepository.findRequestByIdByAM(id);
        if (!requestOptional.isPresent()){
            throw new RuntimeException("request is not found or is not approved by Financial Manager");
        }
        Request request = requestOptional.get();

        //set approved to false
        request.setApprovedByAdminManager(false);
        //set reviewed to true
        request.setReviewedByAdminManager(true);

        return requestRepository.save(request);

    }

    public Request getRequestById(Long id){
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isEmpty()){
            throw new RuntimeException("request is not found");
        }

        return requestOptional.get();
    }

    public Request finalizeRequestBySCSById(Long id) {
        Optional<Request> requestOptional = requestRepository.findRequestByIdBySCS(id);
        if (!requestOptional.isPresent()){
            throw new RuntimeException("request is not found or has not been decided");
        }
        Request request = requestOptional.get();

        request.setFinalized(true);
        return requestRepository.save(request);
    }
}
