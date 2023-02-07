package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "agents")
public class Agent extends BaseEntity {

    @Column(name = "first_name", nullable = false, unique = true)
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2)
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @ManyToOne
    private Town town;

    public Agent() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
