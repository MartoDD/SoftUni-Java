package com.example.football.models.entity;

import com.example.football.models.enums.PlayerPosition;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PlayerPosition position;

    @ManyToOne
    private Team team;

    @OneToOne
    private Stat stat;

    @ManyToOne
    private Town town;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return String.format("Player - %s %s%n      Position - %s%n     Team - %s%n     Stadium - %s", this.firstName, this.lastName, this.position, getTeam().getName(), getTeam().getStadiumName());
    }
}
