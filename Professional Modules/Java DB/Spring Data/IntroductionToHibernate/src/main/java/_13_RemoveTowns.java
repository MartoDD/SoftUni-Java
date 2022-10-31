import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class _13_RemoveTowns {
    public static void main(String[] args) {

        final String SELECT_GIVEN_TOWN = "SELECT t FROM Town AS t WHERE t.name=:name";
        final String SELECT_ADDRESSES_IN_A_GIVEN_TOWN = "SELECT a FROM Address AS a WHERE a.town.name=:name";

        final String PRINT_REMOVED_RESULT="%d %s in %s deleted";
        Scanner scanner = new Scanner(System.in);

        EntityManager em = Utils.createEntityManager();

        em.getTransaction().begin();

        String townName = scanner.nextLine();

        List<Address> addresses = em.createQuery(SELECT_ADDRESSES_IN_A_GIVEN_TOWN, Address.class).setParameter("name", townName).getResultList();
        int addressesCount = addresses.size();
        String addressPluralOrNot=addressesCount>1?"addresses":"address";
        addresses.forEach(a->{
            a.getEmployees().forEach(e->e.setAddress(null));
            em.remove(a);
        });

        em.createQuery(SELECT_GIVEN_TOWN, Town.class).setParameter("name", townName).getResultList().forEach(em::remove);

        System.out.printf(PRINT_REMOVED_RESULT,addressesCount,addressPluralOrNot,townName);

        em.getTransaction().commit();
        em.close();
    }
}
