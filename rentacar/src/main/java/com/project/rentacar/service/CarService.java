package com.project.rentacar.service;

import com.project.rentacar.domain.Car;
import com.project.rentacar.domain.Rent;
import com.project.rentacar.repository.CarRepository;
import com.project.rentacar.repository.CarTypeRepository;
import com.project.rentacar.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;
    private CarTypeRepository carTypeRepository;
    private RentRepository rentRepository;

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Autowired
    public void setCarTypeRepository(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    @Autowired
    public void rentRepository(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public List<Car> getCars() {

        return carRepository.findAll();
    }

    public Car getCarByRegistrationPlate(String registrationPlate) {
        return carRepository.findByRegistrationPlate(registrationPlate);
    }

    public String saveRent(Rent newRent, String registrationPlate)
    {
        String returnPage = "cars";

        Rent collidingRent = rentRepository.findRentByDateFromAndDateTo(newRent.getDateFrom(), newRent.getDateTo(), registrationPlate);

        if (collidingRent == null)
        {
            Car rentalCar = getCarByRegistrationPlate(registrationPlate);
            newRent.setCar(rentalCar);
            rentRepository.save(newRent);
            returnPage = "rentsuccess";
        }

        else
        {
            returnPage = "rentfailure";
        }

        return returnPage;

    }

}
