package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.RoomRepository;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomRepository repo;

    @Override
    public List<room> GetAll() {
        return repo.findAll();
    }

    @Override
    public List<room> list( ) {
        return repo.search();
    }

    @Override
    public List<room> search(String key) {
        return repo.searchRooms(key);
    }

    @Override
    public room getById(long id) {
        return repo.findById(id).get();
    }




}
