package com.michal.parking.ticket;

import com.michal.parking.car.model.Car;
import com.michal.parking.parking.model.Parking;
import com.michal.parking.ticket.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> findAllByCarId(int carId) {
        return ticketRepository.findAllByCarId(carId);
    }

    public List<Ticket> findAllByParkingId(int parkingId) {
        return ticketRepository.findAllByParkingId(parkingId);
    }

    public Ticket save(Car car, Parking parking) {
        Ticket ticket = Ticket.builder()
                .car(car)
                .parking(parking)
                .arrival(LocalDateTime.now())
                .build();
        car.getTickets().add(ticket);
        parking.getTickets().add(ticket);
        return ticketRepository.save(ticket);
    }
    @Transactional
    public void leaveParking(Car car) {
        Ticket ticket = ticketRepository.findByCarIdAndLeavingIsNull(car);
        ticket.setLeaving(LocalDateTime.now());
        ticketRepository.leaveParking(car, LocalDateTime.now());
    }

}
