package com.project.rentacar.repository;

import com.project.rentacar.domain.CarType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarTypeRepository extends CrudRepository<CarType, Long> {

    List<CarType> findAll();

}

