package com.clinic.repositories;


import com.clinic.entities.Ticket;
import com.clinic.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    List<Ticket> findByDoctor(User user);
}
