package com.alberto.gi.bookingdemo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alberto.gi.bookingdemo.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "SELECT * FROM room r "
    		+ "JOIN hotel h on h.id = r.hotel "
    		+ "JOIN city c on c.id = h.city "
    		+ "WHERE :code in(h.code, c.code) "
    		+ "AND r.cupo > 0", nativeQuery = true)
    List<Room> findRoomsByCode(@Param("code") String code);
 
}