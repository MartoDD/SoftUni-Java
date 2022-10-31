import entities.Address;

import javax.persistence.EntityManager;
import java.util.List;

public class _7_AddressesWithEmployeeCount {
    public static void main(String[] args) {

        EntityManager em = Utils.createEntityManager();

        final String GET_ADDRESSES="select a FROM Address AS a ORDER BY a.employees.size desc";
        final String PRINT_ADDRESS_INFORMATION="%s, %s - %d employees%n";

        em.getTransaction().begin();
        List<Address> addresses = em.createQuery(GET_ADDRESSES, Address.class).setMaxResults(10).getResultList();

        for (Address address : addresses) {
            String townName = address.getTown() == null ? "" : address.getTown().getName();
            System.out.printf(PRINT_ADDRESS_INFORMATION,address.getText(),townName,address.getEmployees().size());
        }

        em.getTransaction().commit();
        em.close();

    }
}
