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
    public Page<room> list( int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repo.search(pageable);
    }

    @Override
    public Page<room> search(String key, int pageNo, int
            pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repo.searchRooms(key, pageable);
    }

    @Override
    public room getById(long id) {
        return repo.findById(id).get();
    }

//    @Override
//    public Page<room> searchChamberWithPrice1() {
//        return repo.searchRoomWithPrice1();
//    }
//
//    @Override
//    public Page<room> searchChamberWithPrice2() {
//        return repo.searchRoomWithPrice2();
//    }


}
