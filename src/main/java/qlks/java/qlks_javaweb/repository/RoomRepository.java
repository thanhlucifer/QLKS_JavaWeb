package qlks.java.qlks_javaweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import qlks.java.qlks_javaweb.model.room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<room,Long> {

    @Query(value = "SELECT c FROM room c where c.isEmpty='yes'")
    Page<room> search(Pageable pageable);

//    @Query("SELECT d FROM room d where d.price<180000 and d.isEmpty ='yes'")
//    Page<room> searchRoomWithPrice1();
//
//    @Query("SELECT e FROM room e where e.price>180000 and e.isEmpty ='yes'")
//    Page<room> searchRoomWithPrice2();

    @Query("SELECT p FROM room p WHERE p.roomNumber like %:key%")
    Page<room> searchProducts(@Param("key") String key, Pageable pageable);








}
