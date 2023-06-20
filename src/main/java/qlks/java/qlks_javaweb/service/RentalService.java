package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Employee;
import qlks.java.qlks_javaweb.model.Rental;
import qlks.java.qlks_javaweb.model.User;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.RentalRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    @Autowired
    private RentalRepository repo;

    public List<Rental> GetAll() {
        return repo.findAll();
    }
    public void remove(long rentalId) {
        repo.deleteById(rentalId);
    }

    public Rental getRentalById(Long rentalId) {
        return repo.findById(rentalId).orElse(null);
    }
}
