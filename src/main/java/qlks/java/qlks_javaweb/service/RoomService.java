package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.RoomRepository;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repo;

    public List<room> getbyName() {

        return repo.search();
    }
    public room getById(long id) {
        return repo.findById(id).get();
    }


}
