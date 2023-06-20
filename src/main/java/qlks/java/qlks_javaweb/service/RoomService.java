package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Employee;
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

    public List<room> GetAll() {
        return repo.findAll();
    }
    public void save(room room) {
        this.repo.save(room);
    }
    public Page<room> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repo.findAll(pageable);
    }


    public Page<room> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repo.findAll(pageable);
    }

    public Page<room> list( int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repo.search(pageable);
    }
    public Page<room> search(String key, int pageNo, int
            pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repo.searchRooms(key, pageable);
    }
    public void remove(long roomId) {
        repo.deleteById(roomId);
    }
}
