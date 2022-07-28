package com.skillstorm.flightreservationapi.services.unitOfWork;

import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;

public interface UnitOfWorkInterface {
    FlightServiceInterface flight();
}
