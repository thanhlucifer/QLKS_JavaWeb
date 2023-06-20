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
    public List<room> list( );
    public room getById(long id);
    public List<room> search(String key);






}
