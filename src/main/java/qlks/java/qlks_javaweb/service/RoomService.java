package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.RoomRepository;

import java.util.List;


@Service
public class RoomService {
    @Autowired
    private RoomRepository repo;

    public room getById(long id) {
        return repo.findById(id).get();
    }

    public List<room> list( ) {
        return repo.search();
    }
    public List<room> search(String key) {
        return repo.searchRooms(key);
    }
    public void save(room room) {
        this.repo.save(room);
    }
    public Page<room> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repo.findAll(pageable);
    }

    public void remove(long id) {
        this.repo.deleteById(id);
    }
}
