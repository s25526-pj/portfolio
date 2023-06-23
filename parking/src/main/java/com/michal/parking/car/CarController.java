package com.michal.parking.car;

import com.michal.parking.car.model.Car;
import com.michal.parking.parking.ParkingService;
import com.michal.parking.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final ParkingService parkingService;

    private final TicketService ticketService;



    @GetMapping
    public String getCars(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "car/list";
    }

    @GetMapping("/create")
    public String getCarCreateForm(Model model) {
        return "car/form";
    }

    @PostMapping("/create")
    public String createCar(Car car) {
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping(value = "/park", params = {"carId"})
    public String getCarParkForm(@RequestParam("carId") int carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        model.addAttribute("parkings", parkingService.findAll());
        return "car/parkCar";
    }

    @PostMapping(value = "/park", params = {"carId", "parkingId"})
    public String park(
            @RequestParam("carId") int carId,
            @RequestParam("parkingId") int parkingId
    ) {
        carService.park(carId, parkingId);
        return "car/list";
    }

    @PutMapping(value = "/leaveParking", params = {"carId"})
    public String leaveParking(@RequestParam("carId") int carId) {
        carService.leaveParking(carId);
        return "/car/list";
    }

    @GetMapping(value = "/history", params = {"carId"})
    public String getHistory(@RequestParam("carId") int carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        model.addAttribute("tickets", ticketService.findAllByCarId(carId));
        return "car/history";
    }

}
