package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Section;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.ServiceRepository;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<qlks.java.qlks_javaweb.model.Service> getAll() {
        return serviceRepository.findAll();
    }

    public void save(qlks.java.qlks_javaweb.model.Service service) {
        this.serviceRepository.save(service);
    }

    public void remove(long serviceId) {
        serviceRepository.deleteById(serviceId);
    }
}
