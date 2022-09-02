package com.clinic.controllers;

import com.clinic.configurations.MyUserDetails;
import com.clinic.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DoctorController {

    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(value = "/doctor_page", method = RequestMethod.GET)
    public String doctorPage(Authentication authentication, final Model model) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        model.addAttribute("tickets", ticketRepository.findByDoctor(userDetails.getUser()));
        return "doctor_page";
    }
}
