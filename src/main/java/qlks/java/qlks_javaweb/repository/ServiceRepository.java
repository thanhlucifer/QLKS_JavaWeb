package qlks.java.qlks_javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlks.java.qlks_javaweb.model.Section;
import qlks.java.qlks_javaweb.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
}
