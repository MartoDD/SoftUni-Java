package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mechanics")
public class Mechanic extends BaseEntity{

    @Column(name = "first_name",nullable = false,unique = true)
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    @Size(min = 2)
    private String lastName;

    @Column(nullable = false,unique = true)
    @Email
    private String email;

    @Column(unique = true)
    @Size(min = 2)
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
