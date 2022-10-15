package com.SEP.BusinessManagementSystem.Service;

import com.SEP.BusinessManagementSystem.Entity.Request;

import com.SEP.BusinessManagementSystem.Repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
