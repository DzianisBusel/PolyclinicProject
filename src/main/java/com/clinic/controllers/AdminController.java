package com.clinic.controllers;

import com.clinic.entities.AvailableTime;
import com.clinic.entities.User;
import com.clinic.repositories.AvailableTimeRepository;
import com.clinic.repositories.RoleRepository;
import com.clinic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/admin_page", method = RequestMethod.GET)
    public String adminPage(final Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin_page";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@RequestParam final Long id, final Model model) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
        {
            User userForRemove = user.get();
            userRepository.delete(userForRemove);
        }
        return "redirect:/admin_page";
    }

    @PostMapping(value = "/add")
    public String addUser(@RequestParam final String firstName, @RequestParam final String lastName,
                          @RequestParam final String login, @RequestParam final String password,
                          @RequestParam(required = false) final String specialization,
                          @RequestParam(required = false) final Integer doctorRoom,
                          @RequestParam(name = "role") String roleUser,
                          final Model model) {
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDoctorRoom(doctorRoom);
        if (specialization != null && specialization.length() > 0) {
            user.setSpecialization(specialization);
        }
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(roleRepository.findByName(roleUser));
        userRepository.save(user);
        return "redirect:/admin_page";
    }

    @PostMapping(value = "/add_time")
    public String addTime(@RequestParam final Long id,
                          @RequestParam(required = false) final String time,
                          final Model model) {
        Optional<User> doctor = userRepository.findById(id);
        if (doctor.isPresent())
        {
            AvailableTime availableTime = new AvailableTime();
            availableTime.setDoctor(doctor.get());
            availableTime.setTime(Timestamp.valueOf(time));
            availableTimeRepository.save(availableTime);
            doctor.get().getAvailableTimes().add(availableTime);
            userRepository.save(doctor.get());
        }

        return "redirect:/admin_page";
    }
}






