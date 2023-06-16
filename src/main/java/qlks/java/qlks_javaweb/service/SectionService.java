package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Employee;
import qlks.java.qlks_javaweb.model.Section;
import qlks.java.qlks_javaweb.repository.SectionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;
    public List<Section> getAll() {
        return sectionRepository.findAll();
    }

    public Section getSectionById(long id){
        Optional<Section> optional = sectionRepository.findById(id);
        Section section = null;
        if (optional.isPresent()) {
            section = optional.get();
        } else {
            throw  new RuntimeException("Section not found for id :: " + id);
        } return section;
    }
}
