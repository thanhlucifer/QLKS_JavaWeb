package qlks.java.qlks_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qlks.java.qlks_javaweb.model.Rental;
import qlks.java.qlks_javaweb.repository.BookRoomRepository;

@Service
public class BookRoomService {
    @Autowired
    private BookRoomRepository bookRoomRepository;

    public void add(Rental newRental)
    {
    bookRoomRepository.save(newRental);
    }


}
