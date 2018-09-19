package com.project.rentacar.repository;

import com.project.rentacar.domain.Car;
import com.project.rentacar.domain.CarType;
import com.project.rentacar.domain.Rent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    @Query(value = "SELECT r.* FROM Rent r JOIN Car c ON r.car_id = c.id WHERE c.registration_plate = :carregplate AND ((:datefrom BETWEEN r.date_from and r.date_to) OR (:dateto BETWEEN r.date_from and r.date_to)) LIMIT 1", nativeQuery = true)
    Rent findRentByDateFromAndDateTo(@Param("datefrom") Date dateFrom, @Param("dateto") Date dateTo, @Param("carregplate") String carRegPlate);

}

