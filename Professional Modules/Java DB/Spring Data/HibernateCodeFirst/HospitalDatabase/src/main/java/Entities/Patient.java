package Entities;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;


@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String address;

    @Column
    private String email;

    @Column(name = "birth_date")
    private LocalDate dateOfBirth;

    @Column
    private Blob picture;

    @Column(name = "has_medical_insurance")
    private boolean hasInsurance;
}
