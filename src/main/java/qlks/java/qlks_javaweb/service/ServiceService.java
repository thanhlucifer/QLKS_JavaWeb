package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.ServiceRepository;

import java.util.List;


@Service

public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<qlks.java.qlks_javaweb.model.Service> GetAll() {
        return serviceRepository.findAll();
    }
    public qlks.java.qlks_javaweb.model.Service get(long id) {
        return serviceRepository.findById(id).get();
    }
}
