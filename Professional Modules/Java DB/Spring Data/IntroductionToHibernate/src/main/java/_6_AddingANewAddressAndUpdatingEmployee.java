import entities.Address;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class _6_AddingANewAddressAndUpdatingEmployee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EntityManager em = Utils.createEntityManager();


        final String UPDATE_EMPLOYEE="Update Employee e SET e.address=:ad WHERE e.lastName=:lm";
        em.getTransaction().begin();

        String lastName=scanner.nextLine();
        String addressText="Vitoshka 15";
        Address address = new Address();
        address.setText(addressText);
        em.persist(address);

        em.createQuery(UPDATE_EMPLOYEE).setParameter("ad",address).setParameter("lm",lastName).executeUpdate();

        em.getTransaction().commit();
        em.close();
    }
}
