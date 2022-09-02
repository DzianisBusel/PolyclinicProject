package com.clinic.controllers;

import com.clinic.repositories.AvailableTimeRepository;
import com.clinic.repositories.RoleRepository;
import com.clinic.repositories.TicketRepository;
import com.clinic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AvailableTimeRepository availableTimeRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(final Model model) {
//        Calendar calendar = Calendar.getInstance();
//       Ticket ticket = new Ticket();
//       ticket.setDate(calendar);
//       User doctor = new User();
//       doctor.setFirstName("Gregory");
//       doctor.setLastName("Hause");
//       doctor.setDoctorRoom(123);
//       doctor.setSpecialization("diagnostician");
//       doctor.setLogin("doc");
//       doctor.setPassword(passwordEncoder.encode("doc"));
//        Role role = new Role();
//        role.setName("ROLE_DOCTOR");
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        doctor.setRoles(roles);
//        roleRepository.save(role);
//       userRepository.save(doctor);
//                Role role3 = new Role();
//                role3.setName("ROLE_PATIENT");
//                roleRepository.save(role3);
//       User patient = new User();
//        patient.setFirstName("Vagon");
//        patient.setLastName("Oboev");
//        patient.setLogin("vag");
//        patient.setPassword(passwordEncoder.encode("vag"));
//        patient.setRoles(Collections.singleton(role3));
//       userRepository.save(patient);
//       User admin = new User();
//        admin.setFirstName("Andrey");
//        admin.setLastName("Admin");
//        admin.setLogin("admin1");
//        admin.setPassword(passwordEncoder.encode("admin"));
//        Role role = new Role();
//        role.setName("ROLE_ADMIN");
//        roleRepository.save(role);
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        admin.setRoles(roles);
//       userRepository.save(admin);
//       ticket.setDoctor(doctor);
//       ticket.setPatient(patient);
//       ticketRepository.save(ticket);
//       List<User> users = (List<User>) userRepository.findAll();
//       users.stream().forEach(user -> System.out.println(user.getPatientTickets()));
//        System.out.println("--------------------------");
//       users.stream().forEach(user -> System.out.println(user.getDoctorTickets()));
//        User doctor = userRepository.findById(2l).get();
//        AvailableTime availableTime = new AvailableTime();
//        availableTime.setDoctor(doctor);
//        Date date = new Date();
//        availableTime.setTime(new Timestamp(date.getTime()));
//        availableTimeRepository.save(availableTime);
//        AvailableTime availableTime2 = new AvailableTime();
//        availableTime2.setDoctor(doctor);
//        date.setYear(2019);
//        availableTime2.setTime(new Timestamp(date.getTime()));
//        availableTimeRepository.save(availableTime2);
//        List<AvailableTime> at = new ArrayList<>();
//        at.add(availableTime);
//        at.add(availableTime2);
//        doctor.setAvailableTimes(at);
//        userRepository.save(doctor);
        return "home";
    }

 }
