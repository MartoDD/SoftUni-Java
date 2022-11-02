package Entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location_name")
    private String locationName;

    @OneToMany(mappedBy = "storeLocation")
    private java.util.Set<Sale> sales;

    public StoreLocation() {
    }


    public int getId() {
        return id;
    }

    public StoreLocation(int id, String locationName) {
        this.id = id;
        this.locationName = locationName;
        this.sales = new HashSet<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
