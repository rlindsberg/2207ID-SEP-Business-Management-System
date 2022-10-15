package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Request;

import com.SEP.BusinessManagementSystem.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
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
        request.setApprovedBySCS(true);
        return requestRepository.save(request);

    }

    public Request getRequestById(Long id){
        Optional<Request> requestOptional = requestRepository.findById(id);
        if (requestOptional.isEmpty()){
            throw new RuntimeException("request is not found");
        }

        return requestOptional.get();
    }
}
