package com.skillstorm.flightreservationapi.services.unitOfWork;

import com.skillstorm.flightreservationapi.services.interfaces.CityServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;

public interface IUnitOfWork {
    FlightServiceInterface flight();
    CityServiceInterface city();
}
