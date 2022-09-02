package com.clinic.controllers;

import com.clinic.configurations.MyUserDetails;
import com.clinic.entities.AvailableTime;
import com.clinic.entities.Ticket;
import com.clinic.entities.User;
import com.clinic.repositories.AvailableTimeRepository;
import com.clinic.repositories.TicketRepository;
import com.clinic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Timestamp;
import java.util.List;


@Controller
public class PatientController {

    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/patient_page", method = RequestMethod.GET)
    public String patientPage(final Model model) {
        model.addAttribute("users", userRepository.getUsersBySpezialization());

        return "patient_page";
    }

    @PostMapping(value = "/book")
    public String isBooked(@RequestParam(name = "doctorId") final Long doctorId,
                           @RequestParam(name = "time") final String date,
                           Authentication authentication, final Model model) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        Ticket ticket = new Ticket();
        ticket.setPatient(userDetails.getUser());
        final User doctor = userRepository.findById(doctorId).get();
        ticket.setDoctor(doctor);
        Timestamp selectedDate = Timestamp.valueOf(date);
        ticket.setDate(selectedDate);
        ticketRepository.save(ticket);
        removeAvailableTimeForDoctor(doctor, selectedDate);
        return "redirect:/patient_page";
    }

    private void removeAvailableTimeForDoctor(User doctor, Timestamp selectedDate) {
        List<AvailableTime> availableTimes = doctor.getAvailableTimes();
        AvailableTime timeForRemove = null;
        for (AvailableTime availableTime : availableTimes) {
            if (availableTime.getTime().equals(selectedDate)) {
                availableTimes.remove(availableTime);
                timeForRemove = availableTime;
                break;
            }
        }
        if (timeForRemove != null) {
            doctor.setAvailableTimes(availableTimes);
            userRepository.save(doctor);
            availableTimeRepository.delete(timeForRemove);
        }

    }

}



