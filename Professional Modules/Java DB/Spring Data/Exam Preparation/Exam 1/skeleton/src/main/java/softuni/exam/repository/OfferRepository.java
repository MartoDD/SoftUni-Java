package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.entity.enums.ApartmentType;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o  WHERE o.apartment.apartmentType = 'three_rooms' order by o.apartment.area desc, o.price" )
    List<Offer> findOffersByApartmentType();

    List<Offer> findAllByApartment_ApartmentTypeOrderByApartment_AreaDescPriceAsc(ApartmentType apartment_apartmentType);


}
