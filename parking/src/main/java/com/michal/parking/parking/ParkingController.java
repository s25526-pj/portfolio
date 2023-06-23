package com.michal.parking.parking;

import com.michal.parking.parking.model.Parking;
import com.michal.parking.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/parkings")
public class ParkingController {

    private final ParkingService parkingService;

    private final TicketService ticketService;

    @GetMapping
    public String getParkings(Model model) {
        model.addAttribute("parkings", parkingService.findAll());
        return "parking/list";
    }

    @GetMapping("/create")
    public String getParkingCreateForm() {
        return "parking/form";
    }

    @PostMapping("/create")
    public String createParking(Parking parking) {
        parkingService.save(parking);
        return "redirect:/parkings";
    }

    @GetMapping(value = "/history", params = {"parkingId"})
    public String getHistory(@RequestParam("parkingId") int parkingId, Model model) {
        model.addAttribute("parking", parkingService.findById(parkingId));
        model.addAttribute("tickets", ticketService.findAllByParkingId(parkingId));
        return "parking/history";
    }

}
