package com.michal.parking.car.model;

//import com.michal.test3.parking.model.Parking;
import com.michal.parking.parking.model.Parking;
import com.michal.parking.ticket.model.Ticket;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;

    @ManyToOne
    private Parking parking;

    @OneToMany(mappedBy = "car")
    private Set<Ticket> tickets;

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }


}