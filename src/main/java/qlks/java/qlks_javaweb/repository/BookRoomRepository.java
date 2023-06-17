package qlks.java.qlks_javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlks.java.qlks_javaweb.model.Rental;

@Repository
public interface BookRoomRepository extends JpaRepository<Rental,Long> {

}
