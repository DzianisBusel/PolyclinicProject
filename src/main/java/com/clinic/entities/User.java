package com.clinic.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String specialization;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column
    private Integer doctorRoom;


    @Column
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<AvailableTime> availableTimes;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patient")
    private List<Ticket> patientTickets;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctor")
    private List<Ticket> doctorTickets;

    @Column(nullable = false)
    private boolean enabled = true;

    public User() {
    }

    public User(String firstName, String lastName, String specialization, String login,
                Integer doctorRoom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.login = login;
        this.doctorRoom = doctorRoom;

    }

    public boolean hasRole(String roleName) {
        Iterator<Role> iterator = this.roles.iterator();
        while (iterator.hasNext()) {
            Role role = iterator.next();
            if (role.getName().equals(roleName)) {
                return true;
            }
        }
        return false;
    }

    public List<AvailableTime> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<AvailableTime> availableTimes) {
        this.availableTimes = availableTimes;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDoctorRoom() {
        return doctorRoom;
    }

    public void setDoctorRoom(Integer doctorRoom) {
        this.doctorRoom = doctorRoom;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Ticket> getPatientTickets() {
        return patientTickets;
    }

    public void setPatientTickets(List<Ticket> patientTickets) {
        this.patientTickets = patientTickets;
    }

    public List<Ticket> getDoctorTickets() {
        return doctorTickets;
    }

    public void setDoctorTickets(List<Ticket> doctorTickets) {
        this.doctorTickets = doctorTickets;
    }


}
