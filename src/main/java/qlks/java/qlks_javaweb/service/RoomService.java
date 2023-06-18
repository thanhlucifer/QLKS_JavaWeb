package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.food_item;
import qlks.java.qlks_javaweb.model.room;
import qlks.java.qlks_javaweb.repository.RoomRepository;

import java.util.List;


public interface RoomService {
    public List<room> GetAll();
    public Page<room> list( int pageNo, int pageSize);
    public room getById(long id);
//    public Page<room> searchChamberWithPrice1();
//    public Page<room> searchChamberWithPrice2();




}
