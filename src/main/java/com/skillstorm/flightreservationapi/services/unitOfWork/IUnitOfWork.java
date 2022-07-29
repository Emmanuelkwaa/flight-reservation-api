package com.skillstorm.flightreservationapi.services.unitOfWork;

import com.skillstorm.flightreservationapi.services.interfaces.AirportServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.CityServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.FlightServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.SeatServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.TicketServiceInterface;
import com.skillstorm.flightreservationapi.services.interfaces.UserServiceInterface;

public interface IUnitOfWork {
    FlightServiceInterface flight();
    CityServiceInterface city();
    AirportServiceInterface airport();
    UserServiceInterface user();
    TicketServiceInterface ticket();
    SeatServiceInterface seat();
}
